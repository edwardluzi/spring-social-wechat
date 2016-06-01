package org.springframework.social.wechat.api.impl.json;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class WechatObjectMixin
{
    @JsonIgnore
    Map<String, Object> extraData;

    @JsonAnySetter
    abstract void add(String key, Object value);
}
