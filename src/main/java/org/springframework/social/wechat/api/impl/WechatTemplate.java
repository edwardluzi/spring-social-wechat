package org.springframework.social.wechat.api.impl;

import java.net.URI;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.wechat.api.AccessToken;
import org.springframework.social.wechat.api.AccountOperations;
import org.springframework.social.wechat.api.MessageOperations;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.api.impl.json.WechatModule;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WechatTemplate extends AbstractOAuth2ApiBinding implements Wechat
{
	private AccountOperations accountOperations;
	private MessageOperations messageOperations;

	private ObjectMapper objectMapper;

	public WechatTemplate(String accessToken)
	{
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		initialize();
	}

	public WechatTemplate()
	{
		initialize();
	}

	public AccountOperations accountOperations()
	{
		return accountOperations;
	}

	public MessageOperations messageOperations()
	{
		return messageOperations;
	}

	public RestOperations restOperations()
	{
		return getRestTemplate();
	}

	protected ObjectMapper getObjectMapper()
	{
		return objectMapper;
	}

	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory)
	{
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	@Override
	protected OAuth2Version getOAuth2Version()
	{
		return OAuth2Version.BEARER_DRAFT_2;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate)
	{
		super.configureRestTemplate(restTemplate);
		restTemplate.setErrorHandler(new WechatErrorHandler());
	}

	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter()
	{
		MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new WechatModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	private void initialize()
	{
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate()
				.getRequestFactory()));
		initSubApis();
	}

	private void initSubApis()
	{
		this.accountOperations = new AccountTemplate(getRestTemplate(), objectMapper,
				isAuthorized());

		this.messageOperations = new MessageTemplate(getRestTemplate(), objectMapper,
				isAuthorized());
	}

	public static AccessToken getAccessToken(String appid, String secret)
			throws RestClientException
	{

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "client_credential");
		params.add("appid", appid);
		params.add("secret", secret);

		URI uri = URIBuilder.fromUri("https://api.weixin.qq.com/cgi-bin/token").queryParams(params)
				.build();

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(uri, AccessToken.class);
	}
}
