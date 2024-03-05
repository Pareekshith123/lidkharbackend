package com.backend.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;


	@Column(name = "imageUrl")
	private String imageUrl;


	@Column(name = "productsName")

	private String productsName;

	@Column(name = "description")

	private String description;

	@Column(name = "price")

	private Integer price;

	
	@Column(name = "Size")
    private String Size;
	private String gender;
	private String itemCode;
	private String type;
	private String fit;
	private String toeShape;
	private String upper;
	private String lining;
	private String sole;
	private String color;
	private String sizeRange;
	private String boxDim;
	private String manufacturer;
    private String thickness;

    @ManyToOne
    @JoinColumn(name="category_id")
	private Category category;

    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

  
    
	public Products() {

		super();
	}


	public Products(Long productId, String imageUrl, String productsName, String description, Integer price,
			String size, String gender, String itemCode, String type, String fit, String toeShape, String upper,
			String lining, String sole, String color, String sizeRange, String boxDim, String manufacturer,
			String thickness, Category category, List<CartItem> cartItems) {
		super();
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.productsName = productsName;
		this.description = description;
		this.price = price;
		Size = size;
		this.gender = gender;
		this.itemCode = itemCode;
		this.type = type;
		this.fit = fit;
		this.toeShape = toeShape;
		this.upper = upper;
		this.lining = lining;
		this.sole = sole;
		this.color = color;
		this.sizeRange = sizeRange;
		this.boxDim = boxDim;
		this.manufacturer = manufacturer;
		this.thickness = thickness;
		this.category = category;
		this.cartItems = cartItems;
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


	public String getProductsName() {
		return productsName;
	}


	public void setProductsName(String productsName) {
		this.productsName = productsName;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getFit() {
		return fit;
	}


	public void setFit(String fit) {
		this.fit = fit;
	}


	public String getToeShape() {
		return toeShape;
	}


	public void setToeShape(String toeShape) {
		this.toeShape = toeShape;
	}


	public String getUpper() {
		return upper;
	}


	public void setUpper(String upper) {
		this.upper = upper;
	}


	public String getLining() {
		return lining;
	}


	public void setLining(String lining) {
		this.lining = lining;
	}


	public String getSole() {
		return sole;
	}


	public void setSole(String sole) {
		this.sole = sole;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSizeRange() {
		return sizeRange;
	}


	public void setSizeRange(String sizeRange) {
		this.sizeRange = sizeRange;
	}


	public String getBoxDim() {
		return boxDim;
	}


	public void setBoxDim(String boxDim) {
		this.boxDim = boxDim;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getThickness() {
		return thickness;
	}


	public void setThickness(String thickness) {
		this.thickness = thickness;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}






}
