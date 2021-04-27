package com.demo.merchantapp.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.demo.merchantapp.vo.xmladapter.LocalDateAdapter;
import com.demo.merchantapp.vo.xmladapter.LocalDateTimeAdapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@XmlRootElement
@XmlType(name = "Merchant")
@ToString
public class MerchantVO {

	@XmlElement
	private int id;

	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	private LocalDateTime createDate;

	@XmlElement
	private String name;

	@XmlElement
	private String lastName;

	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate birthDate;

}
