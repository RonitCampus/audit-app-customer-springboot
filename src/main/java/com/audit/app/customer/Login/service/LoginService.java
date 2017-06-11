package com.audit.app.customer.Login.service;

import com.audit.app.customer.Login.model.LoginForm;
import com.audit.app.customer.Login.model.LoginResponse;
import com.audit.app.customer.Login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.sql.SQLException;

/**
 * Created by matth on 6/10/2017.
 */
@Service
public class LoginService {

    private LoginRepository loginRepository;

    private ApplicationContext applicationContext;

    @Autowired
    public LoginService(LoginRepository loginRepository, ApplicationContext applicationContext) {
        this.loginRepository = loginRepository;
        this.applicationContext = applicationContext;
    }

    public LoginService() {
    }

    public LoginResponse doLogin(final LoginForm loginForm) throws SQLException {

        LoginResponse loginResponse = this.applicationContext.getBean(LoginResponse.class);

        if( null != loginForm.getUsername() && loginForm.getUsername().length() < 1 &&
                null != loginForm.getPassword() && loginForm.getPassword().length() < 1){
            System.out.println("username password not proper format");
            loginResponse.setErrorMessage("username password not proper");
        }
        else{
            if(this.loginRepository.doLogin(loginForm)){
                String enc1 = new BASE64Encoder().encode(String.valueOf(loginForm.getUsername() + ":" + loginForm.getPassword() ).getBytes());
                String enc2 = new BASE64Encoder().encode(enc1.getBytes());
                loginResponse.setAuthToken(enc2);
                return loginResponse;
            }
            else{
                System.out.println("Invalid Username Password.");
                loginResponse.setErrorMessage("Invalid Username Password.");
            }
        }

        return loginResponse;

    }
}
