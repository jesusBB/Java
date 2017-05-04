package com.univocity.testing.apps;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class ReaderHelper {
	public  Reader getReader(String relativePath) throws UnsupportedEncodingException {
		return new InputStreamReader(this.getClass().getResourceAsStream(relativePath), "UTF-8");
	}
}
