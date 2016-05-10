package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class SceneMixin extends WechatObjectMixin
{
	@JsonProperty("scene_id")
	private Integer sceneId;

	@JsonProperty("scene_str")
	private String sceneStr;
}
