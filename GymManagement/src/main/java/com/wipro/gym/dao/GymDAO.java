package com.wipro.gym.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wipro.gym.bean.GymBean;
import com.wipro.gym.util.DBUtil;

public class GymDAO {

    public String createRecord(GymBean bean) {
        String status = "FAIL";
        try (Connection con = DBUtil.getDBConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO GYM_TB (RECORDID, MEMBERNAME, MEMBERSHIPTYPE, JOINING_DATE, DURATION_MONTHS, FEES, REMARKS) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, bean.getRecordId());
            ps.setString(2, bean.getMemberName());
            ps.setString(3, bean.getMembershipType());
            ps.setDate(4, bean.getJoiningDate());
            ps.setInt(5, bean.getDurationMonths());
            ps.setInt(6, bean.getFees());
            ps.setString(7, bean.getRemarks());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = bean.getRecordId();
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public GymBean fetchRecord(String memberName, Date joiningDate) {
        GymBean bean = null;
        try (Connection con = DBUtil.getDBConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM GYM_TB WHERE LOWER(MEMBERNAME) = LOWER(?) AND JOINING_DATE = ?"
            );

            ps.setString(1, memberName.trim());
            ps.setDate(2, joiningDate);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bean = new GymBean();
                bean.setRecordId(rs.getString("RECORDID"));
                bean.setMemberName(rs.getString("MEMBERNAME"));
                bean.setMembershipType(rs.getString("MEMBERSHIPTYPE"));
                bean.setJoiningDate(rs.getDate("JOINING_DATE"));
                bean.setDurationMonths(rs.getInt("DURATION_MONTHS"));
                bean.setFees(rs.getInt("FEES"));
                bean.setRemarks(rs.getString("REMARKS"));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public boolean recordExists(String memberName, Date joiningDate) {
        return fetchRecord(memberName, joiningDate) != null;
    }

    public String generateRecordID(String memberName, Date joiningDate) {
        String recordId = "";
        try (Connection con = DBUtil.getDBConnection()) {

            ResultSet rs = con.createStatement().executeQuery("SELECT GYM_SEQ.NEXTVAL FROM DUAL");
            int seq = 0;
            if (rs.next()) seq = rs.getInt(1);

            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            String dt = df.format(joiningDate);
            String nm = memberName.length() >= 2
                      ? memberName.substring(0, 2).toUpperCase()
                      : memberName.toUpperCase();

            recordId = dt + nm + String.format("%02d", seq);

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordId;
    }

    public List<GymBean> fetchAllRecords() {
        List<GymBean> list = new ArrayList<>();
        try (Connection con = DBUtil.getDBConnection()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM GYM_TB ORDER BY JOINING_DATE DESC");

            while (rs.next()) {
                GymBean bean = new GymBean();
                bean.setRecordId(rs.getString("RECORDID"));
                bean.setMemberName(rs.getString("MEMBERNAME"));
                bean.setMembershipType(rs.getString("MEMBERSHIPTYPE"));
                bean.setJoiningDate(rs.getDate("JOINING_DATE"));
                bean.setDurationMonths(rs.getInt("DURATION_MONTHS"));
                bean.setFees(rs.getInt("FEES"));
                bean.setRemarks(rs.getString("REMARKS"));
                list.add(bean);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
