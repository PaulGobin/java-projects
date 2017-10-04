package com.bvn.slack.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**************************************************
 * Helper for managing http header authentication is needed. Shoule probably
 * utilize a resource server or just get these from auth tables
 * 
 * @author pgobin
 *
 */
@Component
public class RequestHeaderAuthenticator {

	private static Log log = LogFactory.getLog(RequestHeaderAuthenticator.class);
	// Put this in persistent storage and map account to auth token, consider
	// using HMAC

	private static final String __MYOS_ACCOUNT_HEADER_KEY = "hdmeeting";

	/*****************************************************
	 * 8
	 * 
	 * @param headers
	 * @return
	 */
	public HttpStatus isAuthorized(HttpHeaders headers)
	{
		if (headers == null)
		{
			log.error("HTTP HEADER PARAMETER IS NULL!!");
			return HttpStatus.UNAUTHORIZED;
		}

		return HttpStatus.OK;
	}
}
