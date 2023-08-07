package com.sr.mycart.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	 //mappedBy -->specifies create only one column of category in product table
	@OneToMany(mappedBy = "category")    //This means we are creating one to many relation between this class i.e Category and Product Class hence viceversa relationship we need to use.
	private List<Product> product = new ArrayList<>();
	
	
	
	//this is a constructor created with list for product;
	public Category(int categoryId, String categoryTitle, String categoryDescription, List<Product> product) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.product = product;
	}
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	//constructors
	public Category(int categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	public Category(String categoryTitle, String categoryDescription) {
		super();
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	public Category() {
		super();
	}
	
	//getters and setters
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + "]";
	}
	
	
	
}
