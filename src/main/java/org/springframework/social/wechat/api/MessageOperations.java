package org.springframework.social.wechat.api;

public interface MessageOperations
{
	boolean send(TemplateMessage<?> message);
}
