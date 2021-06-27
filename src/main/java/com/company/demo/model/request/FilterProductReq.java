package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FilterProductReq {
    private List<Integer> brands;

    private List<Integer> categories;

    private List<Integer> sizes;

    @JsonProperty("min_price")
    private Long minPrice;

    @JsonProperty("max_price")
    private Long maxPrice;

    private int page;

	public FilterProductReq() {
		super();
	}

	public FilterProductReq(List<Integer> brands, List<Integer> categories, List<Integer> sizes, Long minPrice,
			Long maxPrice, int page) {
		super();
		this.brands = brands;
		this.categories = categories;
		this.sizes = sizes;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.page = page;
	}

	public List<Integer> getBrands() {
		return brands;
	}

	public void setBrands(List<Integer> brands) {
		this.brands = brands;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

	public List<Integer> getSizes() {
		return sizes;
	}

	public void setSizes(List<Integer> sizes) {
		this.sizes = sizes;
	}

	public Long getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Long minPrice) {
		this.minPrice = minPrice;
	}

	public Long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Long maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
    
    
}