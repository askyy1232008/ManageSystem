package com.lee.util;

import org.springframework.stereotype.Component;

/**
 * 防SQL注入类
 * @author Administrator
 *
 */
@Component
public class TransactSQLInjection {
	/**  
	* 防止sql注入  
	*  
	* @param sql  
	* @return  
	*/ 
	public static String TransactSQLInjectionForMySystem(String s) {  
		return s.replaceAll(".*([';]+|(--)+).*", " ");
	} 
}
