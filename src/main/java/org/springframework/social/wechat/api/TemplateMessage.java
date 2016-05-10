package org.springframework.social.wechat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateMessage<T>
{
	@JsonProperty("touser")
	private String touser;
	@JsonProperty("template_id")
	private String templateId;
	@JsonProperty("url")
	private String url;
	@JsonProperty("data")
	private T data;

	public String getTouser()
	{
		return touser;
	}

	public void setTouser(String touser)
	{
		this.touser = touser;
	}

	public String getTemplateId()
	{
		return templateId;
	}

	public void setTemplateId(String templateId)
	{
		this.templateId = templateId;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
}
