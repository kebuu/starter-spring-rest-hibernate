package com.cta.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.cta.misc.enums.Operator;

@Data
@AllArgsConstructor
public class SearchCriteria {

	protected String propertyName;
	protected Operator operator;
	protected String propertyValue;
}
