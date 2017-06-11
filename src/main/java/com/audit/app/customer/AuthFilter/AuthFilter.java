package com.audit.app.customer.AuthFilter;

import com.audit.app.customer.Login.model.LoginForm;
import com.audit.app.customer.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Enumeration;


/**
 * Created by matth on 6/9/2017.
 */
@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private LoginService loginService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(httpServletRequest.getRequestURL());


        if(null == loginService){
            ServletContext servletContext = httpServletRequest.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            loginService = webApplicationContext.getBean(LoginService.class);
        }


        String authToken = httpServletRequest.getHeader("authToken");
        if(null!=authToken){

            try {
                String upstring = new String(Base64.getDecoder().decode(new String(Base64.getDecoder().decode(authToken))));
                String username = upstring.split(":")[0];
                String password = upstring.split(":")[1];
                LoginForm loginForm = new LoginForm();
                loginForm.setUsername(username);
                loginForm.setPassword(password);

                try {
                    this.loginService.doLogin(loginForm);//If not valid will throw error
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Not Authorized");
                httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            }
        }

    }
}
