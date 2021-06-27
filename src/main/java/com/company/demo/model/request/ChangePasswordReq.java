package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

public class ChangePasswordReq {
	@NotNull(message = "Mật khẩu cũ trống")
	@NotEmpty(message = "Mật khẩu cũ trống")
	@Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự")
	@ApiModelProperty(example = "verysecretpassword", notes = "Mật khẩu trống", required = true)
	@JsonProperty("old_password")
	private String oldPassword;

	@NotNull(message = "Mật khẩu mới trống")
	@NotEmpty(message = "Mật khẩu mới trống")
	@Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự")
	@ApiModelProperty(example = "verysecretpassword", notes = "Mật khẩu trống", required = true)
	@JsonProperty("new_password")
	private String newPassword;

	public ChangePasswordReq(
			@NotNull(message = "Mật khẩu cũ trống") @NotEmpty(message = "Mật khẩu cũ trống") @Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự") String oldPassword,
			@NotNull(message = "Mật khẩu mới trống") @NotEmpty(message = "Mật khẩu mới trống") @Size(min = 4, max = 20, message = "Mật khẩu phải chứa từ 4 - 20 ký tự") String newPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public ChangePasswordReq() {
		super();
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
