package com.telcom.service;

import com.telcom.bean.SmsMoMessage;
import com.telcom.pojo.Page;

public interface MoService 
{
	/**
	 * 保存信息
	 * @param mo
	 */
	void saveMoInfo(SmsMoMessage mo);
	
	/**
	 * 根据分页数据获取查询的上行列表
	 * @param pager
	 * @return
	 */
	Page queryMo(Page pager);
	
	
	/**
	 * 根据分页数据获取查询的下行列表
	 * @param pager
	 * @return
	 */
	Page queryMt(Page pager);
	

	/**
	 * 根据分页数据获取查询的业务列表
	 * @param pager
	 * @return
	 */
	Page queryBusiness(Page pager);
	
	
	
	

}
