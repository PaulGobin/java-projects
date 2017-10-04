/**
 * 
 */
package com.bvn.slack.connector;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bvn.slack.dto.SlackDirectMessageRequest;

import in.ashwanthkumar.slack.webhook.Slack;
import in.ashwanthkumar.slack.webhook.SlackAttachment;
//import net.gpedro.integrations.slack.SlackApi;
//import net.gpedro.integrations.slack.SlackMessage;

/**
 * @author pgobin https://github.com/gpedro/slack-webhook
 * 
 *         https://dzone.com/articles/make-slack-bots-in-java-in-minutes
 * 
 *         https://github.com/ramswaroop/jbot
 * 
 */

public class SlackConnector {

	private static final Log log = LogFactory.getLog(SlackConnector.class);

	private static final String webhookUrl = "https://hooks.slack.com/services/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";

	/**
	 * 
	 */
	public SlackConnector()
	{
		// TODO Auto-generated constructor stub
	}

	public void sendSimpleMessage()
	{
		// Send simple message
		// SlackApi api = new
		// SlackApi("https://hooks.slack.com/services/id_1/id_2/token");

	//	SlackApi api = new SlackApi(webhookUrl);

		// SlackMessage slackMessage = new
		// SlackMessage("pgobin@broadviewnet.com", "This is A test");
	//	SlackMessage slackMessage = new SlackMessage("sfarkouh@broadviewnet.com",
	//		"This is A test from Paul calling via Slack API. Please lmk if you received it.");
		// slackMessage.set
//		api.call(slackMessage);
		// api.call(new SlackMessage("From Paul G"));
	}

	public void sendDirectMessage(SlackDirectMessageRequest dto)
	{
		// https://github.com/ashwanthkumar/slack-java-webhook
		// Using SlackMessage
		String slackUser = dto.getSlackUser();
		String content = dto.getContent();
		String displayName = dto.getDisplayName();
		// slackUser = "paulg-gmail";
		// slackUser = "scf";

		/*
		 * in.ashwanthkumar.slack.webhook.SlackMessage sm = new
		 * in.ashwanthkumar.slack.webhook.SlackMessage(
		 * "Hello- Please be advise that your billing statement is ready and available at "
		 * ).link("www.MyOfficeSuite.com", "MyOfficeSuite")
		 * .bold(" Courtesy Broadview Networks Billing Services.");
		 */

		in.ashwanthkumar.slack.webhook.SlackMessage sm = new in.ashwanthkumar.slack.webhook.SlackMessage(content);
		// sm.
		try
		{
			Slack s = new Slack(webhookUrl);
			// s.icon("https://myofficesuite.broadviewnet.com/favicon/apple-touch-icon-114x114.png");
			s.sendToUser(slackUser);
			s.displayName(displayName);
			s.push(sm);

			/*
			 * new Slack(webhookUrl) .icon(":smiling_imp:") // Ref -
			 * http://www.emoji-cheat-sheet.com/ .sendToUser("slackbot")
			 * .displayName("slack-java-client") .push(sm);
			 */

			log.info("Message sent to SLACK User [" + slackUser + "]");

		} catch (IOException e)
		{
			log.error("Error sending SLACK message to user [" + slackUser + "]", e);
		}
	}

	/*************************************************
	 * 
	 */
	public void sendDirectMessageWithAttachment()
	{
		String slackUser = "paulgobin";
		// slackUser = "paulg-gmail";
		// slackUser = "scf";

		// Using SlackAttachment
		try
		{
			new Slack(webhookUrl).sendToUser(slackUser).displayName("MyOfficeSuite")
				.push(new SlackAttachment("Billing Invoice Attached").author("Click to View Invoice",
					"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAl8AAAAJDg2MDkyZmEyLTUwYTMtNDQ1NS1iYTc0LWQ0OGQxNDcxMDI4Zg.jpg"));

			log.info("Sent");
		} catch (Exception ex)
		{
			log.error(ex);
		}
	}

	public void sendSimpleWith_slackJavaWebhookViaChannel(boolean sendWithAttachmant)
	{
		// https://github.com/ashwanthkumar/slack-java-webhook
		// Using SlackMessage
		String slackChannel = "general";
		// slackUser = "paulg-gmail";
		// slackUser = "scf";

		in.ashwanthkumar.slack.webhook.SlackMessage sm = new in.ashwanthkumar.slack.webhook.SlackMessage(
			"Hello- Please be advise that your billing statement is ready and available at ").link("www.MyOfficeSuite.com", "MyOfficeSuite")
				.bold(" Courtesy Broadview Networks Billing Services.");
		try
		{

			SlackAttachment slackAttachment = new SlackAttachment("Billing Invoice Attached").author("Click to View Invoice",
				"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAl8AAAAJDg2MDkyZmEyLTUwYTMtNDQ1NS1iYTc0LWQ0OGQxNDcxMDI4Zg.jpg");

			Slack s = new Slack(webhookUrl);
			// s.icon("https://myofficesuite.broadviewnet.com/favicon/apple-touch-icon-114x114.png");
			s.sendToChannel(slackChannel);
			s.displayName("MyOfficeSuite");
			if (sendWithAttachmant)
			{
				s.push(slackAttachment);
			} else
			{
				s.push(sm);
			}

			/*
			 * new Slack(webhookUrl) .icon(":smiling_imp:") // Ref -
			 * http://www.emoji-cheat-sheet.com/ .sendToUser("slackbot")
			 * .displayName("slack-java-client") .push(sm);
			 */

			log.info("Message sent to SLACK CHANNEL [" + slackChannel + "]");

		} catch (IOException e)
		{
			log.error("Error sending SLACK message to CHANNEL [" + slackChannel + "]", e);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SlackConnector c = new SlackConnector();
		// c.sendSimpleMessage();

		// c.sendSimpleWith_slackJavaWebhook();
		// c.sendSimpleWith_slackJavaWebhookWithAttachment();
		c.sendSimpleWith_slackJavaWebhookViaChannel(true);

	}

}
