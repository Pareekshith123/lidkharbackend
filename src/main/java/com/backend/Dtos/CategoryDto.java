package com.backend.Dtos;

import java.util.ArrayList;

import java.util.List;


public class CategoryDto {

    private Long categoryId;
    private String title;
    private String description;
    
    private List<ProductsDto> products = new ArrayList<>();

    public CategoryDto() {
        super();
    }

    public CategoryDto(Long categoryId, String title, String description, List<ProductsDto> products) {
        super();
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.products = products;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductsDto> getProducts() {

        return products;
    }

    public void setProducts(List<ProductsDto> products) {
        this.products = products;
    }

}
