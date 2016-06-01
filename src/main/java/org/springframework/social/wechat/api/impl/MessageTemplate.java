package org.springframework.social.wechat.api.impl;

import org.springframework.social.wechat.api.ErrorCode;
import org.springframework.social.wechat.api.MessageOperations;
import org.springframework.social.wechat.api.TemplateMessage;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageTemplate extends AbstractTemplate implements MessageOperations
{
    private static final String API_URL_SEND_TEMPLATE_MESSAGE = "message/template/send";

    public MessageTemplate(RestOperations restOperations, ObjectMapper objectMapper, boolean isAuthorized)
    {
        super(restOperations, objectMapper, isAuthorized);
    }

    @Override
    public boolean send(TemplateMessage<?> message)
    {
        requireAuthorization();

        ErrorCode errorCode = getRestOperations().postForObject(buildUri(API_URL_SEND_TEMPLATE_MESSAGE), message,
                ErrorCode.class);

        return errorCode.getErrcode() == 0;
    }
}
