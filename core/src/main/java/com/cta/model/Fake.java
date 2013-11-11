package com.cta.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;

@Getter
@Setter
@Entity
public class Fake extends Model {

	@NotNull
	private String someString;
	private Date someDate;
	
	@org.hibernate.annotations.Type(type="com.cta.misc.hibernate.PersistentDateTime")
	private DateTime someDateTime;
}
