package com.company.demo.model.request;

import javax.validation.constraints.*;

public class CreateBrandReq {
    @NotNull(message = "Tên nhãn hiệu trống")
    @NotEmpty(message = "Tên nhãn hiệu trống")
    @Size(min = 1, max = 255, message = "Độ dài tên nhãn hiệu từ 1 - 255 ký tự")
    private String name;

    @NotNull(message = "Logo trống")
    @NotEmpty(message = "Logo trống")
    private String thumbnail;

	public CreateBrandReq(
			@NotNull(message = "Tên nhãn hiệu trống") @NotEmpty(message = "Tên nhãn hiệu trống") @Size(min = 1, max = 255, message = "Độ dài tên nhãn hiệu từ 1 - 255 ký tự") String name,
			@NotNull(message = "Logo trống") @NotEmpty(message = "Logo trống") String thumbnail) {
		super();
		this.name = name;
		this.thumbnail = thumbnail;
	}

	public CreateBrandReq() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
    
    
}
