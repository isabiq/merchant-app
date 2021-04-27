package com.demo.merchantapp.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "merchant_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MerchantProduct implements Serializable {

	@Id
	@ManyToOne
	private Merchant merchant;

	@Id
	@ManyToOne
	private Product product;

	@Column(name = "create_date")
	private LocalDateTime createDate;

}
