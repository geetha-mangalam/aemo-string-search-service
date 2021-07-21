package com.company.stringsearch.service;

import com.company.stringsearch.model.SearchResult;

/**
 * The Interface SearchService.
 */
public interface SearchService {

	
	/**
	 * Search. Searches for a patern in a String 
	 *
	 * @param text the text
	 * @param subText the sub text
	 * @return the search result with list of indices of the matches
	 */
	public SearchResult search(String text, String subText);

	

}
