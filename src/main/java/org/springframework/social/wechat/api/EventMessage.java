package org.springframework.social.wechat.api;

import java.util.Map;

public class EventMessage extends Message
{
    private EventType eventType;
    private String eventKey;

    protected EventMessage(Map<String, String> params) throws Exception
    {
        super(params);
        eventType = EventType.valueOf(params.get("Event"));

        if (params.containsKey("EventKey"))
        {
            eventKey = params.get("EventKey");
        }
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public String getEventKey()
    {
        return eventKey;
    }
}
