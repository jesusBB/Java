package com.univocity.testing.apps;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.MasterDetailListProcessor;
import com.univocity.parsers.common.processor.MasterDetailRecord;
import com.univocity.parsers.common.processor.ObjectRowListProcessor;
import com.univocity.parsers.common.processor.RowPlacement;
import com.univocity.parsers.conversions.Conversions;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class UsingMasterRowRecord {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// 1st, Create a RowProcessor to process all "detail" elements
		ObjectRowListProcessor detailProcessor = new ObjectRowListProcessor();
		
		// converts values at in the "Amount" column (position 1 in the file) to integer.
		detailProcessor.convertIndexes(Conversions.toInteger()).set(1);
		
		// 2nd, Create MasterDetailProcessor to identify whether or not a row is the master row.
		// the row placement argument indicates whether the master detail row occurs before or after a sequence of "detail" rows.
		MasterDetailListProcessor masterRowProcessor = new MasterDetailListProcessor(RowPlacement.BOTTOM, detailProcessor) {
			@Override
			protected boolean isMasterRecord(String[] row, ParsingContext context) {
				//Returns true if the parsed row is the master row.
				//In this example, rows that have "Total" in the first column are master rows.
				return "Total".equals(row[0]);
			}
		};
		// We want our master rows to store BigIntegers in the "Amount" column
		masterRowProcessor.convertIndexes(Conversions.toBigInteger()).set(1);
		
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setHeaderExtractionEnabled(true);
		
		// Set the RowProcessor to the masterRowProcessor.
		parserSettings.setRowProcessor(masterRowProcessor);
		
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new ReaderHelper().getReader("/com/univocity/testing/resources/master_detail.csv"));
		
		// Here we get the MasterDetailRecord elements.
		List<MasterDetailRecord> rows = masterRowProcessor.getRecords();
		MasterDetailRecord masterRecord = rows.get(0);
		
		// The master record has one master row and multiple detail rows.
		Object[] masterRow = masterRecord.getMasterRow();
		List<Object[]> detailRows = masterRecord.getDetailRows();
		
		for(Object o : masterRow){
			System.out.println(o);
		}
		for(Object[] o : detailRows){
			System.out.println("-------");
			for(Object objs : o){
				System.out.println(objs);
			}
		}
		
		/*
		 To show all the records straightway 
		 */
		
		for(int i = 0; i < rows.size();i++){
			masterRow = rows.get(i).getMasterRow();
			detailRows = rows.get(i).getDetailRows();
			System.out.println("=============");
			for(Object[] o : detailRows){
				for(Object objs : o){
					System.out.println(objs);
				}
				System.out.println("-------");
			}
			for(Object o : masterRow){
				System.out.println(o);
			}
		}
	}

}
