package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.util.ArrayList;

public class CreateProductReq {
	@NotNull(message = "Tên sản phẩm trống")
	@NotEmpty(message = "Tên sản phẩm trống")
	@Size(min = 1, max = 300, message = "Độ dài tên sản phẩm từ 1 - 300 ký tự")
	@ApiModelProperty(example = "Adidas KH422", notes = "Tên sản phẩm trống", required = true)
	private String name;

	@NotNull(message = "Mô tả trống")
	@NotEmpty(message = "Mô tả trống")
	@ApiModelProperty(example = "Lorem", notes = "Mô tả trống", required = true)
	private String description;

	@NotNull(message = "Nhãn hiệu trống")
	@ApiModelProperty(example = "1", notes = "Nhãn hiệu trống", required = true)
	@JsonProperty("brand_id")
	private Integer brandId;

	@NotNull(message = "Category trống")
	@ApiModelProperty(example = "[1]", notes = "Category trống", required = true)
	@JsonProperty("category_ids")
	private ArrayList<Integer> categoryIds;

	@JsonProperty("is_available")
	private boolean isAvailable;

	@Min(1000)
	@Max(1000000000)
	@ApiModelProperty(example = "4000000", notes = "Giá tiền không hợp lệ", required = true)
	private Integer price;

	@NotNull(message = "Danh sách ảnh trống")
	@ApiModelProperty(example = "[img1.jpg, img2.jpg]", notes = "Danh sách ảnh trống", required = true)
	@JsonProperty("product_images")
	private ArrayList<String> productImages;

	public CreateProductReq() {
		super();
	}

	public CreateProductReq(
			@NotNull(message = "Tên sản phẩm trống") @NotEmpty(message = "Tên sản phẩm trống") @Size(min = 1, max = 300, message = "Độ dài tên sản phẩm từ 1 - 300 ký tự") String name,
			@NotNull(message = "Mô tả trống") @NotEmpty(message = "Mô tả trống") String description,
			@NotNull(message = "Nhãn hiệu trống") Integer brandId,
			@NotNull(message = "Category trống") ArrayList<Integer> categoryIds, boolean isAvailable,
			@Min(1000) @Max(1000000000) Integer price,
			@NotNull(message = "Danh sách ảnh trống") ArrayList<String> productImages) {
		super();
		this.name = name;
		this.description = description;
		this.brandId = brandId;
		this.categoryIds = categoryIds;
		this.isAvailable = isAvailable;
		this.price = price;
		this.productImages = productImages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public ArrayList<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(ArrayList<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public ArrayList<String> getProductImages() {
		return productImages;
	}

	public void setProductImages(ArrayList<String> productImages) {
		this.productImages = productImages;
	}

}
