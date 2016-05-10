package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class ValueColorPairMixin extends WechatObjectMixin
{
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("color")
	private String color;

}
