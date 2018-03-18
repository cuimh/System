package com.cn.wy.pojoDto;

import java.util.List;

import com.cn.wy.pojo.Persission;

public class RolePerDto {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String rolename;
    
    private String menus;
    
    private String menuIds;

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

}
