package com.RestApiForCalculator.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxMinRequest {
	@JsonProperty("numbers")
	private int[] numbers;

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public MaxMinRequest(int[] numbers) {
		super();
		this.numbers = numbers;
	}

	public MaxMinRequest() {
		super();
		
	}

	@Override
	public String toString() {
		return "MaxMinRequest [numbers=" + Arrays.toString(numbers) + "]";
	}

}
