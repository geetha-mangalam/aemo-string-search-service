package com.company.stringsearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Instantiates a new error response.
 *
 * @param errorCode        the error code
 * @param errorDescription the error description
 */
@AllArgsConstructor

/**
 * Instantiates a new error response.
 */
@NoArgsConstructor

@Getter

@Setter

public class ErrorResponse {

	/** The error code. */
	private String errorCode;

	/** The error description. */
	private String errorDescription;
}
