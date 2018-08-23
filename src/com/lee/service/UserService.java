package com.lee.service;

import java.util.Map;

import com.lee.entity.AccountParams;

public interface UserService {
	/***
	 * 测试
	 * @param userName
	 * @return
	 */
	Map<String,Object> test(String userName);
	/***
	 * WLK 注册
	 * @param player
	 */
	Map<String,String> leeRegisterWlk(AccountParams player);
	/***
	 * 校验用户名是否存在
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);
	/***
	 * 校验email是否存在
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);
	
	/***
	 * 修改密码
	 * @param player
	 * @return
	 */
	Map<String,String> leeUpdatePwd(AccountParams player);
	/***
	 * 校验用户
	 * @param username
	 * @param password
	 * @return
	 */
	boolean checkUser(String username,String password);
	/***
	 * 校验用户
	 * @param username
	 * @param email
	 * @return
	 */
	boolean checkUserEmail(String username,String email);
	/***
	 * 找回密码
	 * @param player
	 * @return
	 */
	Map<String,String> leeRetrievePwd(AccountParams player);
}
