package com.hb.controller.hrmgr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.hrmgr.HrmgrDao;
import com.hb.model.hrmgr.HrmgrDto;

@WebServlet("/hrmgr.do")
public class HrmgrViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String root=req.getParameter("root");
	
		if(root.equals("add")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> list= dao.AddView();		
			req.setAttribute("teamlist", list);
			req.getRequestDispatcher("hrmgr"+root+".jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("hrmgr"+root+".jsp").forward(req, resp);	
		}
	}
}