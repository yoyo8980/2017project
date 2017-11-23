package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class StuDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<StuDto> list;
	ArrayList<StuDto> list2;
	ArrayList<StuDto> list3;
	public ArrayList<StuDto> StuView(){
		String sql="select * from stu where status='수강중'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<StuDto>();
			while(rs.next()){
				StuDto bean= new StuDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getDate("birth"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
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
	
	public ArrayList<StuDto> StuCom(){
		String sql2="select * from stu where status='수료'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			list2 = new ArrayList<StuDto>();
			while(rs.next()){
				StuDto bean= new StuDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getDate("birth"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
				list2.add(bean);				
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
		return list2;
	}
	public ArrayList<StuDto> StuGU(){
		String sql3="select * from stu where status='포기'";
		conn=MyOracle.getConnection();
		try{
			pstmt=conn.prepareStatement(sql3);
			rs=pstmt.executeQuery();
			list3 = new ArrayList<StuDto>();
			while(rs.next()){
				StuDto bean= new StuDto();
				bean.setsId(rs.getInt("sId"));
				bean.setsName(rs.getString("sName"));
				bean.setBirth(rs.getDate("birth"));
				bean.setPhone(rs.getString("phone"));
				bean.setEmail(rs.getString("email"));
				bean.setRegclass(rs.getInt("regclass"));
				list3.add(bean);				
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
		return list3;
	}
	
}
