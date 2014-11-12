/**
 * 
 */
package com.codesode.guidetogalaxy.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;


/**
 * Helper class for Roman translation.
 * 
 * @author VijayShanker
 * 
 */
public class TranslationHelper {

	private RomanSymbol[] notSubtractables;

	private Map<RomanSymbol, List<RomanSymbol>> conditionalSubtractables = new HashMap<>();

	private Pattern repeatedSymbols = Pattern
			.compile("[I]{4,}|[X]{4,}|[C]{4,}|[M]{4,}|[D]{2,}|[L]{2,}|[V]{2,}");

	public TranslationHelper() {

		// Rule 1 : V, L , D can never be subtracted.
		notSubtractables = new RomanSymbol[] { RomanSymbol.V, RomanSymbol.L,
				RomanSymbol.D };

		// Rule 2 : X can only be subtracted from L or C
		conditionalSubtractables.put(RomanSymbol.X, Arrays
				.asList(new RomanSymbol[] { RomanSymbol.L, RomanSymbol.C }));

		// I can only be subtracted from V or X.
		conditionalSubtractables.put(RomanSymbol.I, Arrays
				.asList(new RomanSymbol[] { RomanSymbol.V, RomanSymbol.X }));

		// C can only be subtracted from D or M.
		conditionalSubtractables.put(RomanSymbol.C, Arrays
				.asList(new RomanSymbol[] { RomanSymbol.M, RomanSymbol.D }));

	}

	public boolean hasRestrictedSubstraction(String romanString) {

		boolean invalid = false;

		// rule 1:
		for (RomanSymbol symbol : notSubtractables) {
			int index = romanString.indexOf(symbol.name());
			if (index > -1 && index + 1 < romanString.length()) {

				char nextChar = romanString.charAt(index + 1);

				RomanSymbol nextSymbol = RomanSymbol.valueOf(Character
						.toString(nextChar));
				if (nextSymbol.integerValue() > symbol.integerValue()) {
					// this is a subtraction case; not allowed
					invalid = true;
					break;
				}
			}
		}

		// rule 2:
		if (!invalid) {
			for (Entry<RomanSymbol, List<RomanSymbol>> entry : conditionalSubtractables
					.entrySet()) {
				int index = romanString.indexOf(entry.getKey().name());
				if (index > -1 && index + 1 < romanString.length()) {

					char nextChar = romanString.charAt(index + 1);

					RomanSymbol nextSymbol = RomanSymbol.valueOf(Character
							.toString(nextChar));
					List<RomanSymbol> subtractables = entry.getValue();

					if (entry.getKey().integerValue() < nextSymbol
							.integerValue()
							&& nextSymbol != entry.getKey()
							&& !subtractables.contains(nextSymbol)) {
						invalid = true;
					}
				}
			}
		}

		// rule 3 : only one subtraction allowed
		if (!invalid) {

			char[] chars = romanString.toCharArray();
			for (int i = chars.length - 1; i > 0; i--) {
				RomanSymbol thisSymbol = RomanSymbol.valueOf(chars[i] + "");
				RomanSymbol prevSymbol = RomanSymbol.valueOf(chars[i - 1] + "");

				if (thisSymbol.integerValue() > prevSymbol.integerValue()
						&& i - 2 >= 0) {
					RomanSymbol prevToPrevSymbol = RomanSymbol
							.valueOf(chars[i - 2] + "");
					if (thisSymbol.integerValue() > prevToPrevSymbol
							.integerValue()) {
						invalid = true;
					}
				}
			}
		}

		return invalid;
	}

	public boolean hasRepeatedSymbols(String romanString) {
		return repeatedSymbols.matcher(romanString).find();
	}
}
