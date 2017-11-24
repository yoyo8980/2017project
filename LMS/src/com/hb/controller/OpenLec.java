package com.hb.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.OpenLecDao;

@WebServlet("/openlec.do")
public class OpenLec extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		OpenLecDao bean = new OpenLecDao();

		req.setAttribute("nextid", bean.lecid);
		req.setAttribute("teacherid", bean.teacherid);
		req.setAttribute("teachername", bean.teachername);
		req.getRequestDispatcher("openlec.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String lecname = req.getParameter("lecname");
		String starting = req.getParameter("starting");
		System.out.println(lecname);
		System.out.println(starting);
	}

}
