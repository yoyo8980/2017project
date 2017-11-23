package com.hb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.ScoreDao;
import com.hb.model.ScoreDto;

@WebServlet("/score.do")
public class ScoreController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ScoreDao dao= new ScoreDao();
		ArrayList<ScoreDto> slist= dao.scoreView();
		req.setAttribute("slist", slist);
		req.getRequestDispatcher("score.jsp").forward(req, resp);	
	}
}
	

