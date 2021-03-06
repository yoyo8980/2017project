package com.hb.controller.candi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.hb.model.candi.CandiDao;
import com.hb.model.candi.CandiDto;
import com.hb.model.stu.StuDao;
import com.hb.model.stu.StuDto;

@WebServlet("/candi.do")
public class CandiViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CandiDao dao=new CandiDao();
		ArrayList<CandiDto> list= dao.CandiView();
		ArrayList<CandiDto> list2= dao.CandiStand();
		
			req.setAttribute("list", list);
			req.setAttribute("list2", list2);
			req.getRequestDispatcher("candi.jsp").forward(req, resp);
		}
	
	
}
