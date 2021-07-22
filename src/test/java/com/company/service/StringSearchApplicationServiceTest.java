package com.company.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

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
		
		testSearch("123", "1", java.util.Arrays.asList(0));
		testSearch("During the interview, we will ask you to walk us through your solution. This test provides an opportunity for the candidate to showcase their understanding of software development",
				"the", java.util.Arrays.asList(7, 110, 136));
		testSearch("Hello from Hello Service", "hello", java.util.Arrays.asList(0,11));
		testSearch("Hello from Hello Service", "Hello", java.util.Arrays.asList(0,11));

		testSearch("Hello from hello Service", "hello", java.util.Arrays.asList(0,11));
		testSearch("Build and deploy JAR app to Azure Web App", "jar", java.util.Arrays.asList(17));
		testSearch("Build and deploy JAR app to Azure Web App", "app", java.util.Arrays.asList(21, 38));
		testSearch("Build and deploy JAR app to Azure Web App", "Google", java.util.Arrays.asList());
		
	}
	private void testSearch(String text, String subText, List<Integer> indices ) throws Exception {
		SearchResult searchResult = service.search(text, subText);
		// check the size
		assertEquals(indices.size(), searchResult.getIndices().size());
		// check the content
		if(indices != null && indices.size() > 0) {
			assertSame(indices.get(0), searchResult.getIndices().get(0));
		}
		
 
	}
}
