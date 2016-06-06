package springbook.learningtest.template;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CalcSumTest {
	
	Calculator calculator;
	String numFilepath;
	
	@Before
	public void setUp() {
		this.calculator = new Calculator();
		this.numFilepath = "src/springbook/learningtest/template/numbers.txt";
	}
	
	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(this.numFilepath), is(10));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calMultiply(this.numFilepath), is(24));
	}
	
	@Test
	public void concatenateString() throws IOException {
		assertThat(calculator.concatenate(this.numFilepath), is("1234"));
	}
	
	
}
