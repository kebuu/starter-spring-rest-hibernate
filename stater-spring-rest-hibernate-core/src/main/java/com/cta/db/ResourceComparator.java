package com.cta.db;

import java.io.IOException;
import java.util.Comparator;

import org.springframework.core.io.Resource;

/**
 * Comparator for spring resource api
 */
final class ResourceComparator implements Comparator<Resource> {

	@Override
	public int compare(Resource o1, Resource o2) {
		try {
			if (o1.getFilename() != null) {
				return o1.getFilename().compareTo(o2.getFilename());
			} else if (o1.getURI() != null) {
				return o1.getURI().compareTo(o2.getURI());
			} else {
				return 0;
			}
		} catch (IOException e) {
			return 0;
		}
	}
}