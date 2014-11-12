package com.codesode.guidetogalaxy;

import junit.framework.Assert;

import org.junit.Test;

import com.codesode.guidetogalaxy.core.ValueTranslator;

public class ValueTranslatorTest {

	@Test
	public void testTranslate() {
		// testing subtracting rule
		Assert.assertEquals(1, ValueTranslator.translate("I"));
		Assert.assertEquals(2, ValueTranslator.translate("II"));
		Assert.assertEquals(3, ValueTranslator.translate("III"));
		Assert.assertEquals(4, ValueTranslator.translate("IV"));
		Assert.assertEquals(5, ValueTranslator.translate("V"));
		Assert.assertEquals(6, ValueTranslator.translate("VI"));
		Assert.assertEquals(7, ValueTranslator.translate("VII"));
		Assert.assertEquals(8, ValueTranslator.translate("VIII"));
		Assert.assertEquals(9, ValueTranslator.translate("IX"));
		Assert.assertEquals(10, ValueTranslator.translate("X"));
		Assert.assertEquals(11, ValueTranslator.translate("XI"));
		Assert.assertEquals(12, ValueTranslator.translate("XII"));
		Assert.assertEquals(13, ValueTranslator.translate("XIII"));
		Assert.assertEquals(14, ValueTranslator.translate("XIV"));
		Assert.assertEquals(15, ValueTranslator.translate("XV"));
		Assert.assertEquals(16, ValueTranslator.translate("XVI"));
		Assert.assertEquals(17, ValueTranslator.translate("XVII"));
		Assert.assertEquals(18, ValueTranslator.translate("XVIII"));
		Assert.assertEquals(19, ValueTranslator.translate("XIX"));
		Assert.assertEquals(20, ValueTranslator.translate("XX"));
		Assert.assertEquals(30, ValueTranslator.translate("XXX"));
		Assert.assertEquals(40, ValueTranslator.translate("XL"));
		Assert.assertEquals(50, ValueTranslator.translate("L"));
		Assert.assertEquals(60, ValueTranslator.translate("LX"));
		Assert.assertEquals(70, ValueTranslator.translate("LXX"));
		Assert.assertEquals(80, ValueTranslator.translate("LXXX"));
		Assert.assertEquals(90, ValueTranslator.translate("XC"));
		Assert.assertEquals(100, ValueTranslator.translate("C"));

	}
}
