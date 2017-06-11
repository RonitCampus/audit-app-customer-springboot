package com.audit.app.customer.view.all.ncs.controller;

import com.audit.app.customer.view.all.ncs.model.NcInfo;
import com.audit.app.customer.view.all.ncs.model.UserNcDetailInfo;
import com.audit.app.customer.view.all.ncs.model.UserNcUpdate;
import com.audit.app.customer.view.all.ncs.service.ViewAllNcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping("auth/user/api/v1/viewAll")
public class ViewAllNcsController
{
    private final ViewAllNcsService viewAllNcsService;

    @Autowired
    public ViewAllNcsController (final ViewAllNcsService viewAllNcsService)
    {
        this.viewAllNcsService = viewAllNcsService;
    }

    @GetMapping("/Ncs")
    public ResponseEntity<List<NcInfo>> getAllNcsForUser(HttpServletRequest httpServletRequest) throws SQLException {

        String authToken = httpServletRequest.getHeader("authToken");
        return new ResponseEntity<>(this.viewAllNcsService.getAllNcsForUser( authToken ), HttpStatus.OK);
    }


    @GetMapping("/NcDetail/{ncId}")
    public ResponseEntity<UserNcDetailInfo> getNcDetailInfo(@PathVariable("ncId") final int ncId, HttpServletRequest httpServletRequest) throws SQLException, InterruptedException {
        String authToken = httpServletRequest.getHeader("authToken");
        return new ResponseEntity<>(this.viewAllNcsService.getNcDetailInfo(ncId,authToken) , HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateNc(@RequestBody final UserNcUpdate userNcUpdate, HttpServletRequest httpServletRequest) throws SQLException {
        String authToken = httpServletRequest.getHeader("authToken");
        return new ResponseEntity<Boolean>( this.viewAllNcsService.updateNc(userNcUpdate, authToken), HttpStatus.OK );
    }


}
