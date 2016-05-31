package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class ErrorCodeMixin extends WechatObjectMixin
{
	@JsonProperty("errcode")
	Integer errcode;

	@JsonProperty("errmsg")
	String errmsg;
}
