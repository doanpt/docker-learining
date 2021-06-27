package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

public class UpdateStatusOrderReq {
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

	private String note;

	private int status;

	public UpdateStatusOrderReq() {
		super();
	}

	public UpdateStatusOrderReq(
			@NotNull(message = "Họ tên trống") @NotEmpty(message = "Họ tên trống") String receiverName,
			@Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Điện thoại không hợp lệ") String receiverPhone,
			@NotNull(message = "Địa chỉ trống") @NotEmpty(message = "Địa chỉ trống") String receiverAddress,
			String note, int status) {
		super();
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.note = note;
		this.status = status;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
