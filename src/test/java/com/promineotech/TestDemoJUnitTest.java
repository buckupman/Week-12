package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if (!expectException) {

			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() ->

			testDemo.addPositive(a, b))

					.isInstanceOf(IllegalArgumentException.class);

		}
	}

	public static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 3, 5, false), arguments(-2, 3, 1, true), arguments(0, 3, 3, true));

	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 1)).isEqualTo(41);
	}

	// Creating my own method to test

	@Test
	void testMultiply() {

		// Created the instance of TestDemo
		TestDemo testDemo = new TestDemo();

		// Defined two integers
		int a = 4;
		int b = 5;

		// Called the multiply method with a and b
		int result = testDemo.multiply(a, b);

		// Asserted that the result is equal to the expected value (4 * 5)
		assertThat(result).isEqualTo(20);
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {

		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);
	}

}
