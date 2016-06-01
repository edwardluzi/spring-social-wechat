package org.springframework.social.wechat.api.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.wechat.connect.WechatServiceProvider;

public class AbstractWechatApiTest
{
    protected WechatTemplate wechat;

    private AnnotationConfigApplicationContext applicationContext;
    private Environment environment;

    @Before
    public void setup()
    {
        applicationContext = new AnnotationConfigApplicationContext(AbstractWechatApiTest.class);
        environment = applicationContext.getEnvironment();

        wechat = createWechatTemplate();
    }

    @After
    public void tearDown()
    {
        if (applicationContext != null)
        {
            applicationContext.close();
        }
    }

    protected WechatTemplate createWechatTemplate()
    {
        String appid = environment.getProperty("social.wechat.appid");
        String secret = environment.getProperty("social.wechat.secret");

        WechatServiceProvider provider = new WechatServiceProvider(appid, secret);

        AccessGrant accessGrant = provider.getOAuthOperations().authenticateClient(null);

        assertNotNull(accessGrant.getAccessToken());

        return new WechatTemplate(accessGrant.getAccessToken());
    }
}
