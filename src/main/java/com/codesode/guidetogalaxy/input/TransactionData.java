/**
 * 
 */
package com.codesode.guidetogalaxy.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.codesode.guidetogalaxy.core.CreditInfo;
import com.codesode.guidetogalaxy.core.LanguageInfo;
import com.codesode.guidetogalaxy.core.MetalType;
import com.codesode.guidetogalaxy.core.RomanSymbol;
import com.codesode.guidetogalaxy.core.ValueTranslator;
import com.codesode.guidetogalaxy.question.HowManyQuestion;
import com.codesode.guidetogalaxy.question.HowMuchQuestion;
import com.codesode.guidetogalaxy.question.InputQuestion;

/**
 * Represents an execution context for the foreign trip
 * 
 * @author Vijay Shanker
 * 
 */
public class TransactionData {

	/**
	 * List of mappings for value in foreign language with Roman Symbols.
	 */
	private final List<LanguageInfo> languageMaps = new ArrayList<LanguageInfo>(0);

	/**
	 * mappings for metal type and its conversion rule.
	 */
	private final Map<MetalType, CreditInfo> conversions = new HashMap<MetalType, CreditInfo>();

	/**
	 * List of questions.
	 */
	private final List<InputQuestion> questions = new ArrayList<InputQuestion>();

	public List<LanguageInfo> getLanguageMaps() {
		return Collections.unmodifiableList(this.languageMaps);
	}

	public List<InputQuestion> getQuestions() {
		return Collections.unmodifiableList(this.questions);
	}

	public boolean isForeignLanguageSymbol(String token) {

		boolean status = false;

		for (LanguageInfo languageMap : this.languageMaps) {
			if (languageMap.getForeignLanguageSymbol().equals(token)) {
				status = true;
				break;
			}
		}

		return status;

	}

	public String getRomanSymbool(String foreignUnit) {

		RomanSymbol romanSymbol = null;

		for (LanguageInfo languageMap : this.languageMaps) {
			if (languageMap.getForeignLanguageSymbol().equals(foreignUnit)) {
				romanSymbol = languageMap.getRomanSymbol();
				break;
			}
		}

		return romanSymbol.name();
	}

	public void addToCreditConversion(List<String> unitValues, int credits,
			MetalType metalType) {

		String romanValue = translateToRoman(unitValues);

		int units = ValueTranslator.translate(romanValue);
		CreditInfo creditConversion = new CreditInfo(units, credits);
		this.conversions.put(metalType, creditConversion);
	}

	public void addToQuestions(List<String> unitValues, MetalType metalType) {

		InputQuestion question = null;

		String foreignValue = joinValues(unitValues);

		String romanValue = translateToRoman(unitValues);

		if (metalType != null) {
			question = new HowManyQuestion(romanValue, foreignValue, metalType,
					conversions);
		} else {
			question = new HowMuchQuestion(romanValue, foreignValue);
		}
		this.questions.add(question);
	}

	public void addToLanguageMaps(String romanSymbol,
			String foreignLanguageSymbol) {
		LanguageInfo language = new LanguageInfo(
				RomanSymbol.valueOf(romanSymbol), foreignLanguageSymbol);
		languageMaps.add(language);

	}

	private String translateToRoman(List<String> unitValues) {
		// First translate unit values to Roman Symbols
		String romanValue = "";
		for (String foreignUnit : unitValues) {
			String romanSymbol = this.getRomanSymbool(foreignUnit);

			romanValue = romanValue + romanSymbol;
		}

		return romanValue;
	}

	private String joinValues(List<String> unitValues) {

		StringBuilder foreignValue = new StringBuilder(unitValues.size());

		Iterator<String> iterator = unitValues.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			foreignValue.append(value);

			if (iterator.hasNext()) {
				foreignValue.append(" ");
			}
		}

		return foreignValue.toString();
	}

}
