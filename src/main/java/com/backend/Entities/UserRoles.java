package com.backend.Entities;

import org.modelmapper.internal.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(name = "role")
	private String role;

	@Column(name = "modelPermission")
	private String modelPermission;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;;

	public UserRoles() {
		super();
	}

	public UserRoles(Long roleId, String role, String modelPermission, User user) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.modelPermission = modelPermission;
		this.user = user;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getModelPermission() {
		return modelPermission;
	}

	public void setModelPermission(String modelPermission) {
		this.modelPermission = modelPermission;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
