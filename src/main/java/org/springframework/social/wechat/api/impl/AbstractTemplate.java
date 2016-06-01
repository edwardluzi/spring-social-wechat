package org.springframework.social.wechat.api.impl;

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract class AbstractTemplate
{
    private static final String API_URL_BASE = "https://api.weixin.qq.com/cgi-bin/";

    private final boolean isAuthorized;
    private final RestOperations restOperations;
    private final ObjectMapper objectMapper;

    protected RestOperations getRestOperations()
    {
        return restOperations;
    }

    protected ObjectMapper getObjectMapper()
    {
        return objectMapper;
    }

    protected AbstractTemplate(RestOperations restOperations, ObjectMapper objectMapper, boolean isAuthorized)
    {
        this.restOperations = restOperations;
        this.objectMapper = objectMapper;
        this.isAuthorized = isAuthorized;
    }

    protected void requireAuthorization()
    {
        if (!isAuthorized)
        {
            throw new MissingAuthorizationException("weibo");
        }
    }

    protected URI buildUri(String path)
    {
        return URIBuilder.fromUri(API_URL_BASE + path).build();
    }

    protected URI buildUri(String path, String paramrName, Object paramValue)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(paramrName, paramValue.toString());
        return buildUri(path, params);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> params)
    {
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(params).build();
    }
}
