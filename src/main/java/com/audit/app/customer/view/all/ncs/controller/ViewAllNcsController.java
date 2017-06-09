package com.audit.app.customer.view.all.ncs.controller;

import com.audit.app.customer.view.all.ncs.service.ViewAllNcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping("user/api/v1/viewAll")
public class ViewAllNcsController
{
    private final ViewAllNcsService viewAllNcsService;

    @Autowired
    public ViewAllNcsController (final ViewAllNcsService viewAllNcsService)
    {
        this.viewAllNcsService = viewAllNcsService;
    }

    @GetMapping("/{}")

}
