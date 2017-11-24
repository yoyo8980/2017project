package com.hb.model.candi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hb.util.MyOracle;

public class CandiDao {

	
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<CandiDto> list;
		ArrayList<CandiDto> list2;
		public ArrayList<CandiDto> CandiView(){
			String sql="select * from candi where status='상담중'";
			conn=MyOracle.getConnection();
			try{
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				list = new ArrayList<CandiDto>();
				while(rs.next()){
					CandiDto bean= new CandiDto();
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
		
		public ArrayList<CandiDto> CandiStand(){
			String sql2="select * from candi where status='수강대기'";
			conn=MyOracle.getConnection();
			try{
				pstmt=conn.prepareStatement(sql2);
				rs=pstmt.executeQuery();
				list2 = new ArrayList<CandiDto>();
				while(rs.next()){
					CandiDto bean= new CandiDto();
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
}
