package com.telcom.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telcom.bean.OrderNow;
import com.telcom.bean.SmsMoMessage;
import com.telcom.bean.SmsMtMessage;
import com.telcom.pojo.Page;
import com.telcom.service.MoService;
@Transactional
@Service
public class MoServiceImpl implements MoService {

	@Resource
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveMoInfo(SmsMoMessage mo) 
	{
		sessionFactory.getCurrentSession().persist(mo);
	}
	
	
	@SuppressWarnings("unchecked")
	public Page queryMo(Page pager) 
	{
		List<SmsMoMessage> moList = new ArrayList<SmsMoMessage>();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbCount = new StringBuilder();
		sb.append(" from SmsMoMessage where 1=1 and dt > ? and dt <= ?");
		if(StringUtils.trimToNull((String) pager.getProps().get("telphone")) != null)
		{
			sb.append(" and senderAddress = '" + pager.getProps().get("telphone") + "' ");
		}
		if(StringUtils.trimToNull(pager.getOrderByName()) != null)
		{
			sb.append(" order by " + pager.getOrderByName() + " ");
			sb.append(pager.getOrderByValue());
		}
		
		System.out.println(sb.toString());
		moList = getSession().createQuery(sb.toString()).setTimestamp(0, Timestamp.valueOf(pager.getProps().get("startTime")))
				                                        .setTimestamp(1, Timestamp.valueOf(pager.getProps().get("endTime")))
				                                        .setFirstResult((pager.getPagerNo()-1)*pager.getPagerSize())
				                                        .setMaxResults(pager.getPagerSize()).list();
		
		sbCount.append("select count(*) ");
		sbCount.append(sb);
		Long size =(Long) getSession().createQuery(sbCount.toString()).setTimestamp(0, Timestamp.valueOf(pager.getProps().get("startTime")))
                                                                      .setTimestamp(1, Timestamp.valueOf(pager.getProps().get("endTime"))).uniqueResult();
		pager.setCount(size.intValue());
		pager.setList(moList);
		return pager;
	}
	
	@SuppressWarnings("unchecked")
	public Page queryMt(Page pager) 
	{
		List<SmsMtMessage> mtList = new ArrayList<SmsMtMessage>();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sbCount = new StringBuilder();
		sb.append(" from SmsMtMessage where 1=1 and dt > ? and dt <= ?");
		if(StringUtils.trimToNull((String) pager.getProps().get("telphone")) != null)
		{
			sb.append(" and addresses = '" + pager.getProps().get("telphone") + "' ");
		}
		if(StringUtils.trimToNull(pager.getOrderByName()) != null)
		{
			sb.append(" order by " + pager.getOrderByName() + " ");
			sb.append(pager.getOrderByValue());
		}
		
		System.out.println(sb.toString());
		mtList = getSession().createQuery(sb.toString()).setTimestamp(0, Timestamp.valueOf(pager.getProps().get("startTime")))
				                                        .setTimestamp(1, Timestamp.valueOf(pager.getProps().get("endTime")))
				                                        .setFirstResult((pager.getPagerNo()-1)*pager.getPagerSize())
				                                        .setMaxResults(pager.getPagerSize()).list();
		
		sbCount.append("select count(*) ");
		sbCount.append(sb);
		Long size =(Long) getSession().createQuery(sbCount.toString()).setTimestamp(0, Timestamp.valueOf(pager.getProps().get("startTime")))
                                                                      .setTimestamp(1, Timestamp.valueOf(pager.getProps().get("endTime"))).uniqueResult();
		pager.setCount(size.intValue());
		pager.setList(mtList);
		return pager;
	}
	
	
	@SuppressWarnings("unchecked")
	public Page queryBusiness(Page pager) 
	{
        List<OrderNow> mtList = new ArrayList<OrderNow>();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sbCount = new StringBuilder();
		sb.append(" from OrderNow where 1=1 and orderDate > ? and orderDate <= ?");
		if(StringUtils.trimToNull((String) pager.getProps().get("telphone")) != null)
		{
			sb.append(" and id.pn = '" + pager.getProps().get("telphone") + "' ");
		}
		if(StringUtils.trimToNull(pager.getOrderByName()) != null)
		{
			sb.append(" order by " + pager.getOrderByName() + " ");
			sb.append(pager.getOrderByValue());
		}
		
		System.out.println(sb.toString());
		try {
			
			mtList = getSession().createQuery(sb.toString()).setTimestamp(0, Timestamp.valueOf(pager.getProps().get("startTime")))
                    .setTimestamp(1, Timestamp.valueOf(pager.getProps().get("endTime")))
                    .setFirstResult((pager.getPagerNo()-1)*pager.getPagerSize())
                    .setMaxResults(pager.getPagerSize()).list();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		sbCount.append("select count(*) ");
		sbCount.append(sb);
		Long size =(Long) getSession().createQuery(sbCount.toString()).setTimestamp(0, Timestamp.valueOf(pager.getProps().get("startTime")))
                                                                      .setTimestamp(1, Timestamp.valueOf(pager.getProps().get("endTime"))).uniqueResult();
		pager.setCount(size.intValue());
		pager.setList(mtList);
		return pager;
	}
	

}
