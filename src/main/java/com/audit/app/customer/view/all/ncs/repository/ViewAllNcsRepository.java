package com.audit.app.customer.view.all.ncs.repository;

import com.audit.app.customer.dbConfig.DbConfig;
import com.audit.app.customer.Login.model.LoginForm;
import com.audit.app.customer.view.all.ncs.model.NcInfo;
import com.audit.app.customer.view.all.ncs.model.UserNcDetailInfo;
import com.audit.app.customer.view.all.ncs.model.UserNcUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Repository
public class ViewAllNcsRepository
{
    private final ApplicationContext applicationContext;
    private final Connection connection;

    @Autowired
    public ViewAllNcsRepository (final ApplicationContext applicationContext) throws SQLException {
        this.applicationContext = applicationContext;
        this.connection = DbConfig.getInstance();
    }

    public List<NcInfo> getAllNcsForUser(String userName) throws SQLException {
        String sql = String.format("select * from NcRegister where Nc_AssignedTo = '%s' order by Nc_Status",userName);

        System.out.println(sql);

        Statement statement = this.connection.createStatement();

        List<NcInfo> ncInfoList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            NcInfo ncInfo = this.applicationContext.getBean(NcInfo.class);
            ncInfo.setNcId(resultSet.getInt("Nc_Id"));
            ncInfo.setNcDate(resultSet.getDate("Nc_Date"));
            ncInfo.setNcDescription(resultSet.getString("Nc_Description"));
            ncInfo.setNcRaisedBy(resultSet.getString("Nc_RaisedBy"));
            ncInfo.setNcExpectedCloseDate(resultSet.getDate("Expected_CloseDt"));
            ncInfo.setNcStatus(resultSet.getInt("Nc_Status"));

            ncInfoList.add(ncInfo);
        }

        return ncInfoList;
    }


    public UserNcDetailInfo getNcDetailInfo(int ncId, String username) throws SQLException {

        String sql = String.format("select * from NcRegister where Nc_Id = %s and Nc_AssignedTo = '%s';",ncId, username);

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        UserNcDetailInfo userNcDetailInfo = this.applicationContext.getBean(UserNcDetailInfo.class);

        if(resultSet.next()){
            userNcDetailInfo.setNcId(resultSet.getInt("Nc_Id"));
            userNcDetailInfo.setNcAuditId(resultSet.getInt("Audit_Id"));
            userNcDetailInfo.setNcAssignedTo(resultSet.getString("Nc_AssignedTo"));
            userNcDetailInfo.setNcDescription(resultSet.getString("Nc_Description"));
            userNcDetailInfo.setNcExpectedCloseDate(resultSet.getDate("Expected_CloseDt"));
            userNcDetailInfo.setNcProjectName(resultSet.getString("Project_Name"));
            userNcDetailInfo.setNcRaisedBy(resultSet.getString("Nc_RaisedBy"));
            userNcDetailInfo.setNcStatus(resultSet.getInt("Nc_Status"));
            userNcDetailInfo.setNcDate(resultSet.getDate("Nc_Date"));
        }

        return userNcDetailInfo;
    }

    public Boolean updateNc(UserNcUpdate userNcUpdate, String username) throws SQLException {

        String sql =  String.format("update NcRegister set Nc_ResolutionFromAuditee = '%s'," +
                        " Nc_ResolutionDt = '%s' , Nc_Status = '%s' " +
                        "where Nc_Id = %s and Nc_AssignedTo = '%s' and Nc_Status='%s'",
                    userNcUpdate.getResolutionFromAuditee(), userNcUpdate.getResolutionDate() , 302
                ,userNcUpdate.getNcId(), username, userNcUpdate.getNcStatus());

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        return preparedStatement.executeUpdate() > 0;
    }
}
