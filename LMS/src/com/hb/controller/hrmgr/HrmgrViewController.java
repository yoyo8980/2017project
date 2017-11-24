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
		System.out.println("test1");
		System.out.println(root.getBytes());
		req.getRequestDispatcher("hrmgr"+root+".jsp").forward(req, resp);

		if(root.equals("add")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> teamList= dao.AddView();		
			req.setAttribute("list", teamList);
			
		}else if(root.equals("delete")){	
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> delList= dao.deleteView();		
			req.setAttribute("list", delList);	
			
		}else if(root.equals("edit")){
			HrmgrDao dao= new HrmgrDao();
			ArrayList<HrmgrDto> editList= dao.editView();		
			req.setAttribute("list", editList);
		}
		req.getRequestDispatcher("hrmgr"+root+".jsp").forward(req, resp);
	}

}