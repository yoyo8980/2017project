package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class QnADao {

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public ArrayList<QnADto> selectAll(){
		ArrayList<QnADto> alist = new ArrayList<QnADto>();
		conn=MyOracle.getConnection();
		try{
			String sql="select * from (select * from qnaque order by id desc) where rownum <11";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				QnADto bean = new QnADto();
				bean.setQnaid(rs.getInt("id"));
				bean.setAuthor(rs.getString("author"));
				bean.setEmail(rs.getString("email"));
				bean.setPhonenum(rs.getString("phone"));
				bean.setContent(rs.getString("content"));
				alist.add(bean);
			}
			
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
		}catch(Exception e){
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alist;
	} //method end
	
}
