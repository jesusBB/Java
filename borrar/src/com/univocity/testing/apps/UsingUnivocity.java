package com.univocity.testing.apps;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class UsingUnivocity {
	public static void main(String[] args) throws UnsupportedEncodingException{
		CsvParserSettings settings = new CsvParserSettings();
		//the file used in the example uses '\n' as the line separator sequence.
		//the line separator sequence is defined here to ensure systems such as MacOS and Windows
		//are able to process this file correctly (MacOS uses '\r'; and Windows uses '\r\n').
		settings.getFormat().setLineSeparator("\n");
		
		// creates a CSV parser
		CsvParser parser = new CsvParser(settings);
		
		// parses all rows in one go.
		List<String[]> allRows = parser.parseAll(new ReaderHelper().getReader("/com/univocity/testing/resources/example.csv"));
		
		for(String[] s : allRows){
			System.out.println(Arrays.toString(s));
			
		}
	}
	
	
	
}
