package com.hb.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

//This DAO includes DTO features.

public class OpenLecDao {
	public int lecid;
	private String lecname;
	public ArrayList<Integer> teacherid;
	public ArrayList<String> teachername;
	private int roomnum;
	private Date starting;
	private Date ending;
	private String intro;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OpenLecDao(){
		conn=MyOracle.getConnection();
		try{
			String sql="select lecid from (select lecid from lectures order by lecid desc) where rownum = 1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				lecid=rs.getInt("lecid")+1;
			}				
			
			sql="select hrid, hrname from hrlist where team='강사'";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				teacherid.add(rs.getInt("hrid"));
				teachername.add(rs.getString("hrname"));
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
	}
	
	OpenLecDao(String[] formvalues){
		
	}
	
	public void pushForm(){
		//위 생성자로 세팅된 값을 DB로 입력후 
		//다시 controller 로 보내서 처리하되 코드를 줘서 같은 jsp 
	}
	
}
