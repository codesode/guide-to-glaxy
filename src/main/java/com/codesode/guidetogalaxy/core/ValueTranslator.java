/**
 * 
 */
package com.codesode.guidetogalaxy.core;

/**
 * Translator for Roman symbol string to integer value
 * 
 * @author Vijay Shanker
 * 
 */
public final class ValueTranslator {

	private final TranslationHelper translationHelper = new TranslationHelper();

	private static ValueTranslator translator = new ValueTranslator();

	public static int translate(String romanString) {
		return translator.translateString(romanString);
	}

	private ValueTranslator() {
	}

	/**
	 * Translate Roman String to equivalent integer value
	 * 
	 * @param romanString
	 *            Roman string
	 * @return integer value
	 */
	private int translateString(String romanString) {
		int value = 0;

		// validate for the repetition of symbols
		if (!translationHelper.hasRepeatedSymbols(romanString)
				&& !translationHelper.hasRestrictedSubstraction(romanString)) {

			value = doTranslate(romanString);
		}

		return value;
	}

	private int doTranslate(String romanString) {
		int value = 0;

		char[] symbols = romanString.toCharArray();

		for (int i = 0; i < symbols.length; i++) {

			RomanSymbol thisSymbol = RomanSymbol.valueOf(Character
					.toString(symbols[i]));

			int valueToAdd = thisSymbol.integerValue();

			// check whether this is for subtraction
			if (i + 1 < symbols.length) {
				RomanSymbol nextSymbol = RomanSymbol.valueOf(Character
						.toString(symbols[i + 1]));

				if (thisSymbol.integerValue() < nextSymbol.integerValue()) {
					valueToAdd = -valueToAdd;
				}

			}

			value = value + valueToAdd;

		}

		return value;
	}

}
