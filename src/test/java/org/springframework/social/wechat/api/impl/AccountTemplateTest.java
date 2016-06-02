package org.springframework.social.wechat.api.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.social.wechat.api.ActionInfo;
import org.springframework.social.wechat.api.QuickResponseCodeRequest;
import org.springframework.social.wechat.api.QuickResponseCodeTicket;
import org.springframework.social.wechat.api.Scene;

@ComponentScan(basePackages = "org.springframework.social.wechat")
@PropertySource("classpath:application.properties")
public class AccountTemplateTest extends AbstractWechatApiTest
{
    @Test
    public void testQuickResponseCode()
    {
        QuickResponseCodeRequest request = new QuickResponseCodeRequest();

        request.setExpireSeconds(600);
        request.setActionName("QR_SCENE");
        request.setActionInfo(new ActionInfo(new Scene(100)));

        QuickResponseCodeTicket ticket = wechat.accountOperations().createQuickResponseCode(request);

        assertNotNull(ticket);
        assertNotNull(ticket.getTicket());
    }
}
