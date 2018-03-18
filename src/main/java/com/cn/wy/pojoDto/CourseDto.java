package com.cn.wy.pojoDto;

import com.cn.wy.pojo.Course;

public class CourseDto extends Course{
	private String departname;
	private String address;
	 private String tername;
	 private Long scoreId;
	 private Long currentPeople;
	 private Integer classPeople;
	 
	public final Integer getClassPeople() {
		return classPeople;
	}
	public final void setClassPeople(Integer classPeople) {
		this.classPeople = classPeople;
	}
	public final Long getCurrentPeople() {
		return currentPeople;
	}
	public final void setCurrentPeople(Long currentPeople) {
		this.currentPeople = currentPeople;
	}
	public Long getScoreId() {
		return scoreId;
	}
	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}
	public String getTername() {
		return tername;
	}
	public void setTername(String tername) {
		this.tername = tername;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 
}
