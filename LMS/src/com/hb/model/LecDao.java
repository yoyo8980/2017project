package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class LecDao {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<LecDto> list4;
	public int lecId;
	public String lecName;
	public int room;
	public String status;
	
	public ArrayList<LecDto> LecView(){
		String sql="select lecid,lecname,room from lectures where status='opened'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list4 = new ArrayList<LecDto>();
			while(rs.next()){
				LecDto bean= new LecDto();
				bean.setLecId(rs.getInt("lecid"));
				bean.setLecName(rs.getString("lecname"));
				bean.setRoom(rs.getInt("room"));
				bean.setStatus(rs.getString("status"));
				
				list4.add(bean);				
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
		return list4;
	}
}
