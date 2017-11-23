package com.hb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hb.model.StuDao;
import com.hb.model.StuDto;

@WebServlet("/stu.do")
public class StuViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StuDao dao=new StuDao();
		ArrayList<StuDto> list= dao.StuView();
		ArrayList<StuDto> list2= dao.StuCom();
		ArrayList<StuDto> list3= dao.StuGU();
		
			req.setAttribute("list", list);
			req.setAttribute("list2", list2);
			req.setAttribute("list3", list3);
			req.getRequestDispatcher("stu.jsp").forward(req, resp);
		}
	
	
}
