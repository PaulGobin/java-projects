package com.bvn.slack.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.bvn.slack.connector.SlackConnector;
import com.bvn.slack.dto.SlackDirectMessageRequest;
import com.bvn.slack.utils.RequestHeaderAuthenticator;

import io.swagger.annotations.ApiOperation;

/*************************************************
 * Rest API Service Entry point
 * 
 * @author pgobin
 *
 */
@RestController
@RequestMapping("/SlackGatewayService")
// @Api(authorizations = { @Authorization(value = "sampleoauth", scopes = {}) },
// value = "HD Meeting Service")
public class SlackGatewayServiceController {

	private static Log log = LogFactory.getLog(SlackGatewayServiceController.class);

	@Autowired
	RequestHeaderAuthenticator requestHeaderAuthenticator;

	public SlackGatewayServiceController()
	{
		// TODO Auto-generated constructor stub
	}

	/******************************************
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 * 
	 * 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/SendDirectMessage")
	@ApiOperation(value = "Send a direct message to a slack user in a slack team", notes = "")
	public void sendDirectMessage(@RequestHeader HttpHeaders headers, @RequestBody(required = true) SlackDirectMessageRequest req) throws Exception
	{
		log.info("Request to send direct message to slack user " + req.getSlackUser());
		HttpStatus httpStatus = requestHeaderAuthenticator.isAuthorized(headers);
		if (httpStatus != HttpStatus.OK)
		{
			throw new HttpClientErrorException(httpStatus, httpStatus.getReasonPhrase());
		}

		new SlackConnector().sendDirectMessage(req);
	}

}
