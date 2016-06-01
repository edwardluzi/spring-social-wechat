package org.springframework.social.wechat.api;

public interface AccountOperations
{
    QuickResponseCodeTicket createQuickResponseCode(QuickResponseCodeRequest request);
}