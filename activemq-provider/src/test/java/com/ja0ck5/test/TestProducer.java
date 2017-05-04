package com.ja0ck5.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ja0ck5.entity.Mail;
import com.ja0ck5.mq.MQProducer;



@ContextConfiguration(locations = {"classpath:spring-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProducer {
	
	@Autowired
	private MQProducer mqProducer;
	
	@Test
	public void send(){
		Mail mail = new Mail();
		mail.setTo("975117619@qq.com");
		mail.setSubject("异步发送邮件");
		mail.setContent("Hi,This is a message!");
														
		this.mqProducer.sendMessage(mail);
		System.out.println("发送成功..");		
		
	}

}
