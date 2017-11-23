package com.hb.controller.hrmgr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.catalina.ha.backend.Sender;

import com.hb.model.hrmgr.HrmgrAddDao;
import com.hb.model.hrmgr.HrmgrInsertDao;

@WebServlet("/hrmgrinsert.do")
public class HrmgrInsertController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String param=req.getParameter("hrid");
		int hrid= Integer.parseInt(param);
		String hrname= req.getParameter("hrname");
		String hrteam=req.getParameter("hrteam");		
		HrmgrInsertDao dao = new HrmgrInsertDao();
		
		dao.insertHr(hrid, hrname, hrteam);
		
		resp.sendRedirect("./lmsindex.do"); // 임시용 메인화면가기 
	}
}
