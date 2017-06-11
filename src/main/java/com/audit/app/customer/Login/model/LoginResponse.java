package com.audit.app.customer.Login.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by matth on 6/10/2017.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    private String authToken = null;
    private String errorMessage = null;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "authToken='" + authToken + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
