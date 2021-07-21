package com.company.stringsearch.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity

/**
 * Instantiates a new person.
 *
 * @param id         the id
 * @param firstName  the first name
 * @param middleName the middle name
 * @param lastName   the last name
 * @param postCode   the post code
 */
@AllArgsConstructor

/**
 * Instantiates a new person.
 */
@NoArgsConstructor
@RequiredArgsConstructor


@Getter

@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
@ApiModel
public class Person {

	/** The id. */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@ApiModelProperty
	private UUID  id;

	/** The first name. */
	@Column
	@ApiModelProperty
	@NonNull
	private String firstName;

	/** The middle name. */
	@Column
	@ApiModelProperty
	@NonNull
	private String middleName;

	/** The last name. */
	@Column
	@ApiModelProperty
	@NonNull
	private String lastName;

	/** The post code. */
	@Column
	@ApiModelProperty
	@NonNull
	private String postCode;

}
