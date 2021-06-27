package com.company.demo.entity;

import javax.persistence.*;

@Entity(name = "product_size")
@Table(name = "product_size")
@IdClass(ProductSizeId.class)
public class ProductSize {
	@Id
	@Column(name = "product_id")
	private String productId;

	@Id
	@Column(name = "size")
	private int size;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	public ProductSize() {
		super();
	}

	public ProductSize(String productId, int size, int quantity) {
		super();
		this.productId = productId;
		this.size = size;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
