package org.springframework.social.wechat.api;

import java.util.Map;

public class ScanEvent extends EventMessage
{
	private String EventKey;
	private String Ticket;

	public ScanEvent(Map<String, String> params) throws Exception
	{
		super(params);

		if (params.containsKey("EventKey"))
		{
			this.EventKey = params.get("EventKey");
		}

		if (params.containsKey("Ticket"))
		{
			this.Ticket = params.get("Ticket");
		}
	}

	public String getEventKey()
	{
		return EventKey;
	}

	public String getTicket()
	{
		return Ticket;
	}
}
