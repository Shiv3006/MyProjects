
package com.RestApiForCalculator.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.RestApiForCalculator.model.RequestResponseTimestampEntity;
import com.RestApiForCalculator.model.Response;
import com.RestApiForCalculator.repository.CalciRepo;
import com.RestApiForCalculator.service.CalciServiceImpl;

@SpringBootTest
public class TestCalciService {

	@Autowired
	private CalciServiceImpl calciService;

	@MockBean
	private CalciRepo calciRepo;

	@Test
	void shouldReturnSumOfTwoNumbers() {
		assertEquals(7, calciService.add(3, 4));
	}

	@Test
	void shouldReturnDifferenceOfTwoNumbers() {
		assertEquals(5, calciService.substract(8, 3));
	}

	@Test
	void shouldReturnProductOfTwoNumbers() {
		assertEquals(30, calciService.multiply(5, 6));
	}

	@Test
	void shouldReturnQuotientOfTwoNumbers() {
		assertEquals(5.0, calciService.divison(10.0, 2.0), 0.0001);
	}

	@Test
	void shouldThrowExceptionOnDivisionByZero() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> calciService.divison(10.0, 0.0));
		assertEquals("Division of zero is not allowed", exception.getMessage());
	}

	@Test
	void shouldReturnSquareOfNumber() {
		assertEquals(16, calciService.square(4));
	}

	@Test
	void shouldReturnSquareRootOfNumber() {
		assertEquals(3, calciService.squareRoot(9));
	}

	@Test
	void shouldThrowExceptionForSquareRootOfNegativeNumber() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> calciService.squareRoot(-4));
		assertEquals("Square root of a negative number is not allowed.", exception.getMessage());
	}

	@Test
	void shouldReturnFactorialOfNumber() {
		assertEquals(120, calciService.factorial(5));
	}

	/*
	 * @Test void shouldThrowExceptionForFactorialOfNegativeNumber() {
	 * IllegalArgumentException exception =
	 * assertThrows(IllegalArgumentException.class, () ->
	 * calciService.factorial(-5)); assertTrue(exception.getMessage().
	 * matches("Factorial of a negative number is not allowed\\s*")); }
	 */
	@Test
	void shouldReturnMaxMinValuesFromArray() {
		int[] numbers = { 4, 8, 2, 10, 5 };
		Response result = calciService.maxMin(numbers);
		assertEquals(10, result.getMax());
		assertEquals(2, result.getMin());
	}

	@Test
	void shouldThrowExceptionForMaxMinWithEmptyArray() {
		int[] numbers = {};
		assertThrows(IllegalArgumentException.class, () -> calciService.maxMin(numbers));
	}

	@Test
	void shouldSaveLog() {
		calciService.saveLog("testRequest", "testResponse");
		verify(calciRepo, times(1)).save(any(RequestResponseTimestampEntity.class));
	}
}
