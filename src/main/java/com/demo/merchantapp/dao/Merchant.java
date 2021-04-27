package com.demo.merchantapp.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.merchantapp.vo.MerchantVO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "merchant")
@NoArgsConstructor
@Getter
public class Merchant implements Serializable {

	public Merchant(int id) {
		this.id = id;
	}

	public Merchant(int id, List<MerchantProduct> merchantProducts) {
		this.id = id;
		this.merchantProducts = merchantProducts;
	}

	public Merchant(int id, LocalDateTime createDate, String name, String lastName, LocalDate birthDate) {
		this.id = id;
		this.createDate = createDate;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public static Merchant createMerchant(MerchantVO merchantVO) {
		return new Merchant(merchantVO.getId(), merchantVO.getCreateDate(), merchantVO.getName(),
				merchantVO.getLastName(), merchantVO.getBirthDate());
	}

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "birthdate")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "merchant")
	private List<MerchantProduct> merchantProducts = new ArrayList<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Merchant other = (Merchant) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", createDate=" + createDate + ", name=" + name + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + "]";
	}

}
