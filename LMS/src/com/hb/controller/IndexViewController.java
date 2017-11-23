package com.hb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.IndexDao;
import com.hb.model.IndexDto;

@WebServlet("/lmsindex.do")
public class IndexViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IndexDao dao= new IndexDao();
		ArrayList<IndexDto> list= dao.indexView();
				System.out.println(list.size());
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("lmsindex.jsp").forward(req, resp);	
	}
}
