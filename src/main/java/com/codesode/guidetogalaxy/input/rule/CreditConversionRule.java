/**
 * 
 */
package com.codesode.guidetogalaxy.input.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.codesode.guidetogalaxy.core.MetalType;
import com.codesode.guidetogalaxy.input.TransactionData;

/**
 * Credit conversion rule deals with the input line ending with "credit"
 * keyword; If it find any such line if parse and reserve the data.
 * 
 * @author VijayShanker
 * 
 */
public class CreditConversionRule implements ParsingRule {

	@Override
	public boolean applicable(String inputLine) {
		return inputLine.endsWith("Credits");
	}

	@Override
	public void apply(TransactionData transactionData, String line) {

		List<String> unitValues = new ArrayList<>();
		MetalType metalType = null;
		int credits = 0;

		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();

			if (transactionData.isForeignLanguageSymbol(token)) {
				unitValues.add(token);
			} else if (isDigits(token)) {
				credits = Integer.parseInt(token);
			} else if (MetalType.isValidMetal(token)) {
				metalType = MetalType.valueOf(token.toUpperCase());
			}
		}

		transactionData.addToCreditConversion(unitValues, credits, metalType);

	}

	private static boolean isDigits(final String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
