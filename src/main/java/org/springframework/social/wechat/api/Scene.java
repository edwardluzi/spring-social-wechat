package org.springframework.social.wechat.api;

import java.io.Serializable;

public class Scene extends WechatObject implements Serializable
{
	private static final long serialVersionUID = 1497268036177063492L;

	private Integer sceneId;

	private String sceneStr;

	public Integer getSceneId()
	{
		return sceneId;
	}

	public void setSceneId(Integer sceneId)
	{
		this.sceneId = sceneId;
	}

	public String getSceneStr()
	{
		return sceneStr;
	}

	public void setSceneStr(String sceneStr)
	{
		this.sceneStr = sceneStr;
	}

	public Scene(Integer sceneId)
	{
		this.sceneId = sceneId;
	}

	public Scene(String sceneStr)
	{
		this.sceneStr = sceneStr;
	}
}
