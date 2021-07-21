package com.company.stringsearch.service.impl;

import java.util.List;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Service;

import com.company.stringsearch.model.SearchResult;
import com.company.stringsearch.service.SearchService;
import com.company.stringsearch.service.util.SearchServiceUtil;

import lombok.extern.log4j.Log4j2;

/**
 * The Class SearchServiceImpl.
 */
/** The Constant log. */
@Log4j2
@Service
public class SearchServiceImpl implements SearchService {
	private static final Marker SERVICE_LAYER = MarkerManager.getMarker("SERVICE");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pl.test.service.SearchService#search(String , String )
	 */
	@Override
	public SearchResult search(String text, String subText) {
		log.info(SERVICE_LAYER, "searching for '{}' in '{}' ", subText, text);
		List<Integer> indicesOfOccurences = SearchServiceUtil.search(text, subText);
		SearchResult searchResult = new SearchResult(subText, text, indicesOfOccurences);
		log.info(SERVICE_LAYER, "returning from search for '{}' in '{}'  :: {}", subText, text, searchResult);
		return searchResult;

	}

}
