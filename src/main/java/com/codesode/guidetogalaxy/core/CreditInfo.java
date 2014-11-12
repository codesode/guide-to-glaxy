/**
 * 
 */
package com.codesode.guidetogalaxy.core;

/**
 * Define credit conversion data.
 * 
 * @author VijayShanker
 * 
 */
public class CreditInfo {

	private int credits;

	private int units;

	public CreditInfo(int units, int credits) {
		this.units = units;
		this.credits = credits;
	}

	public int getCredits() {
		return credits;
	}

	public int getUnits() {
		return units;
	}

	public double getUnitPrice() {
		return (double) credits / (double) units;
	}
}
