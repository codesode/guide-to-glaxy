package com.codesode.guidetogalaxy.input;

import java.util.ArrayList;
import java.util.List;

import com.codesode.guidetogalaxy.input.rule.CreditConversionRule;
import com.codesode.guidetogalaxy.input.rule.LanguageMappingRule;
import com.codesode.guidetogalaxy.input.rule.ParsingRule;
import com.codesode.guidetogalaxy.input.rule.QuestionRule;

/**
 * Data parser for input line. This input line is of multiple types as defined
 * below
 * <ol>
 * <li>Mapping Line : This line type contains 3 string values where middle value
 * is "is" and the last value is valid RomanSymbol</li>
 * </ol>
 */
public class InputDataParser {

	/**
	 * Parsing rules.
	 */
	private final List<ParsingRule> rules = new ArrayList<ParsingRule>(0);

	/** */
	private final TransactionData transactionData;

	public InputDataParser(TransactionData transactionData) {
		this.transactionData = transactionData;

		// register rules.
		rules.add(new LanguageMappingRule());
		rules.add(new CreditConversionRule());
		rules.add(new QuestionRule());
	}

	public void parseLine(String line) {

		for (ParsingRule rule : this.rules) {
			if (rule.applicable(line)) {
				rule.apply(transactionData, line);
				// ensure only one rule; break the loop
				break;
			}
		}
	}
}
