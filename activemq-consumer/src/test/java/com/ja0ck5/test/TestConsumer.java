
package com.ja0ck5.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsumer {

	@Test
	public void testContext() throws Exception {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-context.xml" });
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
