package com.wipro.gym.servlets;

import java.io.IOException;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.wipro.gym.bean.GymBean;
import com.wipro.gym.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Administrator admin = new Administrator();

    public String addRecord(HttpServletRequest request) {

        try {
            GymBean bean = new GymBean();

            bean.setMemberName(request.getParameter("memberName"));
            bean.setMembershipType(request.getParameter("membershipType"));

            String dateStr = request.getParameter("joiningDate");
            java.util.Date utilDate =
                    new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            bean.setJoiningDate(new Date(utilDate.getTime()));

            bean.setDurationMonths(
                Integer.parseInt(request.getParameter("durationMonths")));
            bean.setFees(
                Integer.parseInt(request.getParameter("fees")));
            bean.setRemarks(request.getParameter("remarks"));

            return admin.addRecord(bean);

        } catch (Exception e) {
            return "FAIL";
        }
    }

    public GymBean viewRecord(HttpServletRequest request) {
        try {
            String memberName = request.getParameter("memberName");
            String dateStr = request.getParameter("joiningDate");
            java.util.Date utilDate =
                new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return admin.viewRecord(memberName,
                new Date(utilDate.getTime()));
        } catch (Exception e) {
            return null;
        }
    }

    public List<GymBean> viewAllRecords() {
        return admin.viewAllRecords();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if ("newRecord".equals(operation)) {
            String result = addRecord(request);

            try {
                if (result == null ||
                    result.equals("FAIL") ||
                    result.equals("INVALID INPUT") ||
                    result.equals("INVALID MEMBER NAME") ||
                    result.equals("INVALID DATE") ||
                    result.equals("ALREADY EXISTS")) {

                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("success.html");
                }
            } catch (IOException e) { e.printStackTrace(); }
        }

        else if ("viewRecord".equals(operation)) {

            GymBean bean = viewRecord(request);
            if (bean == null) {
                request.setAttribute("message",
                    "No matching records exists! Please try again!");
            } else {
                request.setAttribute("member", bean);
            }
            try {
                request.getRequestDispatcher("displayMember.jsp")
                       .forward(request, response);
            } catch (Exception e) { e.printStackTrace(); }
        }

        else if ("viewAllRecords".equals(operation)) {

            java.util.List<GymBean> list = viewAllRecords();
            if (list == null || list.isEmpty()) {
                request.setAttribute("message",
                    "No records available!");
            } else {
                request.setAttribute("gymList", list);
            }
            try {
                request.getRequestDispatcher("displayAllMembers.jsp")
                       .forward(request, response);
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
