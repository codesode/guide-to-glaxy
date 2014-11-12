/**
 * 
 */
package com.codesode.guidetogalaxy.input.rule;

import com.codesode.guidetogalaxy.core.RomanSymbol;
import com.codesode.guidetogalaxy.input.TransactionData;

/**
 * @author VijayShanker
 * 
 */
public class LanguageMappingRule implements ParsingRule {

	@Override
	public boolean applicable(String inputLine) {
		String[] words = inputLine.split(" ");

		boolean applicability = false;

		// pass 1 : length of words should be 3
		if (words.length == 3) {
			// pass 2 : the last word should be a valid Roman symbol
			if (RomanSymbol.isValidSymbol(words[2])) {
				applicability = true;
			}
		}

		return applicability;
	}

	@Override
	public void apply(TransactionData transactionData, String line) {

		String[] words = line.split(" ");

		transactionData.addToLanguageMaps(words[2], words[0]);

	}
}
