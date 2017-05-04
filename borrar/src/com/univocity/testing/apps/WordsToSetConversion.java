package com.univocity.testing.apps;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.univocity.parsers.conversions.Conversion;

public class WordsToSetConversion implements Conversion<String, Set<String>> {

	private final String separator;
	private final boolean toUpperCase;
	
	public WordsToSetConversion(String... args){
		String separator = ",";
		boolean toUpperCase = true;
		
		if (args.length == 1) {
			separator = args[0];
		}
		
		if (args.length == 2) {
			toUpperCase = Boolean.valueOf(args[1]);
		}
		
		this.separator = separator;
		this.toUpperCase = toUpperCase;
	}
	public WordsToSetConversion(String separator, boolean toUpperCase) {
		this.separator = separator;
		this.toUpperCase = toUpperCase;
		}
	public Set<String> execute(String input) {

		if (input == null) {
			return Collections.emptySet();
		}
		
		if (toUpperCase) {
			input = input.toUpperCase();
		}
		
		Set<String> out = new TreeSet<String>();
		for (String token : input.split(separator)) {
			//extracting words separated by white space as well
			for (String word : token.trim().split("\\s")) {
				out.add(word.trim());
			}
		}
		
		return out;
	}

	public String revert(Set<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
