package com.demo.merchantapp.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.merchantapp.vo.ProductVO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
public class Product implements Serializable {

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, Set<MerchantProduct> merchantProducts) {
		super();
		this.id = id;
		this.merchantProducts = merchantProducts;
	}

	public Product(int id, LocalDateTime createDate, String label, double unitPrice, String currency, double weight,
			double height) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.label = label;
		this.unitPrice = unitPrice;
		this.currency = currency;
		this.weight = weight;
		this.height = height;
	}

	public static Product createProduct(ProductVO productVO) {
		return new Product(productVO.getId(), productVO.getCreateDate(), productVO.getLabel(), productVO.getUnitPrice(),
				productVO.getCurrency(), productVO.getWeight(), productVO.getHeight());
	}

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "label")
	private String label;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "currency")
	private String currency;

	@Column(name = "weight")
	private double weight;

	@Column(name = "height")
	private double height;

	@OneToMany(mappedBy = "product")
	private Set<MerchantProduct> merchantProducts = new HashSet<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", createDate=" + createDate + ", label=" + label + ", unitPrice=" + unitPrice
				+ ", currency=" + currency + ", weight=" + weight + ", height=" + height + "]";
	}

}
