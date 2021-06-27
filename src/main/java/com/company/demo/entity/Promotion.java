package com.company.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "promotion")
@Table(name = "promotion")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false, length = 300)
	private String name;

	@Column(name = "discount_value")
	private long discountValue;

	@Column(name = "maximum_discount_value")
	private long maximumDiscountValue;

	@Column(name = "discount_type")
	private int discountType;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "expired_at")
	private Timestamp expiredAt;

	@Column(name = "coupon_code", unique = true)
	private String couponCode;

	@Column(name = "is_active", columnDefinition = "TINYINT(1)")
	private boolean isActive;

	@Column(name = "is_public", columnDefinition = "TINYINT(1)")
	private boolean isPublic;

	public Promotion(Order.UsedPromotion promotion) {
		this.discountValue = promotion.getDiscountValue();
		this.maximumDiscountValue = promotion.getMaximumDiscountValue();
		this.discountType = promotion.getDiscountType();
		this.couponCode = promotion.getCouponCode();
	}

	public Promotion() {
		super();
	}

	public Promotion(long id, String name, long discountValue, long maximumDiscountValue, int discountType,
			Timestamp createdAt, Timestamp expiredAt, String couponCode, boolean isActive, boolean isPublic) {
		super();
		this.id = id;
		this.name = name;
		this.discountValue = discountValue;
		this.maximumDiscountValue = maximumDiscountValue;
		this.discountType = discountType;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.couponCode = couponCode;
		this.isActive = isActive;
		this.isPublic = isPublic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(Timestamp expiredAt) {
		this.expiredAt = expiredAt;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

}
