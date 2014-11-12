/**
 * 
 */
package com.codesode.guidetogalaxy.question;

import java.text.MessageFormat;

import com.codesode.guidetogalaxy.core.ValueTranslator;

/**
 * @author VijayShanker
 * 
 */
public class HowMuchQuestion extends InputQuestion {

	public HowMuchQuestion(String romanValue, String foreignValue) {
		super(romanValue, foreignValue);
	}

	@Override
	public String prepareAnswer() {
		String answerTemplate = "{0} is {1}";
		int integerValue = ValueTranslator.translate(romanValue);
		return MessageFormat.format(answerTemplate, getForeignValue(),
				integerValue);
	}

}
