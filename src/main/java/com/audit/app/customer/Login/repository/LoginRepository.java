package com.audit.app.customer.Login.repository;

import com.audit.app.customer.Login.model.LoginForm;
import com.audit.app.customer.dbConfig.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by matth on 6/10/2017.
 */

@Repository
public class LoginRepository {
    private final ApplicationContext applicationContext;
    private final Connection connection;

    @Autowired
    public LoginRepository (final ApplicationContext applicationContext) throws SQLException {
        this.applicationContext = applicationContext;
        this.connection = DbConfig.getInstance();
    }

    public boolean doLogin(final LoginForm loginForm) throws SQLException {

        String sql= String.format("select * from AuthTable where userName='%s' and password='%s'", loginForm.getUsername(), loginForm.getPassword());

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next())
            return true;
        return false;
    }

}
