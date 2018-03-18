package com.cn.wy.pojoDto;

import com.cn.wy.pojo.Score;

public class ScoreDto extends Score{
	private String teaname;
	
	private String coursename;
	
	private String stuname;
	
	private Long classNo;
	
   private String classAddress;
   
   private String departname;
   
   private Integer classPeople;
   
   private Long currentPeople;

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

	public final String getDepartname() {
	return departname;
}

public final void setDepartname(String departname) {
	this.departname = departname;
}

	public final String getClassAddress() {
	return classAddress;
}

public final void setClassAddress(String classAddress) {
	this.classAddress = classAddress;
}

	public final Long getClassNo() {
		return classNo;
	}

	public final void setClassNo(Long classNo) {
		this.classNo = classNo;
	}

	public final String getCoursetime() {
		return coursetime;
	}

	public final void setCoursetime(String coursetime) {
		this.coursetime = coursetime;
	}

	public final Long getCourseaddress() {
		return courseaddress;
	}

	public final void setCourseaddress(Long courseaddress) {
		this.courseaddress = courseaddress;
	}

	public final String getCourseabout() {
		return courseabout;
	}

	public final void setCourseabout(String courseabout) {
		this.courseabout = courseabout;
	}

	public final Float getCoursegrade() {
		return coursegrade;
	}

	public final void setCoursegrade(Float coursegrade) {
		this.coursegrade = coursegrade;
	}

	private String coursetime;

    private Long courseaddress;

    private String courseabout;

    private Float coursegrade;

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getTeaname() {
		return teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}
