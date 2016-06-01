package org.springframework.social.wechat.api;

import java.util.Map;

public class SubscribeEvent extends EventMessage
{
    private String ticket;

    public SubscribeEvent(Map<String, String> params) throws Exception
    {
        super(params);

        if (params.containsKey("Ticket"))
        {
            ticket = params.get("Ticket");
        }
    }

    public String getTicket()
    {
        return ticket;
    }
}
