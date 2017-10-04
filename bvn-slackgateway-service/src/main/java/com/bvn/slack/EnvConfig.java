/**
 * 
 */
package com.bvn.slack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Paul
 *
 */
@Component
@Configuration
//comment out this line once IT open up a port to access the config service
//@PropertySource("file:${com.bvn.app.dir}/${spring.application.name}/application.yml")
public class EnvConfig {

	private static Log log = LogFactory.getLog(EnvConfig.class);
	private static Environment env = null;

	/***************************************************
	 * 
	 * @param e
	 */
	@Autowired
	void setEnvironment(Environment e) {
		env = e;
		log.info("***** INITIALIZING --->> " + this.getClass().getCanonicalName() + ":" + env.getProperty("organization.name"));
	}

	/**
	 * @return the env
	 */
	public static Environment getEnv() {
		return env;
	}

}