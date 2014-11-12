package com.codesode.guidetogalaxy;

import junit.framework.Assert;

import org.junit.Test;

import com.codesode.guidetogalaxy.core.TranslationHelper;

public class TranslationHelperTest {

	@Test
	public void testhasRestrictedSubstraction() {
		TranslationHelper helper = new TranslationHelper();

		boolean status = helper.hasRestrictedSubstraction("III");
		Assert.assertFalse(status);

		status = helper.hasRestrictedSubstraction("ID");
		Assert.assertTrue(status);

		status = helper.hasRestrictedSubstraction("IC");
		Assert.assertTrue(status);

		status = helper.hasRestrictedSubstraction("XXXIV");
		Assert.assertFalse(status);

		status = helper.hasRestrictedSubstraction("XL");
		Assert.assertFalse(status);

		status = helper.hasRestrictedSubstraction("CL");
		Assert.assertFalse(status);

	}

}
