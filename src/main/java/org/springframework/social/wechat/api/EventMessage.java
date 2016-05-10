package org.springframework.social.wechat.api;

import java.util.Map;

public class EventMessage extends Message
{
	private EventType eventType;

	protected EventMessage(Map<String, String> params) throws Exception
	{
		super(params);
		this.eventType = EventType.valueOf(params.get("Event"));
	}

	public EventType getEventType()
	{
		return eventType;
	}
}
