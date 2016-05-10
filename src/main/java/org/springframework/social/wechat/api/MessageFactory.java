package org.springframework.social.wechat.api;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MessageFactory
{
	public static Message create(HttpServletRequest request)
	{
		Message message = null;

		try
		{
			Map<String, String> params = parse(request);
			MessageType messageType = MessageType.valueOf(params.get("MsgType"));

			switch (messageType)
			{
			case event:
			{
				EventType eventType = EventType.valueOf(params.get("Event"));

				switch (eventType)
				{
				case subscribe:
				{
					message = new SubscribeEvent(params);
					break;
				}
				case scan:
				{
					message = new ScanEvent(params);
					break;
				}
				default:
					break;
				}

				break;
			}
			case text:
			{
				message = new TextMessage(params);
				break;
			}
			default:
			{
				break;
			}
			}
		}
		catch (Exception e)
		{
			message = null;
			e.printStackTrace();
		}

		return message;
	}

	private static Map<String, String> parse(HttpServletRequest request) throws Exception
	{
		Map<String, String> params = new HashMap<String, String>();
		InputStream inputStream = request.getInputStream();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

		Document document = documentBuilder.parse(inputStream);
		Element rootNode = document.getDocumentElement();
		NodeList childNodes = rootNode.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++)
		{
			Node node = childNodes.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				params.put(node.getNodeName(), node.getTextContent());
			}
		}

		inputStream.close();
		inputStream = null;

		return params;
	}
}
