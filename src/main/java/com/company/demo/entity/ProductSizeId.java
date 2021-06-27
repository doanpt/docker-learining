package com.company.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductSizeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productId;

	private int size;

	public ProductSizeId() {
		super();
	}

	public ProductSizeId(String productId, int size) {
		super();
		this.productId = productId;
		this.size = size;
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

	@Override
	public int hashCode() {
		return Objects.hash(productId, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSizeId other = (ProductSizeId) obj;
		return Objects.equals(productId, other.productId) && size == other.size;
	}

}
