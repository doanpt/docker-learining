package com.company.demo.entity;

import com.company.demo.model.dto.CategoryInfo;
import javax.persistence.*;

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "categoryInfo", classes = @ConstructorResult(targetClass = CategoryInfo.class, columns = {
				@ColumnResult(name = "id", type = Integer.class), @ColumnResult(name = "name", type = String.class),
				@ColumnResult(name = "product_count", type = Integer.class) })) })
@NamedNativeQuery(name = "getListCategoryAndProductCount", resultSetMapping = "categoryInfo", query = "SELECT category.id, category.name, \n"
		+ "(\n" + "    SELECT count(product_id)\n" + "    FROM product_category\n"
		+ "    WHERE product_category.category_id = category.id\n" + ") product_count \n" + "FROM category ")

@Entity(name = "category")
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, length = 300)
	private String name;

	public Category() {
		super();
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
