package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.sql.Timestamp;

public class CreatePromotionReq {
	@NotNull(message = "Mã code rỗng")
	@NotEmpty(message = "Mã code rỗng")
	@Pattern(regexp = "^[0-9A-Z-]+$", message = "Mã code không đúng định dạng")
	private String code;

	@NotNull(message = "Tên rỗng")
	@NotEmpty(message = "Tên rỗng")
	@Size(min = 1, max = 300, message = "Độ dài tên từ 1 - 300 kí tự")
	private String name;

	@Min(1)
	@Max(2)
	@JsonProperty("discount_type")
	private int discountType;

	@JsonProperty("discount_value")
	private long discountValue;

	@JsonProperty("max_value")
	private long maxValue;

	@JsonProperty("is_public")
	private boolean isPublic;

	private boolean active;

	public CreatePromotionReq() {
		super();
	}

	public CreatePromotionReq(
			@NotNull(message = "Mã code rỗng") @NotEmpty(message = "Mã code rỗng") @Pattern(regexp = "^[0-9A-Z-]+$", message = "Mã code không đúng định dạng") String code,
			@NotNull(message = "Tên rỗng") @NotEmpty(message = "Tên rỗng") @Size(min = 1, max = 300, message = "Độ dài tên từ 1 - 300 kí tự") String name,
			@Min(1) @Max(2) int discountType, long discountValue, long maxValue, boolean isPublic, boolean active,
			Timestamp expiredDate) {
		super();
		this.code = code;
		this.name = name;
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.maxValue = maxValue;
		this.isPublic = isPublic;
		this.active = active;
		this.expiredDate = expiredDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@JsonProperty("expired_date")
	private Timestamp expiredDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

}
