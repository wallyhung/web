package com.telcom.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.telcom.pojo.Page;
import com.telcom.service.MoService;
import com.telcom.util.SystemUtil;
@Controller
@Scope("prototype")
public class QueryAction extends BaseAction
{

	private static final long serialVersionUID = -7325347617982633277L;
	
	@Resource
	private MoService moService;
	
//	private Page pager;
//	private Page mtPager;
	
	List<Page> paList;
	
	@Override
	public String execute() throws Exception 
	{
		String startTime = getParameter("startTime");
		String endTime = getParameter("endTime");
		if(StringUtils.trimToNull(startTime) == null)
		{
			startTime = "1900-01-01 00:00:00";
		}
		if(StringUtils.trimToNull(endTime) == null)
		{
			endTime = SystemUtil.getDateString(new Date());
		}
		String telphone = getParameter("telphone");
		String pagerNo = getParameter("pagerNo");
		String mtpagerNo = getParameter("mtpagerNo");
		String bupagerNo = getParameter("bupagerNo");
		
		Map<String , String> map = new HashMap<String, String>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("telphone", telphone);
		
		//创建上行分页器
		Page pager = new Page();
		pager.setOrderByName("dt");
		pager.setOrderByValue("desc");
		pager.setPagerNo(pagerNo==null?1:Integer.parseInt((pagerNo)));
		pager.setProps(map);
		pager = moService.queryMo(pager);
		
		//计算上行总页数
		int total = pager.getCount()%pager.getPagerSize() == 0 ? pager.getCount()/pager.getPagerSize()
				                                               : pager.getCount()/pager.getPagerSize()+1; 
		pager.setPagerTotal(total);
		
		//创建下行分页器
		Page mtPager = new Page();
		mtPager.setOrderByName("dt");
		mtPager.setOrderByValue("desc");
		mtPager.setPagerNo(mtpagerNo==null?1:Integer.parseInt((mtpagerNo)));
		mtPager.setProps(map);
		mtPager = moService.queryMt(mtPager);
		int mttotal = mtPager.getCount()%mtPager.getPagerSize() == 0 ? mtPager.getCount()/mtPager.getPagerSize()
                                                                     : mtPager.getCount()/mtPager.getPagerSize()+1; 
		mtPager.setPagerTotal(mttotal);
		
		
		//创建业务分页器
		Page buPager = new Page();
		buPager.setOrderByName("order_date");
		buPager.setOrderByValue("desc");
		buPager.setPagerNo(bupagerNo==null?1:Integer.parseInt((bupagerNo)));
		buPager.setProps(map);
		buPager = moService.queryBusiness(buPager);
		int butotal = buPager.getCount()%buPager.getPagerSize() == 0 ? buPager.getCount()/buPager.getPagerSize()
                                                                     : buPager.getCount()/buPager.getPagerSize()+1; 
		buPager.setPagerTotal(butotal);
		
		paList = new ArrayList<Page>();
		paList.add(pager);
		paList.add(mtPager);
		paList.add(buPager);
		
		return "jsondata";
	}


	public List<Page> getPaList() {
		return paList;
	}

}
