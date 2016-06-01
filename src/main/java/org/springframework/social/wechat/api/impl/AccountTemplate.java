package org.springframework.social.wechat.api.impl;

import org.springframework.social.wechat.api.AccountOperations;
import org.springframework.social.wechat.api.QuickResponseCodeRequest;
import org.springframework.social.wechat.api.QuickResponseCodeTicket;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

class AccountTemplate extends AbstractTemplate implements AccountOperations
{
    private static final String API_URL_QRCODE_CREATE = "qrcode/create";

    public AccountTemplate(RestOperations restOperations, ObjectMapper objectMapper, boolean isAuthorized)
    {
        super(restOperations, objectMapper, isAuthorized);
    }

    public QuickResponseCodeTicket createQuickResponseCode(QuickResponseCodeRequest request)
    {
        requireAuthorization();

        return getRestOperations().postForObject(buildUri(API_URL_QRCODE_CREATE), request,
                QuickResponseCodeTicket.class);
    }
}
