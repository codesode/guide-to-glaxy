package com.codesode.guidetogalaxy.input.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.codesode.guidetogalaxy.core.MetalType;
import com.codesode.guidetogalaxy.input.TransactionData;

/**
 * Questions will be either a "how much" or "how many"
 * 
 * @author VijayShanker
 * 
 */
public class QuestionRule implements ParsingRule {

	@Override
	public boolean applicable(String inputLine) {
		return inputLine.startsWith("how") && inputLine.endsWith("?");
	}

	@Override
	public void apply(TransactionData transactionData, String line) {

		List<String> unitValues = new ArrayList<>();
		MetalType metalType = null;

		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();

			if (transactionData.isForeignLanguageSymbol(token)) {
				unitValues.add(token);
			} else if (MetalType.isValidMetal(token)) {
				metalType = MetalType.valueOf(token.toUpperCase());
			}
		}

		transactionData.addToQuestions(unitValues, metalType);

	}
}
