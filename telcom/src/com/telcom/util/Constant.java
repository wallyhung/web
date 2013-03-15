package com.telcom.util;

public class Constant 
{
	/****************订单快运状态*****************/
	/**已收件**/
	public final static String STATUS_ORDER = "已收件";
	/**已入库**/
	public final static String STATUS_STORAGE = "已入库";
	/**分拣中**/
	public final static String STATUS_SORT = "分拣中";
	/**已出库**/
	public final static String STATUS_TO = "已出库";
	/**配送中**/
	public final static String STATUS_DELIVERY = "配送中";
	/**已送达**/
	public final static String STATUS_REACH = "已送达";
	/****************订单快运状态*****************/
	
	/**升序**/
	public final static String ORDER_DESC="desc";
	/**降序**/
	public final static String ORDER_ESC ="esc";
	
	/**保存到session中**/
	public final static String SESSION_NAME = "user_name";
	public final static String SESSION_ROLE = "user_role";
	public final static String SESSION_LASTLOGIN = "user_lastlogin";
	
	/**用户权限：查看**/
	public final static String ROLE_QUERY = "1";
	/**用户权限：修改**/
	public final static String ROLE_UPDATE = "2";
}
