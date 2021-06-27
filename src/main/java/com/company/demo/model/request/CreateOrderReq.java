package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class CreateOrderReq {
	@NotNull(message = "Sản phẩm trống")
	@NotEmpty(message = "Sản phẩm trống")
	@JsonProperty("product_id")
	private String productId;

	@Min(value = 35)
	@Max(value = 42)
	private int size;

	@NotNull(message = "Họ tên trống")
	@NotEmpty(message = "Họ tên trống")
	@ApiModelProperty(example = "Sam Smith", notes = "Họ tên trống", required = true)
	@JsonProperty("receiver_name")
	private String receiverName;

	@Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Điện thoại không hợp lệ")
	@ApiModelProperty(example = "0916016972", notes = "Điện thoại trống", required = true)
	@JsonProperty("receiver_phone")
	private String receiverPhone;

	@NotNull(message = "Địa chỉ trống")
	@NotEmpty(message = "Địa chỉ trống")
	@ApiModelProperty(example = "Ha Noi", notes = "Địa chỉ trống", required = true)
	@JsonProperty("receiver_address")
	private String receiverAddress;

	@JsonProperty("coupon_code")
	private String couponCode;

	@JsonProperty("total_price")
	private long totalPrice;

	@JsonProperty("product_price")
	private long productPrice;

	private String note;

	public CreateOrderReq() {
		super();
	}

	public CreateOrderReq(@NotNull(message = "Sản phẩm trống") @NotEmpty(message = "Sản phẩm trống") String productId,
			@Min(35) @Max(42) int size,
			@NotNull(message = "Họ tên trống") @NotEmpty(message = "Họ tên trống") String receiverName,
			@Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Điện thoại không hợp lệ") String receiverPhone,
			@NotNull(message = "Địa chỉ trống") @NotEmpty(message = "Địa chỉ trống") String receiverAddress,
			String couponCode, long totalPrice, long productPrice, String note) {
		super();
		this.productId = productId;
		this.size = size;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.couponCode = couponCode;
		this.totalPrice = totalPrice;
		this.productPrice = productPrice;
		this.note = note;
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

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
