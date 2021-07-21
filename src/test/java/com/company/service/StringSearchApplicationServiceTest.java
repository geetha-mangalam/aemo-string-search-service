package com.company.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.company.stringsearch.model.SearchResult;
import com.company.stringsearch.service.SearchService;
import com.company.stringsearch.service.impl.SearchServiceImpl;

/**
 * The Class StringSearchApplicationServiceTest.
 */
class StringSearchApplicationServiceTest {

	/** The service. */
	SearchService service = new SearchServiceImpl();

	/**
	 * Test SearchString.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSearchString() throws Exception {
		SearchResult searchResult = service.search(
				"During the interview, we will ask you to walk us through your solution. This test provides an opportunity for the candidate to showcase their understanding of software development",
				"the");
		System.out.println(searchResult.getIndices());
		assertEquals(3, searchResult.getIndices().size());
	}

}
