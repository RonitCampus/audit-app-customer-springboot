package com.audit.app.customer.dbConfig;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Infocepts India in 2017.
 */
@Component
public class DbConfig
{

    private static Connection connection = null;

    private static boolean isHome = false;

    static
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            if (isHome)
                connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=AuditDB", "auditdb", "admin123");
            else
                connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=AuditDB", "auditdb", "admin123");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private DbConfig ()
    {
    }

    public static Connection getInstance () throws SQLException
    {
        if (null != connection)
            return connection;
        throw new SQLException("Database Initialization failed");
    }

}
