package com.tjtyres.model;

import javax.persistence.Entity;

//@Entity
public class Hpcl {

	private Long hpclId;
	private String zone;
	private String region;
	
	public Hpcl() {
		
	}

	public Hpcl(String zone, String region) {
		this.zone = zone;
		this.region = region;
	}


	public Long getHpclId() {
		return hpclId;
	}


	public void setHpclId(Long hpclId) {
		this.hpclId = hpclId;
	}
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Hpcl [zone=" + zone + ", region=" + region + "]";
	}
	
	
	
}
