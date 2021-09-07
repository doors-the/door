package com.construction.servlet;

import com.construction.dao.TProjectDao;
import com.construction.entity.TProject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author doors
 * @Date 2021/9/6
 */
@WebServlet("/add")
public class AddTProject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TProjectDao tProjectDao = new TProjectDao();
        TProject tProject = new TProject();

        String projectId = request.getParameter("projectId");
        String projectName = request.getParameter("projectName");
        String deputyName = request.getParameter("deputyName");
        String telephone = request.getParameter("telephone");
        String addr = request.getParameter("addr");

        tProject.setProjectId(projectId);
        tProject.setProjectName(projectName);
        tProject.setDeputyName(deputyName);
        tProject.setTelephone(telephone);
        tProject.setAddr(addr);
        System.out.println(tProject);
        tProjectDao.addTProject(tProject);
        response.sendRedirect("list");
    }

}
