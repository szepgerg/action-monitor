package com.gergo.actionmonitor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * Created by gergo on 2015.10.25..
 */

@Service
@PropertySource(value = "classpath:META-INF/maven/com.gergo.actionmonitor/action-monitor/pom.properties", ignoreResourceNotFound = true)
public class VersionProvider {

	private String applicationVersion;

	@Autowired
	public VersionProvider(@Value("${version:none}") String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public String getApplicationVersion() {
		return this.applicationVersion;
	}

}
