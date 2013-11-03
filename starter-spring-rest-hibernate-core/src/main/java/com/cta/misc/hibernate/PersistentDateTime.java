package com.cta.misc.hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.EnhancedUserType;
import org.joda.time.DateTime;

public class PersistentDateTime implements EnhancedUserType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final PersistentDateTime INSTANCE = new PersistentDateTime();

    private static final int[] SQL_TYPES = new int[] { Types.TIMESTAMP, };

    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    public Class<?> returnedClass() {
        return DateTime.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        DateTime dtx = (DateTime) x;
        DateTime dty = (DateTime) y;

        return dtx.equals(dty);
    }

    public int hashCode(Object object) throws HibernateException {
        return object.hashCode();
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    public String objectToSQLString(Object object) {
        throw new UnsupportedOperationException();
    }

    public String toXMLString(Object object) {
        return object.toString();
    }

    public Object fromXMLString(String string) {
        return new DateTime(string);
    }

	@Override
	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		return arg0;
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3) throws HibernateException, SQLException {
        Object timestamp = StandardBasicTypes.TIMESTAMP.nullSafeGet(arg0, arg1, arg2, arg3);
        if (timestamp == null) {
            return null;
        }

        return new DateTime(timestamp);
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3) throws HibernateException, SQLException {
        if (arg1 == null) {
            StandardBasicTypes.TIMESTAMP.nullSafeSet(arg0, null, arg2, arg3);
        } else {
            StandardBasicTypes.TIMESTAMP.nullSafeSet(arg0, ((DateTime) arg1).toDate(), arg2, arg3);
        }
	}

}