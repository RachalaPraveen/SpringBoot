package com.srai.tenant.hibernate;

import com.srai.model.repository.ClientMetadataRepository;
import com.srai.model.repository.PersonRepository;
import com.srai.tenant.TenantContext;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

@Component
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {

  private static final long serialVersionUID = 6246085840652870138L;
  
  @Value("${liquibase.enable}")
  private String liqubaseEnable;
  
  @Autowired
  private DataSource dataSource;

  @Override
  public Connection getAnyConnection() throws SQLException {
    return dataSource.getConnection();
  }

  @Override
  public void releaseAnyConnection(Connection connection) throws SQLException {
    connection.close();
  }

  @Override
  public Connection getConnection(String tenantIdentifier) throws SQLException {
    final Connection connection = getAnyConnection();
    try {
      connection.createStatement().execute( "USE " + tenantIdentifier );
      
    //liquibase Integration START
      if (liqubaseEnable.equalsIgnoreCase("yes")) {
    	  Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
          Liquibase liquibase = new liquibase.Liquibase("main.xml", new ClassLoaderResourceAccessor(), database);

          liquibase.update(new Contexts(), new LabelExpression());
	}
      // END liquibase Integrtion
    }
    catch ( SQLException e ) {
      throw new HibernateException(
          "Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]",e);
    }catch (DatabaseException e) {
  	  throw new HibernateException("DatabaseException For Liquibase",e);
} catch (LiquibaseException e) {
	 throw new HibernateException("LiquibaseException For Liquibase ",e);
}
    return connection;
  }

  @Override
  public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
    try {
      connection.createStatement().execute( "USE " + TenantContext.DEFAULT_TENANT );
    }
    catch ( SQLException e ) {
      throw new HibernateException(
          "Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]",
          e
          );
    }
    connection.close();
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean isUnwrappableAs(Class unwrapType) {
    return false;
  }

  @Override
  public <T> T unwrap(Class<T> unwrapType) {
    return null;
  }

  @Override
  public boolean supportsAggressiveRelease() {
    return true;
  }

}