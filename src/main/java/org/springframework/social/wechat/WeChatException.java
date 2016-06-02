package org.springframework.social.wechat;

public class WeChatException extends RuntimeException
{
    private static final long serialVersionUID = 4019046302399739194L;

    public WeChatException(Exception exception)
    {
        super(exception);
    }

    public WeChatException(String reason)
    {
        super(reason);
    }
}
