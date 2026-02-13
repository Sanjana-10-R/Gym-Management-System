package com.wipro.gym.service;

import java.sql.Date;
import java.util.List;
import com.wipro.gym.bean.GymBean;
import com.wipro.gym.dao.GymDAO;
import com.wipro.gym.util.InvalidInputException;

public class Administrator {

    private GymDAO dao = new GymDAO();

    public String addRecord(GymBean gymBean) {

        try {
            if (gymBean == null ||
                gymBean.getMemberName() == null ||
                gymBean.getJoiningDate() == null) {
                throw new InvalidInputException();
            }

            if (gymBean.getMemberName().trim().length() < 2) {
                return "INVALID MEMBER NAME";
            }

            if (gymBean.getJoiningDate().after(new Date(System.currentTimeMillis()))) {
                return "INVALID DATE";
            }

            if (dao.recordExists(
                gymBean.getMemberName(), gymBean.getJoiningDate())) {
                return "ALREADY EXISTS";
            }

            String recordId = dao.generateRecordID(
                    gymBean.getMemberName(), gymBean.getJoiningDate());
            gymBean.setRecordId(recordId);

            return dao.createRecord(gymBean);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public GymBean viewRecord(String memberName, Date joiningDate) {
        return dao.fetchRecord(memberName, joiningDate);
    }

    public List<GymBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}
