/**
 * 
 */
package com.bvn.slack;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Enables cross origing domain if necessary SimpleCORSFilter.java <br/>
 * 
 * @author pgobin Feb 2, 2015 7:33:40 PM
 * 
 *
 */
@Component
// @EnableWebMvc
public class SimpleCORSFilter extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("*");

		// .allowedOrigins("http://domain2.com")
		// .allowedMethods("PUT", "DELETE")
		// .allowedHeaders("header1", "header2", "header3")
		// .exposedHeaders("header1", "header2")
		// .allowCredentials(false).maxAge(3600);
	}
}
