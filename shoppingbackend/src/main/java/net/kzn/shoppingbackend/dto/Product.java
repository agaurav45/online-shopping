package net.kzn.shoppingbackend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Private fields
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	@NotBlank(message="Please enter the Product Name!")
	private String name;
	
	@NotBlank(message="Please enter the Brand Name!")
	private String brand;
	
	@JsonIgnore
	@NotBlank(message="Please enter the description for Product!")
	private String description;
	
	@Column(name="unit_price")
	@Min(value=1, message="The price cannot be less than 1!")
	private double unitPrice;
	
	private int quantity;
	
	@Column(name="is_active")
	private boolean active;
	
	@Column(name="category_id")
	@JsonIgnore
	private int categoryId;
	
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierId;
	
	private double purchases;
	
	private double views;
	
	
	@Transient
	private MultipartFile file;
	
	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	//default constructor
	public Product() {
		
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}

	
	//setters and getters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}


	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return the categoryId
	 */
	public double getCategoryId() {
		return categoryId;
	}


	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(double categoryId) {
		this.categoryId = (int) categoryId;
	}


	/**
	 * @return the supplierId
	 */
	public double getSupplierId() {
		return supplierId;
	}


	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(double supplierId) {
		this.supplierId = (int) supplierId;
	}


	/**
	 * @return the purchases
	 */
	public double getPurchases() {
		return purchases;
	}


	/**
	 * @param purchases the purchases to set
	 */
	public void setPurchases(double purchases) {
		this.purchases = purchases;
	}


	/**
	 * @return the views
	 */
	public double getViews() {
		return views;
	}


	/**
	 * @param views the views to set
	 */
	public void setViews(double views) {
		this.views = views;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}


		
}
