package org.springframework.social.wechat.connect;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.oauth2.AccessGrant;

@ComponentScan(basePackages = "org.springframework.social.wechat")
@PropertySource("classpath:application.properties")
public class ServiceProviderTest
{
	private static final Logger logger = Logger.getLogger(ServiceProviderTest.class);

	private AnnotationConfigApplicationContext applicationContext;
	private Environment environment;

	@Before
	public void setup()
	{
		this.applicationContext = new AnnotationConfigApplicationContext(ServiceProviderTest.class);
		this.environment = this.applicationContext.getEnvironment();
	}

	@After
	public void tearDown()
	{
		if (this.applicationContext != null)
		{
			this.applicationContext.close();
		}
	}

	@Test
	public void testConnect()
	{
		assertNotNull(environment);
		
		String appid = environment.getProperty("social.wechat.appid");
		String secret = environment.getProperty("social.wechat.secret");

		WechatServiceProvider provider = new WechatServiceProvider(appid, secret);

		AccessGrant accessGrant = provider.getOAuthOperations().authenticateClient(null);

		String accessToken = accessGrant.getAccessToken();

		logger.debug(accessToken);

		assertNotNull(accessToken);
	}
}
