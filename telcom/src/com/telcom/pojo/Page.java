package com.telcom.pojo;

import java.util.List;
import java.util.Map;

import com.telcom.util.Constant;


public class Page 
{
	private int pagerNo	=1;									//	第几页
	private int count=0;									//  总数
	private int pagerSize=10;								//  每页size
	private int pagerTotal=0;								//	总页数
	private Map<String, String> props;						//查询属性集合
	private String orderByName;								//	排序名
	private String orderByValue=Constant.ORDER_DESC;		//	排序值
	@SuppressWarnings("rawtypes")
	private List list;	
	
	public Page() {
	}

	public int getPagerNo() {
		return pagerNo;
	}

	public void setPagerNo(int pagerNo) {
		this.pagerNo = pagerNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPagerSize() {
		return pagerSize;
	}

	public void setPagerSize(int pagerSize) {
		this.pagerSize = pagerSize;
	}

	public int getPagerTotal() {
		return pagerTotal;
	}

	public void setPagerTotal(int pagerTotal) {
		this.pagerTotal = pagerTotal;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	public String getOrderByName() {
		return orderByName;
	}

	public void setOrderByName(String orderByName) {
		this.orderByName = orderByName;
	}

	public String getOrderByValue() {
		return orderByValue;
	}

	public void setOrderByValue(String orderByValue) {
		this.orderByValue = orderByValue;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

}
