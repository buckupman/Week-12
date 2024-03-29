package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	// Simple method to multiply 2 numbers
	public int multiply(int a, int b) {
		return a * b;
	}

	int getRandomInt() {

		Random random = new Random();

		return random.nextInt(10) + 1;

	}

	public int randomNumberSquared() {

		int randomNumber = getRandomInt();

		return randomNumber * randomNumber;

	}

}
