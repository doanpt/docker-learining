package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class UpdateOnfeetImagesReq {
	@JsonProperty("onfeet_images")
	private ArrayList<String> onfeetImages;

	public UpdateOnfeetImagesReq(ArrayList<String> onfeetImages) {
		super();
		this.onfeetImages = onfeetImages;
	}

	public UpdateOnfeetImagesReq() {
		super();
	}

	public ArrayList<String> getOnfeetImages() {
		return onfeetImages;
	}

	public void setOnfeetImages(ArrayList<String> onfeetImages) {
		this.onfeetImages = onfeetImages;
	}

}
