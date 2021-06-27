package com.company.demo.model.dto;

public class BrandInfo {
	private int id;

	private String name;

	private String thumbnail;

	private int productCount;

	public BrandInfo() {
		super();
	}

	public BrandInfo(int id, String name, String thumbnail, int productCount) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
		this.productCount = productCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

}
