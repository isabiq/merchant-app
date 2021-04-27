package com.demo.merchantapp.vo.xmladapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	public LocalDate unmarshal(String date) throws Exception {
		return LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME);
	}

	public String marshal(LocalDate date) throws Exception {
		if (date != null) {
			return date.format(DateTimeFormatter.ISO_DATE_TIME);
		}
		return null;
	}
}