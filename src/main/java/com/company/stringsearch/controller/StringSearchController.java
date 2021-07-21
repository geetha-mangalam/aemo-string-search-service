package com.company.stringsearch.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.stringsearch.model.SearchResult;
import com.company.stringsearch.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;

/**
 * The Class PostCodeController.
 */
@RestController
@RequestMapping("/string")
@Api(description = "Controller for searching for a pattern (subtext) in a string ", value = "StringSearchController")

/** The Constant log. */
@Log4j2
public class StringSearchController extends GenericController {

	/** The search service. */
	@Autowired
	private SearchService searchService;

	/**
	 * Gets the pattern search result with a list of indices of the matches
	 *
	 * @param text               the String to search on
	 * @param subText            the pattern to search
	 * @param httpServletRequest the http servlet request
	 * @return the pattern search result
	 * @throws Exception the exception
	 */
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Searches for a pattern in a String and returns search result with a list of indices of the matches")
	public ResponseEntity<SearchResult> getPatternSearchResult(
			@ApiParam(name = "text", value = "text", required = true) @RequestParam(value = "text", required = true) final String text,
			@ApiParam(name = "subText", value = "subText", required = true) @RequestParam(value = "subText", required = true) final String subText,
			final HttpServletRequest httpServletRequest) throws Exception {
		log.info( "Searching for: '{}' in  '{}'  ", subText, text);
		if (!StringUtils.hasText(text) || !StringUtils.hasText(subText)) {
			throw new IllegalArgumentException("Both text and subText are required to complete this action");
		}

		// delegate to service layer
		SearchResult result = searchService.search(text, subText);

		log.debug( "search result for : '{}' '{}' is {} ", text, subText, result);
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Send response to client
		return new ResponseEntity<>(result, headers, HttpStatus.OK);

	}

}
