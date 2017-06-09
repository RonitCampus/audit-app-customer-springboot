package com.audit.app.customer.view.all.ncs.model;

import java.sql.Date;

/**
 * Created by Infocepts India in 2017.
 */
public class NcInfo
{
    private int ncId;
    private Date ncDate;
    private String ncDescription;
    private String ncRaisedBy;
    private Date ncExpectedCloseDate;
    private int ncStatus;


    public int getNcId ()
    {
        return ncId;
    }

    public void setNcId (final int ncId)
    {
        this.ncId = ncId;
    }

    public Date getNcDate ()
    {
        return ncDate;
    }

    public void setNcDate (final Date ncDate)
    {
        this.ncDate = ncDate;
    }

    public String getNcDescription ()
    {
        return ncDescription;
    }

    public void setNcDescription (final String ncDescription)
    {
        this.ncDescription = ncDescription;
    }

    public String getNcRaisedBy ()
    {
        return ncRaisedBy;
    }

    public void setNcRaisedBy (final String ncRaisedBy)
    {
        this.ncRaisedBy = ncRaisedBy;
    }

    public Date getNcExpectedCloseDate ()
    {
        return ncExpectedCloseDate;
    }

    public void setNcExpectedCloseDate (final Date ncExpectedCloseDate)
    {
        this.ncExpectedCloseDate = ncExpectedCloseDate;
    }

    public int getNcStatus ()
    {
        return ncStatus;
    }

    public void setNcStatus (final int ncStatus)
    {
        this.ncStatus = ncStatus;
    }

    @Override
    public String toString ()
    {
        return "NcInfo{" +
                "ncId=" + ncId +
                ", ncDate=" + ncDate +
                ", ncDescription='" + ncDescription + '\'' +
                ", ncRaisedBy='" + ncRaisedBy + '\'' +
                ", ncExpectedCloseDate=" + ncExpectedCloseDate +
                ", ncStatus=" + ncStatus +
                '}';
    }
}
