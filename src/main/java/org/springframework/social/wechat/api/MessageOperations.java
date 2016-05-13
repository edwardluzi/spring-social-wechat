package org.springframework.social.wechat.api;

public interface MessageOperations
{
	void send(TemplateMessage<?> message);
}
