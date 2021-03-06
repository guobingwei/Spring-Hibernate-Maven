package com.dm.yc.std.study.designpattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * Created by weiguobing on 2021-02-14.   11:26
 * email : weiguobing@meituan.com
 */
public class SmsServiceImpl implements SmsService {

	@Override
	public String send(String message) {
		System.out.println("send message:" + message);
		return message;
	}

	public static void main(String[] args) {
		SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
		smsService.send("java");
	}
}
