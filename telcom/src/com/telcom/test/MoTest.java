package com.telcom.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.telcom.bean.SmsMoMessage;
import com.telcom.service.MoService;

public class MoTest {
	
	private static  MoService moService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext atx = new ClassPathXmlApplicationContext("beans.xml");
		moService = (MoService) atx.getBean("moServiceImpl");
	}

	@Test
	public void test() {
		
		SmsMoMessage mo = new SmsMoMessage();
		mo.setLinkid("eeeeeeee");
		mo.setMessage("test info");
		mo.setSan("eee434");
		mo.setSenderAddress("3r3ssd");
		mo.setSmsServiceActivationNumber("werwe");
		mo.setSpId("32");
		mo.setSpRevId("weee");
		mo.setSpRevPassword("admin");
		mo.setTransactionId("温热儿童");
		moService.saveMoInfo(mo);
		
	}

}
