package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;


public class IndexDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<IndexDto> list;
	public ArrayList<IndexDto> indexView(){
		String sql="select lecid,lecname from lectures where status='¿î¿µÁß'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<IndexDto>();
			while(rs.next()){
				IndexDto bean= new IndexDto();
				bean.setLecId(rs.getInt("lecid"));
				bean.setLecName(rs.getString("lecname"));
				list.add(bean);				
			}			
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
		return list;
	}
}
