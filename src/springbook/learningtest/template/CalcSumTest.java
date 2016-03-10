package springbook.learningtest.template;

import java.io.IOException;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CalcSumTest {

	@Test
	public void sumOfNumbers() throws IOException {
		Calculator calculator = new Calculator();
		
		
		int sum = calculator.calcSum("D:/[workspace]/STS/SpringBook/bin/numbers.txt");
		assertThat(sum, is(10));
	}
}
