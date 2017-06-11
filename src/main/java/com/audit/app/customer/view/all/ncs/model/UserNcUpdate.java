package com.audit.app.customer.view.all.ncs.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class UserNcUpdate
{
    private int ncId;
    private int auditId;
    private String resolutionFromAuditee;
    private Date resolutionDate;
    private int ncStatus;

    public Date getResolutionDate ()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new java.util.Date());

        return Date.valueOf(date);
    }

    public int getNcStatus() {
        return ncStatus;
    }

    public void setNcStatus(int ncStatus) {
        this.ncStatus = ncStatus;
    }

    public int getNcId ()
    {
        return ncId;
    }

    public void setNcId (final int ncId)
    {
        this.ncId = ncId;
    }

    public int getAuditId ()
    {
        return auditId;
    }

    public void setAuditId (final int auditId)
    {
        this.auditId = auditId;
    }

    public String getResolutionFromAuditee ()
    {
        return resolutionFromAuditee;
    }

    public void setResolutionFromAuditee (final String resolutionFromAuditee)
    {
        this.resolutionFromAuditee = resolutionFromAuditee;
    }

    @Override
    public String toString ()
    {
        return "UserNcUpdate{" +
                "ncId=" + ncId +
                ", auditId=" + auditId +
                ", resolutionFromAuditee='" + resolutionFromAuditee + '\'' +
                ", resolutionDate=" + resolutionDate +
                '}';
    }
}
