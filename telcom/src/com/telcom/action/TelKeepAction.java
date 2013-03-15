package com.telcom.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.telcom.bean.PhoneNum;
import com.telcom.service.PhoneNumService;

public class TelKeepAction extends BaseAction{
	
	private static final long serialVersionUID = -4232149092591336051L;
	@Resource
	private PhoneNumService numService;
	
	public String telKeepToDB(){
		String tels = getParameter("teltests");
		try {
		List<PhoneNum> list = stringToObject(tels);
		for (PhoneNum phoneNum : list) {
			numService.addTel(phoneNum);
		}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return SUCCESS;
	}
	
	/**
	 * 把一段字符串转换成List<Object>数组
	 * @param data
	 * @return
	 */
	public static List<PhoneNum> stringToObject(String data) throws Exception{
		List<PhoneNum> list = new ArrayList<PhoneNum>();
		
		String array[] = data.split("\\r\\n");
		for (String tel : array) {
			PhoneNum num = new PhoneNum(tel);
			list.add(num);
		}
 		return list;
 		
	}
}
