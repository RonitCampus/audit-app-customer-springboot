package com.audit.app.customer.view.all.ncs.repository;

import com.audit.app.customer.dbConfig.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Infocepts India in 2017.
 */
@Repository
public class ViewAllNcsRepository
{
    private final ApplicationContext applicationContext;
    private final DbConfig dbConfig;

    @Autowired
    public ViewAllNcsRepository (final ApplicationContext applicationContext, final DbConfig dbConfig)
    {
        this.applicationContext = applicationContext;
        this.dbConfig = dbConfig;
    }


}
