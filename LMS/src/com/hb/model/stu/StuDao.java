package com.hb.model.stu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.model.stu.StuDto;
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
	
	public void Stuadd(int sId,String sName, Date birth, String phone, String email, int regclass){
		String sql="insert into stu values(?,?,?,?,?,'수강중',?)";
		conn=MyOracle.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setDate(3, birth);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setInt(5, regclass);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
