package org.springframework.social.wechat.api;

import java.io.Serializable;

public class QuickResponseCodeRequest extends WechatObject implements Serializable
{
    private static final long serialVersionUID = -8459833356442062115L;

    private Integer expireSeconds;

    private String actionName;

    private ActionInfo actionInfo;

    public Integer getExpireSeconds()
    {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds)
    {
        this.expireSeconds = expireSeconds;
    }

    public String getActionName()
    {
        return actionName;
    }

    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }

    public ActionInfo getActionInfo()
    {
        return actionInfo;
    }

    public void setActionInfo(ActionInfo actionInfo)
    {
        this.actionInfo = actionInfo;
    }
}
