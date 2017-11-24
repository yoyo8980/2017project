package com.hb.model.hrmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class HrmgrDao {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<HrmgrDto> list;
	
	public ArrayList<HrmgrDto> AddView() {
		String teamSql="select team from hrlist group by team having count(team)>0";
		String idSql="select max(hrid) as hrid from hrlist";
		conn=MyOracle.getConnection();
	
		try{
			pstmt=conn.prepareStatement(teamSql);
			rs=pstmt.executeQuery();
			list = new ArrayList<HrmgrDto>();
			
			while(rs.next()){
				HrmgrDto bean= new HrmgrDto();		
				bean.setTeam(rs.getString("team"));	//부서명 자동부여			
				list.add(bean);
			}
			
			pstmt=conn.prepareStatement(idSql);
			rs=pstmt.executeQuery();
		
			while(rs.next()){
				HrmgrDto bean= new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid")+1);//Id 번호 자동부여 	
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
	public void insertHr(int hrid,String hrname, String hrteam){
		String sql="insert into HRLIST values (?,?,?)";
		conn=MyOracle.getConnection();
		try{
			System.out.println("test");			
			pstmt=conn.prepareStatement(sql);
			System.out.println(hrid+":"+hrname+":"+hrteam);
			pstmt.setInt(1, hrid);
			pstmt.setString(2, hrname);
			pstmt.setString(3, hrteam);
			
			int cnt=pstmt.executeUpdate();
		
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
}
