package com.company.demo.model.dto;

public class ImgDto {
	private String gridItemImg;

	public ImgDto(String gridItemImg) {
		super();
		this.gridItemImg = gridItemImg;
	}

	public ImgDto() {
		super();
	}

	public String getGridItemImg() {
		return gridItemImg;
	}

	public void setGridItemImg(String gridItemImg) {
		this.gridItemImg = gridItemImg;
	}

	@Override
	public String toString() {
		return "ImgDto [gridItemImg=" + gridItemImg + "]";
	}

}
