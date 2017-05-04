package com.univocity.testing.apps;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.testing.model.TestBean;

public class UsingBeanListProcessor {
	public static void main(String[] args) throws UnsupportedEncodingException{
		// BeanListProcessor converts each parsed row to an instance of a given class, then stores each instance into a list.
		BeanListProcessor<TestBean> rowProcessor = new BeanListProcessor<TestBean>(TestBean.class);
		
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setRowProcessor(rowProcessor);
		parserSettings.setHeaderExtractionEnabled(true);
		
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new ReaderHelper().getReader("/com/univocity/testing/resources/bean_test.csv"));
		
		// The BeanListProcessor provides a list of objects extracted from the input.
		List<TestBean> beans = rowProcessor.getBeans();
		
		System.out.println(beans.toString());
	}
}
