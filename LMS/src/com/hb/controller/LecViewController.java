package com.hb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.LecDao;
@WebServlet("/stuview.do")
public class LecViewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LecDao bean = new LecDao();

		req.setAttribute("lecid", bean.lecId);
		req.setAttribute("lecname", bean.lecName);
		req.setAttribute("room", bean.room);
		req.setAttribute("status", bean.status);
		req.getRequestDispatcher("stuview.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
