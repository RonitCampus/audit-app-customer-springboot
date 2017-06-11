package com.audit.app.customer.view.all.ncs.service;

import com.audit.app.customer.Login.model.LoginForm;
import com.audit.app.customer.Login.model.LoginResponse;
import com.audit.app.customer.view.all.ncs.model.NcInfo;
import com.audit.app.customer.view.all.ncs.model.UserNcDetailInfo;
import com.audit.app.customer.view.all.ncs.model.UserNcUpdate;
import com.audit.app.customer.view.all.ncs.repository.ViewAllNcsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class ViewAllNcsService
{
    @Autowired
    private ViewAllNcsRepository viewAllNcsRepository;
    @Autowired
    private ApplicationContext applicationContext;


    public List<NcInfo> getAllNcsForUser(String authToken) throws SQLException {
        return this.viewAllNcsRepository.getAllNcsForUser(this.extractUserName(authToken));
    }

    private String extractUserName(String authToken){
        String upstring = new String(Base64.getDecoder().decode(new String(Base64.getDecoder().decode(authToken))));
        String username = upstring.split(":")[0];
        return username;
    }

    private String extractPassword(String authToken){
        String upstring = new String(Base64.getDecoder().decode(new String(Base64.getDecoder().decode(authToken))));
        String password = upstring.split(":")[1];
        return password;
    }

    public UserNcDetailInfo getNcDetailInfo(int ncId, String authToken) throws SQLException, InterruptedException {
        return this.viewAllNcsRepository.getNcDetailInfo(ncId, this.extractUserName(authToken));
    }

    public Boolean updateNc(UserNcUpdate userNcUpdate, String authToken) throws SQLException {
        return this.viewAllNcsRepository.updateNc(userNcUpdate, this.extractUserName(authToken));
    }
}
