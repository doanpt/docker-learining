package com.company.demo.model.request;

import javax.validation.constraints.*;

public class CreateCategoryReq {
    @NotNull(message = "Tên category trống")
    @NotEmpty(message = "Tên category trống")
    @Size(min = 1, max = 300, message = "Độ dài tên category từ 1 - 300 ký tự")
    private String name;

	public CreateCategoryReq(
			@NotNull(message = "Tên category trống") @NotEmpty(message = "Tên category trống") @Size(min = 1, max = 300, message = "Độ dài tên category từ 1 - 300 ký tự") String name) {
		super();
		this.name = name;
	}

	public CreateCategoryReq() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
