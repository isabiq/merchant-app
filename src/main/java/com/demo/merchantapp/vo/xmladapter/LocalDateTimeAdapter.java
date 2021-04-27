package com.demo.merchantapp.vo.xmladapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
	
	public LocalDateTime unmarshal(String date) throws Exception {
		return LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
	}

	public String marshal(LocalDateTime date) throws Exception {
		if (date != null) {
			return date.format(DateTimeFormatter.ISO_DATE_TIME);
		}
		return null;
	}
}