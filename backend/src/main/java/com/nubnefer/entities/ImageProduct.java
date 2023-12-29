package com.nubnefer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="image_product")
public class ImageProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="img_id")
	private Long id;
	
	private String url;
//	@ManyToOne
	@JoinColumn(name = "product_id")
	private Long productId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	public Long getProductId() {
		return productId;
	}
	
	
	

}
