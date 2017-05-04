
package com.ja0ck5.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ja0ck5.entity.Mail;


@Service
public class MQProducer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final Mail mail) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(mail));
			}
		});
	}

}
