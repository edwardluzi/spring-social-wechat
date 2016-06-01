package org.springframework.social.wechat.api;

import java.io.Serializable;

public class ActionInfo extends WechatObject implements Serializable
{
    private static final long serialVersionUID = -3828131889657609532L;

    private Scene scene;

    public Scene getScene()
    {
        return scene;
    }

    public void setScene(Scene scene)
    {
        this.scene = scene;
    }

    public ActionInfo(Scene scene)
    {
        this.scene = scene;
    }
}
