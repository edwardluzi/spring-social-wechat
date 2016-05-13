package org.springframework.social.wechat.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

public interface Wechat extends ApiBinding
{
	AccountOperations accountOperations();

	MessageOperations messageOperations();

	RestOperations restOperations();
}
