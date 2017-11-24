package com.hb.controller.stu;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.stu.StuDao;
@WebServlet("/stuadd.do")
public class StuAddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("stuadd.jsp").forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String param1=req.getParameter("sId");
		String sName=req.getParameter("sName");
		String birth=req.getParameter("birth");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String regclass=req.getParameter("regclass");
		
		int sId=Integer.parseInt(param1);
		Date birth=req.get
//		Date sN
		StuDao dao=new StuDao();
		try{
			
			dao.Stuadd(sId, sName, birth, phone, email, regclass);
		}catch(SQLException e){
			e.printStackTrace();
		}
		resp.sendRedirect("stuview.do");
		
		
		
	}
}
