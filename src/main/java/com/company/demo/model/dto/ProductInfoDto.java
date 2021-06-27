package com.company.demo.model.dto;

public class ProductInfoDto {
	private String id;

	private String name;

	private String slug;

	private long price;

	private int totalSold;

	private String image;

	private long promotionPrice;

	public ProductInfoDto(String id, String name, String slug, long price, int totalSold, String image) {
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.price = price;
		this.totalSold = totalSold;
		this.image = image;
	}

	public ProductInfoDto() {
		super();
	}

	public ProductInfoDto(String id, String name, String slug, long price, int totalSold, String image,
			long promotionPrice) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.price = price;
		this.totalSold = totalSold;
		this.image = image;
		this.promotionPrice = promotionPrice;
	}

	@Override
	public String toString() {
		return "ProductInfoDto [id=" + id + ", name=" + name + ", slug=" + slug + ", price=" + price + ", totalSold="
				+ totalSold + ", image=" + image + ", promotionPrice=" + promotionPrice + "]";
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(long promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

}
