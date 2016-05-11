package org.springframework.social.wechat.api.impl.json;

import org.springframework.social.wechat.api.Scene;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ActionInfoMixin extends WechatObjectMixin
{
	@JsonProperty("scene")
	private Scene scene;
}
