/**
 * 
 */
package com.codesode.guidetogalaxy;

import java.util.ArrayList;
import java.util.List;

import com.codesode.guidetogalaxy.input.InputDataParser;
import com.codesode.guidetogalaxy.input.TransactionData;
import com.codesode.guidetogalaxy.question.InputQuestion;

/**
 * Launcher program
 * 
 * @author Vijay Shanker
 * 
 */
public class GalaxyTransactor {

	public List<String> execute(final List<String> inputLines) {

		final TransactionData transactionData = new TransactionData();

		// process input data
		final InputDataParser inputDataParser = new InputDataParser(
				transactionData);
		for (String line : inputLines) {
			inputDataParser.parseLine(line);
		}

		// Prepare output
		List<String> outputs = new ArrayList<String>();
		List<InputQuestion> questions = transactionData.getQuestions();
		for (InputQuestion inputQuestion : questions) {
			String answer = inputQuestion.answer();

			outputs.add(answer);
		}
		return outputs;
	}
}
