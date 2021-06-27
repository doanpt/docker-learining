package com.company.demo.model.dto;

import com.company.demo.entity.Brand;
import java.util.ArrayList;

public class DetailProductInfoDto {
	private String id;

	private String name;

	private String slug;

	private long price;

	private int totalSold;

	private ArrayList<String> productImages;

	private ArrayList<String> onfeetImages;

	private long promotionPrice;

	private String couponCode;

	private String description;

	private Brand brand;

	public DetailProductInfoDto(String id, String name, String slug, long price, int totalSold,
			ArrayList<String> productImages, ArrayList<String> onfeetImages, long promotionPrice, String couponCode,
			String description, Brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.price = price;
		this.totalSold = totalSold;
		this.productImages = productImages;
		this.onfeetImages = onfeetImages;
		this.promotionPrice = promotionPrice;
		this.couponCode = couponCode;
		this.description = description;
		this.brand = brand;
	}

	public DetailProductInfoDto() {
		super();
	}

	@Override
	public String toString() {
		return "DetailProductInfoDto [id=" + id + ", name=" + name + ", slug=" + slug + ", price=" + price
				+ ", totalSold=" + totalSold + ", productImages=" + productImages + ", onfeetImages=" + onfeetImages
				+ ", promotionPrice=" + promotionPrice + ", couponCode=" + couponCode + ", description=" + description
				+ ", brand=" + brand + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}

	public ArrayList<String> getProductImages() {
		return productImages;
	}

	public void setProductImages(ArrayList<String> productImages) {
		this.productImages = productImages;
	}

	public ArrayList<String> getOnfeetImages() {
		return onfeetImages;
	}

	public void setOnfeetImages(ArrayList<String> onfeetImages) {
		this.onfeetImages = onfeetImages;
	}

	public long getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(long promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
