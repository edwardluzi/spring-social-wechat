package org.springframework.social.wechat.api;

import java.io.Writer;
import java.util.Calendar;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public abstract class Message
{
    // CHECKSTYLE:OFF

    private String FromUserName;
    private String ToUserName;
    private long CreateTime;
    private MessageType MsgType;

    // CHECKSTYLE:ON

    public String getFromUserName()
    {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName)
    {
        this.FromUserName = fromUserName;
    }

    public String getToUserName()
    {
        return ToUserName;
    }

    public void setToUserName(String toUserName)
    {
        this.ToUserName = toUserName;
    }

    public long getCreateTime()
    {
        return CreateTime;
    }

    public MessageType getType()
    {
        return MsgType;
    }

    protected Message(MessageType type)
    {
        MsgType = type;
        CreateTime = Calendar.getInstance().getTimeInMillis();
    }

    protected Message(Map<String, String> params) throws Exception
    {
        FromUserName = params.get("FromUserName");
        ToUserName = params.get("ToUserName");
        CreateTime = Long.parseLong(params.get("CreateTime"), 10);
        MsgType = MessageType.valueOf(params.get("MsgType"));
    }

    public String toXmlString()
    {
        getXstream().alias("xml", getClass());
        return getXstream().toXML(this);
    }

    private static XStream xstream = null;

    protected static XStream getXstream()
    {
        if (xstream == null)
        {
            xstream = new XStream(new XppDriver()
            {
                @Override
                public HierarchicalStreamWriter createWriter(Writer out)
                {
                    return new PrettyPrintWriter(out)
                    {
                        @Override
                        protected void writeText(QuickWriter writer, String text)
                        {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        }
                    };
                }
            });
        }

        return xstream;
    }
}
