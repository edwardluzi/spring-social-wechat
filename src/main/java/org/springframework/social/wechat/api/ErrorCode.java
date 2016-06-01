package org.springframework.social.wechat.api;

import java.io.Serializable;

public class ErrorCode extends WechatObject implements Serializable
{
    private static final long serialVersionUID = -7329216692460297061L;

    private Integer errcode;
    private String errmsg;

    public Integer getErrcode()
    {
        return errcode;
    }

    public String getErrmsg()
    {
        return errmsg;
    }

    public ErrorCode()
    {
    }

    public ErrorCode(Integer errcode, String errmsg)
    {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }
}
