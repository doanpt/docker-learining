package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;

public class UpdateDetailOrderReq {
	@NotNull(message = "Sản phẩm trống")
	@NotEmpty(message = "Sản phẩm trống")
	@JsonProperty("product_id")
	private String productId;

	@Min(value = 35)
	@Max(value = 42)
	private int size;

	@JsonProperty("coupon_code")
	private String couponCode;

	@JsonProperty("total_price")
	private long totalPrice;

	@JsonProperty("product_price")
	private long productPrice;

	public UpdateDetailOrderReq() {
		super();
	}

	public UpdateDetailOrderReq(
			@NotNull(message = "Sản phẩm trống") @NotEmpty(message = "Sản phẩm trống") String productId,
			@Min(35) @Max(42) int size, String couponCode, long totalPrice, long productPrice) {
		super();
		this.productId = productId;
		this.size = size;
		this.couponCode = couponCode;
		this.totalPrice = totalPrice;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

}
