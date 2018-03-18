package com.cn.wy.pojoDto;

public class StuInfoDto {
	 private Long id;

	    private String stuNo;

	    private String stuname;

	    private String sex;

	    private Long zid;

	    private Long departid;

	    private Integer stuclass;
	    
	    private String departname;
	    
	    private String majorname;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStuNo() {
			return stuNo;
		}

		public void setStuNo(String stuNo) {
			this.stuNo = stuNo;
		}

		public String getStuname() {
			return stuname;
		}

		public void setStuname(String stuname) {
			this.stuname = stuname;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Long getZid() {
			return zid;
		}

		public void setZid(Long zid) {
			this.zid = zid;
		}

		public Long getDepartid() {
			return departid;
		}

		public void setDepartid(Long departid) {
			this.departid = departid;
		}

		public Integer getStuclass() {
			return stuclass;
		}

		public void setStuclass(Integer stuclass) {
			this.stuclass = stuclass;
		}

		public String getDepartname() {
			return departname;
		}

		public void setDepartname(String departname) {
			this.departname = departname;
		}

		public String getMajorname() {
			return majorname;
		}

		public void setMajorname(String majorname) {
			this.majorname = majorname;
		}
}
