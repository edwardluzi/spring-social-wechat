package org.springframework.social.wechat.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Signature
{
	public static boolean check(String signature, String token, String timestamp, String nonce)
	{
		String[] tempArray = { token, timestamp, nonce };
		Arrays.sort(tempArray);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < tempArray.length; i++)
		{
			sb.append(tempArray[i]);
		}

		return sha1(sb.toString()).equalsIgnoreCase(signature);
	}

	private static String sha1(String str)
	{
		MessageDigest md = null;
		String sha1 = null;

		try
		{
			md = MessageDigest.getInstance("SHA-1");
			sha1 = bytes2HexString(md.digest(str.getBytes()));
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		return sha1;
	}

	private static String bytes2HexString(byte[] bytes)
	{
		StringBuffer sb = new StringBuffer(bytes.length * 2);

		for (int i = 0; i < bytes.length; i++)
		{
			sb.append(Character.forDigit((bytes[i] & 0xFF) >> 4, 16));
			sb.append(Character.forDigit(bytes[i] & 0x0F, 16));
		}

		return sb.toString().toLowerCase();
	}
}
