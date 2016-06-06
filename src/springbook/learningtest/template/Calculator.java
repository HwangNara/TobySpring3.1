package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

	public Integer calcSum(String filepath) throws IOException {
		LineCallback<Integer> sumCallback = (line, value) -> value + Integer.valueOf(line);
		return lineReadTemplate(filepath, sumCallback, 0);
	}
	
	public Integer calMultiply(String filepath) throws IOException {
		LineCallback<Integer> multiplyCallback = (line, value) -> value * Integer.valueOf(line);
		return lineReadTemplate(filepath, multiplyCallback, 1);
	}
	
	public String concatenate(String filepath) throws IOException {
		LineCallback<String> concatenateCallback = (line, value) -> value + line;
		return lineReadTemplate(filepath, concatenateCallback, "");
	}
	
	public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filepath));
			int ret = callback.doSomethingWithReader(br);
			return ret;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T intVal) throws IOException {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filepath));
			T res = intVal;
			String line = null;
			while ((line = br.readLine()) != null) {
				res = callback.doSomethingWithLine(line, res);
			}
			return res;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
