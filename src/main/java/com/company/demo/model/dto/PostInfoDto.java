package com.company.demo.model.dto;

public class PostInfoDto {
	private long id;

	private String slug;

	private String title;

	private String createdAt;

	private String publishedAt;

	private String status;

	public PostInfoDto(long id, String slug, String title, String createdAt, String publishedAt, String status) {
		super();
		this.id = id;
		this.slug = slug;
		this.title = title;
		this.createdAt = createdAt;
		this.publishedAt = publishedAt;
		this.status = status;
	}

	public PostInfoDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
