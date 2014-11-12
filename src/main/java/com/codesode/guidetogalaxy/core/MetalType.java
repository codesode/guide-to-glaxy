/**
 * 
 */
package com.codesode.guidetogalaxy.core;

/**
 * Defined metal type for the transaction.
 * 
 * @author Vijay Shanker
 * 
 */
public enum MetalType {

	GOLD("Gold"),

	IRON("Iron"),

	SILVER("Silver");

	private String label;

	private MetalType(String label) {
		this.label = label;
		//
	}

	public String getLabel() {
		return label;
	}

	public static boolean isValidMetal(String metalConstant) {

		MetalType type = null;

		try {
			type = valueOf(metalConstant.toUpperCase());
		} catch (IllegalArgumentException e) {
			// Silently consumed;
		}

		return type != null;
	}
}
