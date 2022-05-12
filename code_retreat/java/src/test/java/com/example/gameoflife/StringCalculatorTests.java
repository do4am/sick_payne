package com.example.gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTests {

	@ParameterizedTest
	//Arrange
	@CsvSource({
					"0,''",
					"1,'1'",
					"3,'1,2'",
					"6,'1,2,3'"
	})
	public void testValidSumDelimitedInts(int expected, String inputString) {
		//Act
		int sum = StringCalculator.sumDelimitedInts(inputString);

		//Assert
		Assertions.assertEquals(expected, sum);
	}

	@ParameterizedTest
	//Arrange
	@ValueSource(strings = {"a,b", ";", "!!!,"})
	public void testInvalidCharacters(String inputString) {
		//Act
		Throwable exception = Assertions.assertThrows(
						NumberFormatException.class,
						() -> StringCalculator.sumDelimitedInts(inputString)
		);

		//Assert
		Assertions.assertTrue(exception.getMessage().contains("Integer could not be parsed. Is delimiter wrong?"));
	}
}
