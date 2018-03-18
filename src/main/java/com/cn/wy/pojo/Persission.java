package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.List;

public class Persission implements Serializable{
	private static final long serialVersionUID = 5993286892322436568L;
    private Long id;

    private String permisname;

    private String path;

    private String permisorder;

    private Integer pid;
    
    /**
	 * 是否选中
	 */
	private boolean checked;

	/**
	 * 子菜单list
	 */
	private List<Persission> sysMenuList;
	/**
	 * 主菜单list
	 */
	private List<Persission> parentSysMenuList;

    public void setParentSysMenuList(List<Persission> parentSysMenuList) {
		this.parentSysMenuList = parentSysMenuList;
	}

	public List<Persission> getParentSysMenuList() {
		return parentSysMenuList;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Persission> getSysMenuList() {
		return sysMenuList;
	}

	public void setSysMenuList(List<Persission> sysMenuList) {
		this.sysMenuList = sysMenuList;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermisname() {
        return permisname;
    }

    public void setPermisname(String permisname) {
        this.permisname = permisname == null ? null : permisname.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPermisorder() {
        return permisorder;
    }

    public void setPermisorder(String permisorder) {
        this.permisorder = permisorder == null ? null : permisorder.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}