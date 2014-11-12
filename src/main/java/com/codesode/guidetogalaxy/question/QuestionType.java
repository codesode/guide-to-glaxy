/**
 * 
 */
package com.codesode.guidetogalaxy.question;

/**
 * Defined question type in the input.
 * 
 * @author Vijay Shanker
 * 
 */
public enum QuestionType {

	HOW_MANY("how many"),

	HOW_MUCH("how mcuh");

	private String identifier;

	private QuestionType(String label) {
		this.identifier = label;
		//
	}

	public String getIdentifier() {
		return identifier;
	}

	public static QuestionType identify(String input) {

		QuestionType questionType = null;

		if (input.startsWith(HOW_MUCH.identifier)) {
			questionType = QuestionType.HOW_MUCH;
		} else if (input.startsWith(HOW_MANY.identifier)) {
			questionType = QuestionType.HOW_MANY;
		}

		return questionType;
	}
}
