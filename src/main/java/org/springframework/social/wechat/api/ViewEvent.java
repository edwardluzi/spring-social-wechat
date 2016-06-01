package org.springframework.social.wechat.api;

import java.util.Map;

public class ViewEvent extends EventMessage
{
    public ViewEvent(Map<String, String> params) throws Exception
    {
        super(params);
    }
}
