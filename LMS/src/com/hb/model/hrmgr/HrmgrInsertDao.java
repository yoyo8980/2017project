package com.hb.model.hrmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hb.util.MyOracle;

public class HrmgrInsertDao {
	Connection conn;
	PreparedStatement pstmt;
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
