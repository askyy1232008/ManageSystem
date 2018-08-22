package com.lee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.entity.AccountParams;
import com.lee.entity.Result;
import com.lee.service.UserService;
import com.lee.util.TransactSQLInjection;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	String basePath = System.getProperty("managementsystem-mysql");
	@Autowired
	private UserService userService;
	@Autowired
	private AccountParams accountParams;

	/**
	 * 测试
	 * 
	 * @param userName
	 * @return
	 */
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	@ResponseBody
//	public Object test(@RequestParam("userName") String userName) {
//		return Result.newSuccess(200, Result.getCodeMessage(200), userService.test(userName), "/user/test");
//	}
	// http://localhost:8080/ManageSystem/user/test?userName=user

	/***
	 * my wower register
	 * @param username
	 * @param password
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object registerWlk(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email) {
		if(username.trim().length() == 0 || password.trim().length() == 0 || email.trim().length() == 0){
			return Result.newSuccess(400, Result.getCodeMessage(400), null, "/user/register");
		}
		accountParams.setUsername(TransactSQLInjection.TransactSQLInjectionForMySystem(username.trim()));
		accountParams.setPassword(TransactSQLInjection.TransactSQLInjectionForMySystem(password.trim()));
		accountParams.setEmail(TransactSQLInjection.TransactSQLInjectionForMySystem(email.trim()));
		return Result.newSuccess(200, Result.getCodeMessage(200), userService.leeRegisterWlk(accountParams), "/user/register");
	}
}
