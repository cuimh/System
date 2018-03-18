package com.cn.wy.utils;


import java.util.List;

public class DataPage<T> extends Paging {
	private static final long serialVersionUID = -7490360935699028447L;

	/**
	 * 鍒嗛〉鑾峰彇鐨勬暟鎹垪琛�
	 */
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
