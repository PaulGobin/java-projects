package com.bvn.slack.dto;

public class SlackMessageRequestBase {

	private String content;

	private String slackTeam;

	private String displayName;

	public SlackMessageRequestBase()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param content
	 */
	public SlackMessageRequestBase(String content, String slackTeam)
	{
		super();
		this.content = content;
		this.slackTeam = slackTeam;
	}

	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * @return the slackTeam
	 */
	public String getSlackTeam()
	{
		return slackTeam;
	}

	/**
	 * @param slackTeam
	 *            the slackTeam to set
	 */
	public void setSlackTeam(String slackTeam)
	{
		this.slackTeam = slackTeam;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

}
