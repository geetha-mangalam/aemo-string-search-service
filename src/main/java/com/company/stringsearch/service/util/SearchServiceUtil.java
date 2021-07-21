package com.company.stringsearch.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Interface SearchServiceUtil.
 */
public interface SearchServiceUtil {

	/**
	 * Searches for a text within a text returning the indices
	 *
	 * @param text    the text
	 * @param subText the sub text
	 * @return the list of integers
	 */
	public static List<Integer> search(String text, String subText) {
		Pattern pattern = Pattern.compile(subText, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		List<Integer> indicesOfOccurences = new ArrayList<Integer>();
		// Find all matches
		while (matcher.find()) {
			// Get the matching location
			indicesOfOccurences.add(matcher.start());
		}
		return indicesOfOccurences;
	}
}
