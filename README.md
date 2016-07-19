================================ Spring Social Wechat===============================

This is a Spring Social based java SDK for Wechat official account development.

### Usgae

1 Create an official account in Wechat web site, and then take a note on below parameters

    AppID
    AppSecret
    Token

2 Create a Spring Web MVC Controller
	
    @Controller
    @RequestMapping("/wechat")
    public class WechatController
    {
        private static final Logger logger = Logger.getLogger(WechatController.class);

        @Value("${social.wechat.Token}")
        private String wechatToken;

        // Verify HTTP message are from Wechat server
        @RequestMapping(method = RequestMethod.GET)
        @ResponseBody
        public String validate(@RequestParam(value = "signature", required = true) String signature,
                @RequestParam(value = "timestamp", required = true) String timestamp,
                @RequestParam(value = "nonce", required = true) String nonce,
                @RequestParam(value = "echostr", required = true) String echostr)
        {
            String response = "";
            if (Signature.check(signature, wechatToken, timestamp, nonce))
            {
                if (echostr != null && !echostr.equals(""))
                {
                    response = echostr;
                }
            }
            else
            {
                response = "Failed to validate request!";
                logger.info(response);
            }

            return response;
        }

        // Handle Wechat message from end user
        @RequestMapping(method = RequestMethod.POST)
        @ResponseBody
        public String process(HttpServletRequest request)
        {
            String response = "";

            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");

            if (!Signature.check(signature, wechatToken, timestamp, nonce))
            {
                response = "Failed to validate request!";
                logger.info(response);
            }
            else
            {
                response = process(MessageFactory.create(request));
            }

            return response;
        }
    }
	
3 Handle business logical

    public String process(Message message) 
    {
        if (message.getType() == MessageType.event)
        {
           ....
        }
        else if (message.getType() == MessageType.text)
        {
            TextMessage receivedMessage = (TextMessage) message;
            TextMessage responseMessage = new TextMessage();

            responseMessage.setToUserName(receivedMessage.getFromUserName());
            responseMessage.setFromUserName(receivedMessage.getToUserName());
        
            responseMessage.setContent(String.format(
                "Hello, %s, welcome to Spring Social Wechat.",
                receivedMessage.getFromUserName()));
                
            return responseMessage.toXmlString();
        }
        else
        {
            ...
        }
    }

4 Create a WeChat instance to invoke advance feature provided by wechat.

    Except passive response message, Wechat platform provides a lot of advanced interface for official account development, but all of them needs an access token. To gain the access token and utilise these advance interface, we need to create a WeChat instance first.
    
    WechatServiceProvider provider = new WechatServiceProvider(appid, secret);
    AccessGrant accessGrant = provider.getOAuthOperations().authenticateClient(null);
    Wechat wechat = provider.getApi(accessGrant.getAccessToken());
     

5 Send customer service message

    TBD.

6 Send group message

    TBD.

7 Send template message

    Define template message

	public class BalanceNotification
	{
	    private ValueColorPair first;
	    private ValueColorPair greeting;
	    private ValueColorPair date;
	    private ValueColorPair balance;
	    private ValueColorPair remark;
	
	    public ValueColorPair getFirst()
	    {
	        return first;
	    }
	
	    public void setFirst(ValueColorPair first)
	    {
	        this.first = first;
	    }
	
	    public ValueColorPair getGreeting()
	    {
	        return greeting;
	    }
	
	    public void setGreeting(ValueColorPair greeting)
	    {
	        this.greeting = greeting;
	    }
	
	    public ValueColorPair getRemark()
	    {
	        return remark;
	    }
	
	    public void setRemark(ValueColorPair remark)
	    {
	        this.remark = remark;
	    }
	
	    public ValueColorPair getDate()
	    {
	        return date;
	    }
	
	    public void setDate(ValueColorPair date)
	    {
	        this.date = date;
	    }
	
	    public ValueColorPair getBalance()
	    {
	        return balance;
	    }
	
	    public void setBalance(ValueColorPair balance)
	    {
	        this.balance = balance;
	    }
	}

    public void send(Calendar today, SimpleDateFormat format, String touser, String screenName)
    {
        BalanceNotification balanceNotification = new BalanceNotification();
        balanceNotification.setFirst(new ValueColorPair(String.format("Dear %s,", screenName), null));
        balanceNotification.setGreeting(new ValueColorPair(String.format("Portfolio balance for %s",
                "Edward"), null));
        balanceNotification.setDate(new ValueColorPair(format.format(today.getTime()), null));
        balanceNotification.setBalance(new ValueColorPair("+0.50", Color.Green));
     
        TemplateMessage<BalanceNotification> message = new TemplateMessage<BalanceNotification>();
        message.setTouser(touser);
        message.setTemplateId("xxxxxxxxxx");
        message.setData(balanceNotification);

        wechat.messageOperations().send(message);
    }
    