package com.company.demo.entity;

import com.company.demo.model.dto.ProductInfoDto;
import com.company.demo.model.dto.ShortProductInfoDto;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "productInfoDto", classes = @ConstructorResult(targetClass = ProductInfoDto.class, columns = {
				@ColumnResult(name = "id", type = String.class), @ColumnResult(name = "name", type = String.class),
				@ColumnResult(name = "slug", type = String.class), @ColumnResult(name = "price", type = Long.class),
				@ColumnResult(name = "total_sold", type = Integer.class),
				@ColumnResult(name = "image", type = String.class) })),
		@SqlResultSetMapping(name = "shortProductInfoDto", classes = @ConstructorResult(targetClass = ShortProductInfoDto.class, columns = {
				@ColumnResult(name = "id", type = String.class), @ColumnResult(name = "name", type = String.class) })),
		@SqlResultSetMapping(name = "productInfoAndAvailableSize", classes = @ConstructorResult(targetClass = ShortProductInfoDto.class, columns = {
				@ColumnResult(name = "id", type = String.class), @ColumnResult(name = "name", type = String.class),
				@ColumnResult(name = "price", type = Long.class),
				@ColumnResult(name = "sizes", type = String.class) })) })
@NamedNativeQuery(name = "getAllProduct", resultSetMapping = "shortProductInfoDto", query = "SELECT pro.id, pro.name \n"
		+ "FROM product pro")
@NamedNativeQuery(name = "getAvailableProducts", resultSetMapping = "productInfoAndAvailableSize", query = "SELECT pro.id, pro.name, pro.price,\n"
		+ "(SELECT JSON_ARRAYAGG(ps.size) FROM product_size ps WHERE ps.product_id = pro.id AND ps.quantity > 0) as sizes \n"
		+ "FROM product pro\n")
@NamedNativeQuery(name = "getListNewProduct", resultSetMapping = "productInfoDto", query = "SELECT pro.id, pro.name, pro.slug, pro.price, pro.total_sold, REPLACE(JSON_EXTRACT(pro.product_images, '$[0]'), '\"', '') as image \n"
		+ "FROM product pro\n" + "WHERE pro.is_available = true\n" + "ORDER BY created_at desc\n" + "LIMIT ?1 \n")
@NamedNativeQuery(name = "getListBestSellerProduct", resultSetMapping = "productInfoDto", query = "SELECT pro.id, pro.name, pro.slug, pro.price, pro.total_sold, REPLACE(JSON_EXTRACT(pro.product_images, '$[0]'), '\"', '') as image \n"
		+ "FROM product pro\n" + "WHERE pro.is_available = true\n" + "ORDER BY total_sold desc\n" + "LIMIT ?1 \n")
@NamedNativeQuery(name = "getListSuggestProduct", resultSetMapping = "productInfoDto", query = "SELECT pro.id, pro.name, pro.slug, pro.price, pro.total_sold, REPLACE(JSON_EXTRACT(pro.product_images, '$[0]'), '\"', '') as image \n"
		+ "FROM product pro\n" + "WHERE pro.is_available = true AND pro.id IN (?1)\n" + "LIMIT ?2 \n")
@NamedNativeQuery(name = "getRelatedProducts", resultSetMapping = "productInfoDto", query = "SELECT pro.id, pro.name, pro.slug, pro.price, pro.total_sold, REPLACE(JSON_EXTRACT(pro.product_images, '$[0]'), '\"', '') as image \n"
		+ "FROM product pro\n" + "WHERE pro.is_available = true AND\n" + "pro.id != ?1\n" + "ORDER BY RAND()\n"
		+ "LIMIT ?2\n")
@NamedNativeQuery(name = "searchProductBySize", resultSetMapping = "productInfoDto", query = "SELECT DISTINCT d.*\n"
		+ "FROM (\n"
		+ "SELECT DISTINCT product.id, product.name, product.slug, product.price, product.total_sold, REPLACE(JSON_EXTRACT(product.product_images, '$[0]'), '\"' ,'') as image\n"
		+ "FROM product \n" + "INNER JOIN product_category \n" + "ON product.id = product_category.product_id \n"
		+ "WHERE product.is_available = true AND product.brand_id IN (?1) AND product_category.category_id IN (?2)\n"
		+ "AND product.price > ?3 AND product.price < ?4) as d\n" + "INNER JOIN product_size \n"
		+ "ON product_size.product_id = d.id\n" + "WHERE product_size.size IN (?5)\n" + "LIMIT ?6\n" + "OFFSET ?7")
@NamedNativeQuery(name = "searchProductAllSize", resultSetMapping = "productInfoDto", query = "SELECT DISTINCT product.id, product.name, product.slug, product.price, product.total_sold, REPLACE(JSON_EXTRACT(product.product_images, '$[0]') , '\"','') as image\n"
		+ "FROM product \n" + "INNER JOIN product_category \n" + "ON product.id = product_category.product_id \n"
		+ "WHERE product.is_available = true AND product.brand_id IN (?1) AND product_category.category_id IN (?2)\n"
		+ "AND product.price > ?3 AND product.price < ?4\n" + "LIMIT ?5\n" + "OFFSET ?6")
@NamedNativeQuery(name = "searchProductByKeyword", resultSetMapping = "productInfoDto", query = "SELECT DISTINCT product.id, product.name, product.slug, product.price, product.total_sold, REPLACE(JSON_EXTRACT(product.product_images, '$[0]'), '\"' ,'') as image\n"
		+ "FROM product \n" + "INNER JOIN product_category \n" + "ON product.id = product_category.product_id \n"
		+ "INNER JOIN category\n" + "ON category.id = product_category.category_id\n"
		+ "WHERE product.is_available = true AND (product.name LIKE CONCAT('%',:keyword,'%') OR category.name LIKE CONCAT('%',:keyword,'%'))\n"
		+ "LIMIT :limit\n" + "OFFSET :offset")

@Entity(name = "product")
@Table(name = "product")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Product {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name", nullable = false, length = 300)
	private String name;

	@Column(name = "slug", nullable = false)
	private String slug;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column(name = "price")
	private long price;

	@Column(name = "total_sold")
	private int totalSold;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "is_available", columnDefinition = "TINYINT(1)")
	private boolean isAvailable;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	@Type(type = "json")
	@Column(name = "product_images", columnDefinition = "json")
	private ArrayList<String> productImages;

	@Type(type = "json")
	@Column(name = "onfeet_images", columnDefinition = "json")
	private ArrayList<String> onfeetImages;

	@PreRemove
	private void removeCategories() {
		this.categories.clear();
	}

	public Product() {
		super();
	}

	public Product(String id, String name, String slug, String description, Brand brand, long price, int totalSold,
			Timestamp createdAt, boolean isAvailable, List<Category> categories, ArrayList<String> productImages,
			ArrayList<String> onfeetImages) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.totalSold = totalSold;
		this.createdAt = createdAt;
		this.isAvailable = isAvailable;
		this.categories = categories;
		this.productImages = productImages;
		this.onfeetImages = onfeetImages;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public ArrayList<String> getProductImages() {
		return productImages;
	}

	public void setProductImages(ArrayList<String> productImages) {
		this.productImages = productImages;
	}

	public ArrayList<String> getOnfeetImages() {
		return onfeetImages;
	}

	public void setOnfeetImages(ArrayList<String> onfeetImages) {
		this.onfeetImages = onfeetImages;
	}

}
