package com.construction.servlet;

import com.construction.dao.TProjectDao;
import com.construction.entity.TProject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author doors
 * @Date 2021/9/6
 */
@WebServlet("/list")
public class TProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TProjectDao tProjectDao = new TProjectDao();
        ArrayList<TProject> list = tProjectDao.list();
        request.setAttribute("list",list);
        request.getRequestDispatcher("project_list.jsp").forward(request,response);
    }
}
