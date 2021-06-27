package com.company.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "image")
@Table(name = "image")
public class Image {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "size")
	private long size;

	@Column(name = "type")
	private String type;

	@Column(name = "link", unique = true)
	private String link;

	@ManyToOne
	@JoinColumn(name = "uploaded_by")
	private User uploadedBy;

	@Column(name = "uploaded_at")
	private Timestamp uploadedAt;

	public Image() {
		super();
	}

	public Image(String id, String name, long size, String type, String link, User uploadedBy, Timestamp uploadedAt) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.type = type;
		this.link = link;
		this.uploadedBy = uploadedBy;
		this.uploadedAt = uploadedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public User getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(User uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Timestamp getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(Timestamp uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

}
