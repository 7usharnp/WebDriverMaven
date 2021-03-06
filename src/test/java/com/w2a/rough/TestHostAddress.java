package com.w2a.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;

public class TestHostAddress {
	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
		
		MonitoringMail mail= new MonitoringMail();
		String messageBody="http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/job/DataDrivenFramework/HTML_20Report/";
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody);
		System.out.println(messageBody);
	}

}
