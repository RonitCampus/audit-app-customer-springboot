package com.audit.app.customer.Login.controller;

import com.audit.app.customer.Login.model.LoginForm;
import com.audit.app.customer.Login.model.LoginResponse;
import com.audit.app.customer.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by matth on 6/10/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/user/api/v1")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/Login")
    public ResponseEntity<LoginResponse> doLogin(@RequestBody final LoginForm loginForm) throws SQLException, InterruptedException {

        System.out.println(loginForm.getUsername());

        LoginResponse loginResponse = this.loginService.doLogin(loginForm);

        if( null == loginResponse.getErrorMessage() && null != loginResponse.getAuthToken()) {
            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.UNAUTHORIZED);
        }

    }

}
