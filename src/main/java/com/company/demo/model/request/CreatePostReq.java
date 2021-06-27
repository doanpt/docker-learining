package com.company.demo.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePostReq {
	@NotNull(message = "Tiêu đề rỗng")
	@NotEmpty(message = "Tiêu đề rỗng")
	@Size(min = 1, max = 300, message = "Độ dài tiêu đề từ 1 - 300 ký tự")
	private String title;

	@NotNull(message = "Nội dung rỗng")
	@NotEmpty(message = "Nội dung rỗng")
	private String content;

	private String description;

	private int status;

	private String image;

	public CreatePostReq(
			@NotNull(message = "Tiêu đề rỗng") @NotEmpty(message = "Tiêu đề rỗng") @Size(min = 1, max = 300, message = "Độ dài tiêu đề từ 1 - 300 ký tự") String title,
			@NotNull(message = "Nội dung rỗng") @NotEmpty(message = "Nội dung rỗng") String content, String description,
			int status, String image) {
		super();
		this.title = title;
		this.content = content;
		this.description = description;
		this.status = status;
		this.image = image;
	}

	public CreatePostReq() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
