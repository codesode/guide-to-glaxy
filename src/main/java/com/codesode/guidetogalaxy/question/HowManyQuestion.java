/**
 * 
 */
package com.codesode.guidetogalaxy.question;

import java.text.MessageFormat;
import java.util.Map;

import com.codesode.guidetogalaxy.core.CreditInfo;
import com.codesode.guidetogalaxy.core.MetalType;
import com.codesode.guidetogalaxy.core.ValueTranslator;

/**
 * Represents how many questions.
 * 
 * @author VijayShanker
 * 
 */
public class HowManyQuestion extends InputQuestion {

	/** metal type for the question. */
	private final MetalType metalType;

	/** credit conversion data. */
	private final Map<MetalType, CreditInfo> conversions;

	public HowManyQuestion(String romanValue, String foreignValue,
			MetalType metalType, Map<MetalType, CreditInfo> conversions) {
		super(romanValue, foreignValue);
		this.metalType = metalType;
		this.conversions = conversions;
	}

	@Override
	public String prepareAnswer() {
		String answerTemplate = "{0} {1} is {2} Credits";

		int requestUnit = ValueTranslator.translate(romanValue);

		// get conversion rule
		CreditInfo conversion = conversions.get(metalType);
		int creditValue = (int) (conversion.getUnitPrice() * requestUnit);

		return MessageFormat.format(answerTemplate, getForeignValue(),
				metalType.getLabel(), String.valueOf(creditValue));
	}
}
