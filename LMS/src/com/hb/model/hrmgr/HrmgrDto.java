package com.hb.model.hrmgr;

public class HrmgrDto {
	private String hrteam;
	private int hrid;
	
	public HrmgrDto() {
		
	}
	public String getTeam() {
		return hrteam;
	}

	public void setTeam(String team) {
		this.hrteam = team;
	}
	public int getHrid() {
		return hrid;
	}
	public void setHrid(int hrid) {
		this.hrid = hrid;
	}	
	
}