package com.codesode.guidetogalaxy.core;

/**
 * Represents roman symbols for respective numeric integer
 * 
 * @author Vijay Shanker
 */
public enum RomanSymbol {

	/**
	 * Symbol represents numeric value 1.
	 */
	I(1),

	/**
	 * Symbol represents numeric value 5.
	 */
	V(5),

	/**
	 * Symbol represents numeric value 10.
	 */
	X(10),

	/**
	 * Symbol represents numeric value 50.
	 */
	L(50),

	/**
	 * Symbol represents numeric value 100.
	 */
	C(100),

	/**
	 * Symbol represents numeric value 500.
	 */
	D(500),

	/**
	 * Symbol represents numeric value 1000.
	 */
	M(1000);

	private int integerValue;

	/**
	 * Default constructor.
	 */
	private RomanSymbol(int integerValue) {
		this.integerValue = integerValue;
	}
	
	public int integerValue() {
		return integerValue;
	}

	public static boolean isValidSymbol(String symbolConstant) {

		RomanSymbol symbol = null;

		try {
			symbol = valueOf(symbolConstant);
		} catch (IllegalArgumentException e) {
			// Silently consumed; method is not supposed to deal with
		}

		return symbol != null;
	}
}