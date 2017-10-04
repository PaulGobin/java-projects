package com.bvn.slack.dto;

public class SlackDirectMessageRequest extends SlackMessageRequestBase {

	private String slackUser;

	public SlackDirectMessageRequest()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param slackUser
	 */
	public SlackDirectMessageRequest(String content, String slackTeam, String slackUser)
	{
		super(content, slackTeam);
		this.slackUser = slackUser;
	}

	/**
	 * @return the slackUser
	 */
	public String getSlackUser()
	{
		return slackUser;
	}

	/**
	 * @param slackUser
	 *            the slackUser to set
	 */
	public void setSlackUser(String slackUser)
	{
		this.slackUser = slackUser;
	}

}
