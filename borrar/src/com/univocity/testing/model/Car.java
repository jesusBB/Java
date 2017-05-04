package com.univocity.testing.model;

import java.util.Set;

import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.testing.apps.WordsToSetConversion;

public class Car {
	@Parsed
	private Integer year;
	
	@Convert(conversionClass = WordsToSetConversion.class, args = { ",", "true" })
	@Parsed
	private Set<String> description;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Set<String> getDescription() {
		return description;
	}

	public void setDescription(Set<String> description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.year + " - " + this.description  + "\n"; 
	}
	
	
	
}
