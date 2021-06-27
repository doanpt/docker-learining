package com.company.demo.model.dto;

public class PageableDto {
	private Object items;

	private int totalPages;

	private int currentPage;

	public PageableDto(Object items, int totalPages, int currentPage) {
		super();
		this.items = items;
		this.totalPages = totalPages;
		this.currentPage = currentPage;
	}

	public PageableDto() {
		super();
	}

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
