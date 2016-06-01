package org.springframework.social.wechat.api;

import java.util.Map;

public class ClickEvent extends EventMessage
{
    public ClickEvent(Map<String, String> params) throws Exception
    {
        super(params);
    }
}
