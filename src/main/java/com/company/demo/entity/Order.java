package com.company.demo.entity;

import com.company.demo.model.dto.OrderDetailDto;
import com.company.demo.model.dto.OrderInfoDto;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.sql.Timestamp;

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "orderInfoDto", classes = @ConstructorResult(targetClass = OrderInfoDto.class, columns = {
				@ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "total_price", type = Long.class),
				@ColumnResult(name = "size_vn", type = Integer.class),
				@ColumnResult(name = "product_name", type = String.class),
				@ColumnResult(name = "product_img", type = String.class) })),
		@SqlResultSetMapping(name = "orderDetailDto", classes = @ConstructorResult(targetClass = OrderDetailDto.class, columns = {
				@ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "total_price", type = Long.class),
				@ColumnResult(name = "product_price", type = Long.class),
				@ColumnResult(name = "receiver_name", type = String.class),
				@ColumnResult(name = "receiver_phone", type = String.class),
				@ColumnResult(name = "receiver_address", type = String.class),
				@ColumnResult(name = "status", type = Integer.class),
				@ColumnResult(name = "size_vn", type = Integer.class),
				@ColumnResult(name = "product_name", type = String.class),
				@ColumnResult(name = "product_img", type = String.class) })) })
@NamedNativeQuery(name = "getListOrderOfPersonByStatus", resultSetMapping = "orderInfoDto", query = "SELECT orders.id, orders.total_price, orders.size size_vn, product.name product_name, REPLACE(JSON_EXTRACT(product.product_images, '$[0]'), '\"', '') as product_img\n"
		+ "FROM orders\n" + "INNER JOIN product \n" + "ON orders.product_id = product.id\n"
		+ "WHERE orders.status = ?1 AND orders.buyer = ?2")
@NamedNativeQuery(name = "userGetDetailById", resultSetMapping = "orderDetailDto", query = "SELECT orders.id, orders.total_price, orders.size size_vn, product.name product_name, orders.product_price,\n"
		+ "orders.receiver_name, orders.receiver_phone, orders.receiver_address, orders.status,\n"
		+ "product.product_images ->> \"$[0]\" as product_img\n" + "FROM orders\n" + "INNER JOIN product \n"
		+ "ON orders.product_id = product.id\n" + "WHERE orders.id = ?1 AND orders.buyer = ?2")

@Entity(name = "orders")
@Table(name = "orders")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "receiver_name")
	private String receiverName;

	@Column(name = "receiver_phone")
	private String receiverPhone;

	@Column(name = "receiver_address")
	private String receiverAddress;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "size")
	private int size;

	@Column(name = "total_price")
	private long totalPrice;

	@Column(name = "product_price")
	private long productPrice;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "modified_at")
	private Timestamp modifiedAt;

	@ManyToOne
	@JoinColumn(name = "buyer")
	private User buyer;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "modified_by")
	private User modifiedBy;

	@Column(name = "status")
	private int status;

	@Type(type = "json")
	@Column(name = "promotion", columnDefinition = "json")
	private UsedPromotion promotion;

	public static class UsedPromotion {
		private String couponCode;

		private int discountType;

		private long discountValue;

		private long maximumDiscountValue;

		public UsedPromotion() {
			super();
		}

		public UsedPromotion(String couponCode, int discountType, long discountValue, long maximumDiscountValue) {
			super();
			this.couponCode = couponCode;
			this.discountType = discountType;
			this.discountValue = discountValue;
			this.maximumDiscountValue = maximumDiscountValue;
		}

		public String getCouponCode() {
			return couponCode;
		}

		public void setCouponCode(String couponCode) {
			this.couponCode = couponCode;
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

	@Column(name = "note")
	private String note;

	public Order() {
		super();
	}

	public Order(long id, String receiverName, String receiverPhone, String receiverAddress, Product product, int size,
			long totalPrice, long productPrice, Timestamp createdAt, Timestamp modifiedAt, User buyer, User createdBy,
			User modifiedBy, int status, UsedPromotion promotion, String note) {
		super();
		this.id = id;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.product = product;
		this.size = size;
		this.totalPrice = totalPrice;
		this.productPrice = productPrice;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.buyer = buyer;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.status = status;
		this.promotion = promotion;
		this.note = note;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
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

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UsedPromotion getPromotion() {
		return promotion;
	}

	public void setPromotion(UsedPromotion promotion) {
		this.promotion = promotion;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
