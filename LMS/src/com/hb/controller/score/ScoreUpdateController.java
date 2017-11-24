package com.hb.controller.score;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.score.ScoreDao;
@WebServlet("/update.do")
public class ScoreUpdateController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	int score=Integer.parseInt(req.getParameter("score"));
	
	ScoreDao dao = new ScoreDao();	
	resp.sendRedirect("edit.do");
}

}
