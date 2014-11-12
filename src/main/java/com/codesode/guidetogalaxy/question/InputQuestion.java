/**
 * 
 */
package com.codesode.guidetogalaxy.question;

/**
 * Defines an input question.
 * 
 * @author VijayShanker
 * 
 */
public abstract class InputQuestion {

	protected final String romanValue;

	protected final String foreignValue;

	public InputQuestion(String romanValue, String foreignValue) {
		this.romanValue = romanValue;
		this.foreignValue = foreignValue;
	}

	public String getForeignValue() {
		return foreignValue;
	}

	public abstract String prepareAnswer();

	public String answer() {
		String errorAnswer = null;

		if (romanValue == null || romanValue.isEmpty()) {
			errorAnswer = "I have no idea what you are talking about";
		} else {
			errorAnswer = prepareAnswer();
		}

		return errorAnswer;
	}
}
