package com.company.stringsearch.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@NoArgsConstructor

@ToString
@ApiModel
public class SearchResult {
	
	public String getSubText() {
		return subText;
	}

	public void setSubText(String subText) {
		this.subText = subText;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Integer> getIndices() {
		return indices;
	}

	public void setIndices(List<Integer> indices) {
		this.indices = indices;
	}

	/** The sub text. */
	@ApiModelProperty
	private String subText;
	
	/** The text. */
	@ApiModelProperty
	private String text;

	/** The indices. */
	@ApiModelProperty
	private List<Integer> indices;

}
