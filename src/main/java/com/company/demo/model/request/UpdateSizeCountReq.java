package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateSizeCountReq {
	private int size;

	@Min(0)
	private int count;

	@NotEmpty(message = "Mã sản phẩm trống")
	@NotNull(message = "Mã sản phẩm trống")
	@JsonProperty("product_id")
	private String productId;

	public UpdateSizeCountReq(int size, @Min(0) int count,
			@NotEmpty(message = "Mã sản phẩm trống") @NotNull(message = "Mã sản phẩm trống") String productId) {
		super();
		this.size = size;
		this.count = count;
		this.productId = productId;
	}

	public UpdateSizeCountReq() {
		super();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
