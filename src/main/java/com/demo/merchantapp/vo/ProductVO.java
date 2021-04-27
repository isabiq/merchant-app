package com.demo.merchantapp.vo;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.demo.merchantapp.vo.xmladapter.LocalDateTimeAdapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@XmlRootElement
@XmlType(name = "Product")
public class ProductVO {

	@XmlElement
	private int id;

	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	private LocalDateTime createDate;

	@XmlElement
	private String label;

	@XmlElement
	private double unitPrice;

	@XmlElement
	private String currency;

	@XmlElement
	private double weight;

	@XmlElement
	private double height;

}
