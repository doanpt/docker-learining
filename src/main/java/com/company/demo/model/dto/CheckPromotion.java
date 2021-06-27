package com.company.demo.model.dto;

public class CheckPromotion {
	private int discountType;

	private long discountValue;

	private long maximumDiscountValue;

	public CheckPromotion() {
		super();
	}

	public CheckPromotion(int discountType, long discountValue, long maximumDiscountValue) {
		super();
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.maximumDiscountValue = maximumDiscountValue;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public long getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(long discountValue) {
		this.discountValue = discountValue;
	}

	public long getMaximumDiscountValue() {
		return maximumDiscountValue;
	}

	public void setMaximumDiscountValue(long maximumDiscountValue) {
		this.maximumDiscountValue = maximumDiscountValue;
	}

}
