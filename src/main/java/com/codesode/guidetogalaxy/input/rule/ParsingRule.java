/**
 * 
 */
package com.codesode.guidetogalaxy.input.rule;

import com.codesode.guidetogalaxy.input.TransactionData;


/**
 * Defines rules for input value parsing.
 * 
 * @author Vijay Shanker
 * 
 */
public interface ParsingRule {

	/**
	 * Checks if a parsing rule can be applied on given input line
	 * 
	 * @param inputLine
	 * @return
	 */
	public boolean applicable(String inputLine);

	/**
	 * Apply rule.
	 * 
	 * @param transactionData
	 */
	public void apply(TransactionData transactionData, String line);
}
