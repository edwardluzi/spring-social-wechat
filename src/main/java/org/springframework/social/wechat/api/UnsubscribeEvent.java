package org.springframework.social.wechat.api;

import java.util.Map;

public class UnsubscribeEvent extends EventMessage
{
	public UnsubscribeEvent(Map<String, String> params) throws Exception
	{
		super(params);
	}
}
