package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class QuickResponseCodeTicketMixin extends WechatObjectMixin
{
	@JsonProperty("ticket")
	private String ticket;
	@JsonProperty("expire_seconds")
	private Integer expireSeconds;
	@JsonProperty("url")
	private String url;
}
