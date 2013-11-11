package com.cta.test;

import javax.sql.DataSource;

import org.apache.commons.io.Charsets;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class DbSetupExecutionListener extends AbstractTestExecutionListener { 
	
	protected DataSource datasource;
	
	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		DataSource datasource = testContext.getApplicationContext().getBean(DataSource.class);
		
		executeDatabaseScripts(datasource, 
				"/sql/clean-all-tables.sql", 
				"/sql/test-fake.sql");
	}
	
	/**
	 * Utilise les fichiers indiques pour remplir la base de donnees. Ces
	 * fichiers doivent etre dans le classpath.
	 */
	protected void executeDatabaseScripts(DataSource datasource, String... scriptFiles) {
		ResourceDatabasePopulator pop = new ResourceDatabasePopulator();
		pop.setSqlScriptEncoding(Charsets.UTF_8.name());

		for (String scriptFile : scriptFiles) {
			pop.addScript(new ClassPathResource(scriptFile));
		}

		DatabasePopulatorUtils.execute(pop, datasource);
	}
}