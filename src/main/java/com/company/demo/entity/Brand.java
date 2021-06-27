package com.company.demo.entity;

import com.company.demo.model.dto.BrandInfo;
import javax.persistence.*;

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "brandInfo", classes = @ConstructorResult(targetClass = BrandInfo.class, columns = {
				@ColumnResult(name = "id", type = Integer.class), @ColumnResult(name = "name", type = String.class),
				@ColumnResult(name = "thumbnail", type = String.class),
				@ColumnResult(name = "product_count", type = Integer.class) })) })
@NamedNativeQuery(name = "getListBrandAndProductCount", resultSetMapping = "brandInfo", query = "SELECT brand.id, brand.name, brand.thumbnail,\n"
		+ "(\n" + "    SELECT count(product.id)\n" + "    FROM product\n" + "    WHERE product.brand_id = brand.id\n"
		+ ") product_count \n" + "FROM brand ")

@Entity(name = "brand")
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "thumbnail")
	private String thumbnail;

	public Brand(int id, String name, String thumbnail) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
	}

	public Brand() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
