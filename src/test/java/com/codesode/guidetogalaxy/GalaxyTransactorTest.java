package com.codesode.guidetogalaxy;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.codesode.guidetogalaxy.GalaxyTransactor;

public class GalaxyTransactorTest {

	@Test
	public void testExecute() {
		GalaxyTransactor transactor = new GalaxyTransactor();

		String[] lines = new String[] { "glob is I", "prok is V", "pish is X",
				"tegj is L", "glob glob Silver is 34 Credits",
				"glob prok Gold is 57800 Credits",
				"pish pish Iron is 3910 Credits",
				"how much is pish tegj glob glob ?",
				"how many Credits is glob prok Silver ?",
				"how many Credits is glob prok Gold ?",
				"how many Credits is glob prok Iron ?",
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?" };

		List<String> outputs = transactor.execute(Arrays.asList(lines));
		for (String line : outputs) {
			System.out.println(line);
		}
	}

	@Test
	public void testExecuteNewValues() {
		GalaxyTransactor transactor = new GalaxyTransactor();

		String[] lines = new String[] { "glob is I", "prok is V", "pish is C",
				"tegj is L", "tish is M", "glob glob Silver is 4 Credits",
				"glob prok Gold is 57800 Credits",
				"pish pish Iron is 3910 Credits",
				"how much is tish pish tish glob glob glob ?",
				"how many Credits is glob prok Silver ?",
				"how many Credits is glob prok Gold ?",
				"how many Credits is glob prok Iron ?",
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?" };

		transactor.execute(Arrays.asList(lines));

	}
}
