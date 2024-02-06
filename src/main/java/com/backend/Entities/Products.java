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

}
