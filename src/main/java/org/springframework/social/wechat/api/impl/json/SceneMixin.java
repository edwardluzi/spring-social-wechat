package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SceneMixin extends WechatObjectMixin
{
	@JsonProperty("scene_id")
	private Integer sceneId;

	@JsonProperty("scene_str")
	private String sceneStr;
}
