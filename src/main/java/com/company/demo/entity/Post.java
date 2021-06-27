package com.company.demo.entity;

import com.company.demo.model.dto.PostInfoDto;
import javax.persistence.*;
import java.sql.Timestamp;

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "postInfoDto", classes = @ConstructorResult(targetClass = PostInfoDto.class, columns = {
				@ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "slug", type = String.class),
				@ColumnResult(name = "title", type = String.class),
				@ColumnResult(name = "created_time", type = String.class),
				@ColumnResult(name = "published_time", type = String.class),
				@ColumnResult(name = "status", type = String.class) })) })
@NamedNativeQuery(name = "adminGetListPost", resultSetMapping = "postInfoDto", query = "SELECT id, slug, title, \n"
		+ "DATE_FORMAT(created_at,'%d/%m/%Y %H:%i') as created_time,\n"
		+ "DATE_FORMAT(published_at,'%d/%m/%Y %H:%i') as published_time,\n" + "(\n" + "\tCASE \n"
		+ "\t\tWHEN status = true THEN 'Công khai'\n" + "    \tELSE 'Nháp'\n" + "    END \n" + ") as status\n"
		+ "FROM post\n" + "WHERE title LIKE CONCAT('%',:title,'%') AND status LIKE CONCAT('%',:status,'%')\n"
		+ "ORDER BY :order :direction\n" + "LIMIT :limit\n" + "OFFSET :offset")

@Entity(name = "post")
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "title", nullable = false, length = 300)
	private String title;

	@Column(name = "slug", nullable = false, length = 600)
	private String slug;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "status", columnDefinition = "int default 0")
	private int status;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "modified_at")
	private Timestamp modifiedAt;

	@Column(name = "published_at")
	private Timestamp publishedAt;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by")
	private User modifiedBy;

	public Post() {
		super();
	}

	public Post(long id, String title, String slug, String description, String content, String thumbnail, int status,
			Timestamp createdAt, Timestamp modifiedAt, Timestamp publishedAt, User createdBy, User modifiedBy) {
		super();
		this.id = id;
		this.title = title;
		this.slug = slug;
		this.description = description;
		this.content = content;
		this.thumbnail = thumbnail;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.publishedAt = publishedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Timestamp getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Timestamp publishedAt) {
		this.publishedAt = publishedAt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
