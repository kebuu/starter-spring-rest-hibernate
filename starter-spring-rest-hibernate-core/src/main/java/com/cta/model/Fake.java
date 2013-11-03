package com.cta.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;

@Getter
@Setter
@Entity
public class Fake extends Model {

	private String someString;
	private Date someDate;
	
	@org.hibernate.annotations.Type(type="com.cta.misc.hibernate.PersistentDateTime")
	private DateTime someDateTime;
}
