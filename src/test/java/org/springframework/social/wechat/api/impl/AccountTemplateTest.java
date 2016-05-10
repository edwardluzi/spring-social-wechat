package org.springframework.social.wechat.api.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.social.wechat.api.ActionInfo;
import org.springframework.social.wechat.api.QuickResponseCodeRequest;
import org.springframework.social.wechat.api.QuickResponseCodeTicket;
import org.springframework.social.wechat.api.Scene;

public class AccountTemplateTest extends AbstractWechatApiTest
{
	@Test
	public void test()
	{
		QuickResponseCodeRequest request = new QuickResponseCodeRequest();

		request.setExpireSeconds(600);
		request.setActionName("QR_SCENE");
		request.setActionInfo(new ActionInfo(new Scene(100)));

		QuickResponseCodeTicket ticket = this.wechat.accountOperations().createQuickResponseCode(
				request);

		assertNotNull(ticket);
		assertNotNull(ticket.getTicket());
	}
}
