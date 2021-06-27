package com.company.demo.model.dto;

public class CategoryInfo {
	private int id;

	private String name;

	private int productCount;

	public CategoryInfo(int id, String name, int productCount) {
		super();
		this.id = id;
		this.name = name;
		this.productCount = productCount;
	}

	public CategoryInfo() {
		super();
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

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

}
