package com.company.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "configuration")
@Table(name = "configuration")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Configuration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Type(type = "json")
	@Column(name = "obo_choices", columnDefinition = "json")
	private ArrayList<String> oboChoices;

	public Configuration() {
		super();
	}

	public Configuration(long id, ArrayList<String> oboChoices) {
		super();
		this.id = id;
		this.oboChoices = oboChoices;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<String> getOboChoices() {
		return oboChoices;
	}

	public void setOboChoices(ArrayList<String> oboChoices) {
		this.oboChoices = oboChoices;
	}

}
