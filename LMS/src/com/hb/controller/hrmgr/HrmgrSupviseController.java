package com.hb.controller.hrmgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("hrmgrsup.do")
public class HrmgrSupviseController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param1= req.getParameter("hrid");
		String param2= req.getParameter("id");
		String param3= req.getParameter("pw");
		System.out.println(param1+":"+param2+":"+param3);
		
		resp.sendRedirect("lmsindex.do"); // 임시용 메인화면 가기
	}
}
