package com.hb.model.hrmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class HrmgrAddDao {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<HrmgrAddDto> list;
	
	public ArrayList<HrmgrAddDto> AddView() {
		String teamSql="select team from hrlist group by team having count(team)>0";
		String idSql="select max(hrid) as hrid from hrlist";
		conn=MyOracle.getConnection();
		boolean rsChk=true;
		try{
			pstmt=conn.prepareStatement(teamSql);
			rs=pstmt.executeQuery();
			list = new ArrayList<HrmgrAddDto>();
			
			while(rs.next()){
				HrmgrAddDto bean= new HrmgrAddDto();
				bean.setTeam(rs.getString("team"));	//부서명 자동부여 
				list.add(bean);
			}
			
			pstmt=conn.prepareStatement(idSql);
			rs=pstmt.executeQuery();
		
			while(rs.next()){
				HrmgrAddDto bean= new HrmgrAddDto();				
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
}
