package com.univocity.testing.apps;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.testing.model.Car;

public class UsingMyOwnConversions {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		BeanListProcessor<Car> rowProcessor = new BeanListProcessor<Car>(Car.class);
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setRowProcessor(rowProcessor);
		
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new ReaderHelper().getReader("/com/univocity/testing/resources/example.csv"));
		
		//Let's get our cars
		List<Car> cars = rowProcessor.getBeans();
		for (Car car : cars) {
			// Let's get only those cars that actually have some description
			if (!car.getDescription().isEmpty()) {
//				println(out, car.getDescription() + " - " + car.toString());
				System.out.println(car.getDescription() + " - " + car.toString());
			}
		}
	}

}
