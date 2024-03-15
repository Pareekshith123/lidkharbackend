package com.backend.Entities;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "image")
public class Images {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long imageId;
	    private String name;
	    private String path;
	    @ManyToOne
	    @JoinColumn(name="product_id")
	    @JsonIgnore
	    private Products product;
		public Images() {
			super();
		}
		public Images(Long imageId, String name, String path, Products product) {
			super();
			this.imageId = imageId;
			this.name = name;
			this.path = path;
			this.product = product;
		}
		public Long getImageId() {
			return imageId;
		}
		public void setImageId(Long imageId) {
			this.imageId = imageId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public Products getProduct() {
			return product;
		}
		public void setProduct(Products product) {
			this.product = product;
		}
	
}
