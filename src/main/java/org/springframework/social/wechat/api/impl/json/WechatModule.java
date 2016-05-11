package org.springframework.social.wechat.api.impl.json;

import org.springframework.social.wechat.api.AccessToken;
import org.springframework.social.wechat.api.ActionInfo;
import org.springframework.social.wechat.api.QuickResponseCodeRequest;
import org.springframework.social.wechat.api.QuickResponseCodeTicket;
import org.springframework.social.wechat.api.Scene;
import org.springframework.social.wechat.api.WechatObject;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class WechatModule extends SimpleModule
{
	private static final long serialVersionUID = 2187084305052393830L;

	public WechatModule()
	{
		super("WechatModule");
	}

	@Override
	public void setupModule(SetupContext context)
	{
		context.setMixInAnnotations(AccessToken.class, AccessTokenMixin.class);
		context.setMixInAnnotations(ActionInfo.class, ActionInfoMixin.class);
		context.setMixInAnnotations(QuickResponseCodeRequest.class,
				QuickResponseCodeRequestMixin.class);
		context.setMixInAnnotations(QuickResponseCodeTicket.class,
				QuickResponseCodeTicketMixin.class);
		context.setMixInAnnotations(Scene.class, SceneMixin.class);
		context.setMixInAnnotations(WechatObject.class, WechatObjectMixin.class);
	}
}
