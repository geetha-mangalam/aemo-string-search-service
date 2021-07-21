package com.company.stringsearch.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new search result.
 */

/**
 * Instantiates a new search result.
 *
 * @param subText the sub text
 * @param text the text
 * @param indices the indices
 */
@AllArgsConstructor

/**
 * Instantiates a new person.
 */

/**
 * Instantiates a new search result.
 */

/**
 * Instantiates a new search result.
 */
@NoArgsConstructor

/**
 * Gets the indices.
 *
 * @return the indices
 */

/**
 * Gets the indices.
 *
 * @return the indices
 */
@Getter

/**
 * Sets the indices.
 *
 * @param indices the new indices
 */

/**
 * Sets the indices.
 *
 * @param indices the new indices
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
@ApiModel
public class SearchResult {
	
	/** The sub text. */
	@ApiModelProperty
	String subText;
	
	/** The text. */
	@ApiModelProperty
	String text;

	/** The indices. */
	@ApiModelProperty
	private List<Integer> indices;

}
