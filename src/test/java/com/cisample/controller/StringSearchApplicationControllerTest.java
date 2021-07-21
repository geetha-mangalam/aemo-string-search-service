package com.cisample.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.company.stringsearch.controller.StringSearchController;
import com.company.stringsearch.model.SearchResult;
import com.company.stringsearch.service.SearchService;

/**
 * The Test Class PltestApplicationTests.
 */
@AutoConfigureMockMvc
@WebMvcTest(StringSearchController.class)
@TestMethodOrder(OrderAnnotation.class)

class StringSearchApplicationControllerTest {
	
	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;
	
	
	
	/** The Constant getUri. */
	private static final String getUri = "/string/search";

	/** The person service. */
	@MockBean
	private SearchService searchService;


	/**
	 * Test search string .
	 *
	 * @throws Exception the exception
	 */
	@Order(2)
	@Test
	public void testSearch() throws Exception {
		String text = "123";
		String subText = "1";
		SearchResult searchResult = new SearchResult();
		Mockito.when(searchService.search(text,subText)).thenReturn(searchResult);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get(getUri).param("text", text).param("subText", subText)
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String resultStr = result.getResponse().getContentAsString();
		assertNotNull(resultStr);

	}

}
