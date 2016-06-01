package org.springframework.social.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.wechat.api.Wechat;

public class WechatAdapter implements ApiAdapter<Wechat>
{
    @Override
    public boolean test(Wechat api)
    {
        return false;
    }

    @Override
    public void setConnectionValues(Wechat api, ConnectionValues values)
    {
    }

    @Override
    public UserProfile fetchUserProfile(Wechat api)
    {
        return null;
    }

    @Override
    public void updateStatus(Wechat api, String message)
    {
    }
}
