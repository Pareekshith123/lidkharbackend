package com.backend.Dtos;

import jakarta.persistence.Column;

public class ProductsDto {


     
		private Long productId;
	
		private String imageUrl;


		private String name;
	

		private String description;


		private Integer price;
		

	    private String Size;
	    


		public ProductsDto() {
			super();
		}


		public ProductsDto(Long productId, String imageUrl, String name, String description, Integer price,
				String size) {
			super();
			this.productId = productId;
			this.imageUrl = imageUrl;
			this.name = name;
			this.description = description;
			this.price = price;
			Size = size;
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
	

}
