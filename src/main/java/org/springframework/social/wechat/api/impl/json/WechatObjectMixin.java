package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class WechatObjectMixin
{
	@JsonAnySetter
	abstract void add(String key, Object value);
}
