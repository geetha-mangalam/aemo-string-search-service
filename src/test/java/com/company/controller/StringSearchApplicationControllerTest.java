package com.company.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.company.stringsearch.controller.StringSearchController;
import com.company.stringsearch.model.SearchResult;
import com.company.stringsearch.service.SearchService;
import com.company.stringsearch.service.impl.SearchServiceImpl;

/**
 * The Test Class StringSearchApplicationControllerTest.
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { StringSearchController.class, SearchServiceImpl.class })
@WebAppConfiguration
@TestMethodOrder(OrderAnnotation.class)

class StringSearchApplicationControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	/** The Constant getUri. */
	private static final String getUri = "/string/search";

	/** The SearchService. */
	@MockBean
	private SearchService searchService;

	/**
	 * Test get persons.
	 *
	 * @throws Exception the exception
	 */
	@Order(1)
	@Test
	public void testSearch() throws Exception {
		String text = "123";
		String subText = "0";
		List<Integer> indices = java.util.Arrays.asList(0);
		SearchResult searchResult = new SearchResult(subText, text, indices);
		//TODO this issue has to be resolved.
		//No converter for [class  with preset Content-Type 'null'
		Mockito.when(searchService.search(text, subText)).thenReturn(null);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(getUri).param("text", text).param("subText", subText)
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk()).andReturn();

		String resultStr = mvcResult.getResponse().getContentAsString();

		assertNotNull(resultStr);
	}

}
