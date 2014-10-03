package org.fao.fenix.amis.policy.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dao {

    @Resource(lookup = "java:jboss/postgresqllocal")
    private DataSource datasource;

    public Connection getJNDIConnection() throws SQLException {
        return datasource.getConnection();
    }

}
