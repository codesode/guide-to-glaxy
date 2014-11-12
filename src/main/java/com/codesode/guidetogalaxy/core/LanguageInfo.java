/**
 * 
 */
package com.codesode.guidetogalaxy.core;

/**
 * Maps foreign language with {@link RomanSymbol}.
 * 
 * @author Vijay Shanker
 * 
 */
public class LanguageInfo {

	private String foreignLanguageSymbol;
	
	private RomanSymbol romanSymbol;

	public LanguageInfo(RomanSymbol romanSymbol, String foreignLanguageSymbol) {
		this.romanSymbol = romanSymbol;
		this.foreignLanguageSymbol = foreignLanguageSymbol;
	}


	public String getForeignLanguageSymbol() {
		return foreignLanguageSymbol;
	}

	public RomanSymbol getRomanSymbol() {
		return romanSymbol;
	}
}
