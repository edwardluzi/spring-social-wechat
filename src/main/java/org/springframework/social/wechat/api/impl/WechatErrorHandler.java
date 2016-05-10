package org.springframework.social.wechat.api.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.UncategorizedApiException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WechatErrorHandler extends DefaultResponseErrorHandler
{
	@Override
	public void handleError(ClientHttpResponse response) throws IOException
	{
		HttpStatus statusCode = response.getStatusCode();
		Map<String, Object> errorDetails = extractErrorDetailsFromResponse(response);

		if (statusCode.series().equals(HttpStatus.Series.CLIENT_ERROR))
		{
			String message = errorDetails.containsKey("error") ? (String) errorDetails.get("error")
					: "Unknown error";
			throw new UncategorizedApiException("weibo", message, null);
		}

		handleUncategorizedError(response);
	}

	private void handleUncategorizedError(ClientHttpResponse response)
	{
		try
		{
			super.handleError(response);
		}
		catch (Exception e)
		{
			throw new UncategorizedApiException("weibo", "Error consuming Weibo REST api", e);
		}
	}

	private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response)
			throws IOException
	{
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());

		try
		{
			return mapper.<Map<String, Object>> readValue(response.getBody(),
					new TypeReference<Map<String, Object>>() {});
		}
		catch (JsonParseException e)
		{
			return Collections.emptyMap();
		}
	}
}
