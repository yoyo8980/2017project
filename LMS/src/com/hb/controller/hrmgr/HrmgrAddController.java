package com.hb.controller.hrmgr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.hrmgr.HrmgrAddDao;
import com.hb.model.hrmgr.HrmgrAddDto;

//@WebServlet("/hrmgradd.do") 
public class HrmgrAddController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		HrmgrAddDao dao= new HrmgrAddDao();
//		ArrayList<HrmgrAddDto> list= dao.AddView();		
//		req.setAttribute("teamlist", list);
//		req.getRequestDispatcher("hrmgradd.jsp").forward(req, resp);	
	}
}

