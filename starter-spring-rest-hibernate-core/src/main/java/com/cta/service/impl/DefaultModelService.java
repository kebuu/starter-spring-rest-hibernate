package com.cta.service.impl;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

import lombok.SneakyThrows;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import com.cta.exception.AppException;
import com.cta.service.ModelService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DefaultModelService implements ModelService {

    public static final String CACHE_NAME = "classByName";
    
    protected ObjectMapper jsonObjectMapper = new ObjectMapper();

	public Object getResource(String resourceName, String jsonData) {
		return getResourceInstance(jsonData, getQualifiedResourceClassName(resourceName));
	}
	
	@Cacheable(value=CACHE_NAME, key="#resourceName")
	@SneakyThrows
	public Class<?> getQualifiedResourceClassName(String resourceName) {
		ClassPathScanningCandidateComponentProvider classPathScanner = new ClassPathScanningCandidateComponentProvider(false);
		classPathScanner.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile("(?i).*[.]" + resourceName + "$")));
		Set<BeanDefinition> findCandidateComponents = classPathScanner.findCandidateComponents("com.cta.model");
		
		if(findCandidateComponents.isEmpty()) {
			throw new AppException("unknown.resource.name", resourceName);
		} else {
			BeanDefinition firstResourceMatch = findCandidateComponents.iterator().next();
			Class<?> forName = ClassUtils.forName(firstResourceMatch.getBeanClassName(),this.getClass().getClassLoader());
			return forName;
		}
	}
	
	public Object getResourceInstance(String jsonData, Class<?> clazz) {
		try {
			return jsonObjectMapper.readValue(jsonData, clazz);
		} catch (IOException e) {
			throw new AppException("resource.population.error", e, clazz.getCanonicalName(), jsonData);
		} 
	}
}
