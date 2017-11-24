package com.hb.model.hrmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class HrmgrDao {
	
	Connection conn=MyOracle.getConnection();
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<HrmgrDto> AddView() {
		ArrayList<HrmgrDto> list = null;
		String teamSql="SELECT TEAM FROM HRLIST GROUP BY TEAM HAVING COUNT(TEAM)>0";
		String idSql="SELECT MAX(HRID) AS HRID FROM HRLIST";
	
	
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
		String insOneSql="INSERT INTO HRLIST VALUES (?,?,?)";
		
		try{

			pstmt=conn.prepareStatement(insOneSql);	
			pstmt.setInt(1, hrid);
			pstmt.setString(2, hrname);
			pstmt.setString(3, hrteam);			
			pstmt.executeUpdate();
		
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
	public void deleteOne(int hrid){
		String delOneSql="DELETE FROM HRLIST WHERE HRID=?";		
		try{
			pstmt=conn.prepareStatement(delOneSql);
			pstmt.setInt(1, hrid);
			pstmt.executeUpdate();
			System.out.println("test1");
		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
	}
	public ArrayList<HrmgrDto> deleteView(){
		ArrayList<HrmgrDto> list=null;
		String delViewSql="SELECT * FROM HRLIST";
		try{
			pstmt=conn.prepareStatement(delViewSql);
			rs=pstmt.executeQuery();
			list = new ArrayList<HrmgrDto>();
			while(rs.next()){				
				HrmgrDto bean = new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid"));				
				bean.setHrname(rs.getString("hrname"));			
				bean.setTeam(rs.getString("team"));		
				list.add(bean);														
			}

		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){				
			}
		}
		return list;
	}
	
	public ArrayList<HrmgrDto> editView(){
		ArrayList<HrmgrDto> list=null;
		String delViewSql="SELECT * FROM HRLIST";
		try{
			pstmt=conn.prepareStatement(delViewSql);
			rs=pstmt.executeQuery();
			list = new ArrayList<HrmgrDto>();
			while(rs.next()){				
				HrmgrDto bean = new HrmgrDto();				
				bean.setHrid(rs.getInt("hrid"));				
				bean.setHrname(rs.getString("hrname"));			
				bean.setTeam(rs.getString("team"));		
				list.add(bean);														
			}

		}catch(Exception e){	
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){				
			}
		}
		return list;
	}
}
