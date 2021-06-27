package com.company.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "users")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "full_name", nullable = false, length = 200)
	private String fullName;

	@Column(name = "email", nullable = false, unique = true, length = 200)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Type(type = "json")
	@Column(name = "roles", nullable = false, columnDefinition = "json")
	private List<String> roles;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "status", columnDefinition = "BOOLEAN")
	private boolean status;

	@Column(name = "created_at")
	private Timestamp createdAt;

	public User(long id) {
		this.id = id;
	}

	public User() {
		super();
	}

	public User(long id, String fullName, String email, String password, List<String> roles, String address,
			String phone, boolean status, Timestamp createdAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}
