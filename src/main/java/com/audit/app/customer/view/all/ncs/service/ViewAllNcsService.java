package com.audit.app.customer.view.all.ncs.service;

import com.audit.app.customer.view.all.ncs.repository.ViewAllNcsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class ViewAllNcsService
{
    private final ViewAllNcsRepository viewAllNcsRepository;

    @Autowired
    public ViewAllNcsService (final ViewAllNcsRepository viewAllNcsRepository)
    {
        this.viewAllNcsRepository = viewAllNcsRepository;
    }
}
