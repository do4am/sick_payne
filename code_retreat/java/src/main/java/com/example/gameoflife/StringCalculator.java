package com.example.gameoflife;

public class StringCalculator {
	public static int sumDelimitedInts(String inputString) {
		if (inputString.isEmpty()) {
			return 0;
		}

		int sum = 0;

		String[] inputSplit = inputString.split(",");

		for (String s : inputSplit) {
			try {
				sum += Integer.parseInt(s);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Integer could not be parsed. Is delimiter wrong?");
			}
		}
		return sum;
	}
}
