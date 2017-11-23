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
		String sql="select team from hrlist group by team having count(team)>0";		
		conn=MyOracle.getConnection();
		
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<HrmgrAddDto>();
			
			while(rs.next()){
				HrmgrAddDto bean= new HrmgrAddDto();
				bean.setTeam(rs.getString("team"));	
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
