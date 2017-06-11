package com.audit.app.customer.view.all.ncs.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;


/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class UserNcDetailInfo
{
    private int ncId;
    private Date ncDate;
    private int ncAuditId;
    private String ncProjectName;
    private String ncRaisedBy;
    private Date ncExpectedCloseDate;
    private String ncAssignedTo;
    private String ncDescription;
    private int ncStatus;

    public int getNcId() {
        return ncId;
    }

    public Date getNcDate() {
        return ncDate;
    }

    public void setNcDate(Date ncDate) {
        this.ncDate = ncDate;
    }

    public void setNcId(int ncId) {
        this.ncId = ncId;
    }

    public int getNcAuditId() {
        return ncAuditId;
    }

    public void setNcAuditId(int ncAuditId) {
        this.ncAuditId = ncAuditId;
    }

    public String getNcProjectName() {
        return ncProjectName;
    }

    public void setNcProjectName(String ncProjectName) {
        this.ncProjectName = ncProjectName;
    }

    public String getNcRaisedBy() {
        return ncRaisedBy;
    }

    public void setNcRaisedBy(String ncRaisedBy) {
        this.ncRaisedBy = ncRaisedBy;
    }

    public Date getNcExpectedCloseDate() {
        return ncExpectedCloseDate;
    }

    public void setNcExpectedCloseDate(Date ncExpectedCloseDate) {
        this.ncExpectedCloseDate = ncExpectedCloseDate;
    }

    public String getNcAssignedTo() {
        return ncAssignedTo;
    }

    public void setNcAssignedTo(String ncAssignedTo) {
        this.ncAssignedTo = ncAssignedTo;
    }

    public String getNcDescription() {
        return ncDescription;
    }

    public void setNcDescription(String ncDescription) {
        this.ncDescription = ncDescription;
    }

    public int getNcStatus() {
        return ncStatus;
    }

    public void setNcStatus(int ncStatus) {
        this.ncStatus = ncStatus;
    }

    @Override
    public String toString() {
        return "UserNcDetailInfo{" +
                "ncId=" + ncId +
                ", ncDate=" + ncDate +
                ", ncAuditId=" + ncAuditId +
                ", ncProjectName='" + ncProjectName + '\'' +
                ", ncRaisedBy='" + ncRaisedBy + '\'' +
                ", ncExpectedCloseDate=" + ncExpectedCloseDate +
                ", ncAssignedTo='" + ncAssignedTo + '\'' +
                ", ncDescription='" + ncDescription + '\'' +
                ", ncStatus=" + ncStatus +
                '}';
    }
}
