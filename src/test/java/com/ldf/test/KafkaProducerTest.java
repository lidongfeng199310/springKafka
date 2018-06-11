
package com.ldf.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ldf.kafka.producer.KafkaProducerServer;

public class KafkaProducerTest {

	KafkaProducerServer kafkaProducer ;

	@Test
	public void testName() throws Exception {
		try {

			AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			kafkaProducer = applicationContext.getBean(KafkaProducerServer.class);
			String topic = "test";
			String value = "李东峰sss";
			String ifPartition = "1";
			Integer partitionNum = 3;
			String role = "test";//用来生成key
			Map<String,Object> res = kafkaProducer.sndMesForTemplate
					(topic, value, ifPartition, partitionNum, role);
			
			System.out.println("测试结果如下：===============");
			String message = (String)res.get("message");
			String code = (String)res.get("code");
			
			System.out.println("code:"+code);
			System.out.println("message:"+message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
