package com.backend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	private Long productId;
	@Column(name = "imageUrl")
	private String imageUrl;
	@Column(name = "name")

	private String name;
	@Column(name = "description")

	private String description;
	@Column(name = "price")

	private Integer price;
	
	@Column(name = "Size")
    private String Size;
    @ManyToOne
    @JoinColumn(name="categoryId")
	private Category category;
    
	public Products() {
		super();
	}
	public Products(Long productId, String imageUrl, String name, String description, Integer price, String size,
			Category category) {
		super();
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.name = name;
		this.description = description;
		this.price = price;
		Size = size;
		this.category = category;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
