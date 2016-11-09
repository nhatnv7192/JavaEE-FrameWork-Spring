package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoryId")
	private int categoryId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name="categoryId")
//	private List<Product> listProduct;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public List<Product> getListProduct() {
//		return listProduct;
//	}
//
//	public void setListProduct(List<Product> listProduct) {
//		this.listProduct = listProduct;
//	}
	
	
}
