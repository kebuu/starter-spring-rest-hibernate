package com.cta.dao.impl;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.cta.dao.AbstractDao;
import com.cta.dao.CrudDao;
import com.cta.dao.TableToMapResultTransformer;
import com.cta.dto.crud.CrudResult;
import com.cta.dto.crud.CrudResult.CrudOperation;

@Slf4j
@Service
public class DefaultCrudDao extends AbstractDao implements CrudDao {

	@Override
	public CrudResult create(Object resource) {
		return crudOperation(resource, CrudOperation.CREATE, new CrudAction() {
			
			@Override
			public void process(Session session, Object resource) {
				getHibernateSession().persist(resource);
			}
		});
	}

	@Override
	public CrudResult update(Object resource) {
		return crudOperation(resource, CrudOperation.UPDATE, new CrudAction() {
			
			@Override
			public void process(Session session, Object resource) {
				getHibernateSession().update(resource);
			}
		});
	}

	@Override
	public CrudResult delete(Object resource) {
		return crudOperation(resource, CrudOperation.DELETE, new CrudAction() {
			
			@Override
			public void process(Session session, Object resource) {
				Object mergedResource = getHibernateSession().merge(resource);
				getHibernateSession().delete(mergedResource);
			}
		});
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<? extends Object> list(String resourceClassName) {
		return getHibernateSession().createQuery("from " + resourceClassName).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, ? extends Object>> listShort(String resourceClassName, Class<?> resourceClass) {
		Session hibernateSession = getHibernateSession();
		SQLQuery sqlQuery = hibernateSession.createSQLQuery("select * from " + resourceClassName);
		sqlQuery.setResultTransformer(new TableToMapResultTransformer(hibernateSession.getSessionFactory(), resourceClass));
		return sqlQuery.list();
	}
	
	@Override
	public Object get(Class<?> resourceClass, Long id) {
		return getHibernateSession().get(resourceClass, id);
	}
	
	protected CrudResult crudOperation(Object resource, CrudOperation crudOperation, CrudAction crudAction) {
		CrudResult result = new CrudResult(); 
		result.setOperation(crudOperation);
		result.setData(resource);
		
		try {
			crudAction.process(getHibernateSession(), resource);
		} catch (Exception e) {
			result.setOk(false);
			result.setMessage(e.getMessage());
			log.warn(e.getMessage(), e);
		}
		
		return result;
	}
	
	public interface CrudAction {
		public void process(Session session, Object resource);
	}
}
