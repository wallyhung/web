package com.telcom.util;

public class ExcelTypeConcert {
	
	
	/**
	 * 将numeric转换成String
	 * @param data
	 * @return
	 */
	public static String numericToString(double data){
		String dataS = String.valueOf(data);//将DOUBLE类型转换成String类型
		dataS = dataS.replace(".", "");		//去除"."
		dataS = dataS.substring(0, dataS.indexOf("E"));
		
		
		System.out.println(dataS);
 		return dataS;
 		
 		
	}
	
}
