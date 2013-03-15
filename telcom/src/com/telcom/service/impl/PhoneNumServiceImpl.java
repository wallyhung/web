package com.telcom.service.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telcom.bean.PhoneNum;
import com.telcom.service.PhoneNumService;

@Transactional
@Service
public class PhoneNumServiceImpl implements PhoneNumService {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTel(PhoneNum num) {
		getSession().persist(num);
	}

}
