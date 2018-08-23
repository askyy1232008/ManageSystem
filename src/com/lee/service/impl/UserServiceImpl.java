package com.lee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lee.dao.BaseDao;
import com.lee.entity.AccountParams;
import com.lee.service.UserService;
import com.lee.util.RedisUtil;
import com.lee.util.SendMailUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> test(String userName) {
		Map<String,Object> m = new HashMap<String,Object>();
//		redisUtil.set("userName", userName, 30L);
//		Object name = redisUtil.get("userName");
//		redisUtil.del("userName");
		if(!userName.equals("user"))   userName = "user";
		List<Object> list= baseDao.list(" from User where userName ='"+userName+"'");
//		List<Object> list= baseDao.list(" from UserDataInfo where userName ='"+userName+"'");
//		List<Map<String, Object>>  list= jdbcTemplate.queryForList("select * from user_data_info where LINKMAN ='"+userName+"'");
		m.put("condition", userName);
		m.put("user", list.get(0));
		return m;
	}

	@Override
	public Map<String,String> leeRegisterWlk(AccountParams player) {
		Map<String,String> m = new HashMap<String,String>();
		boolean checkU = checkUsername(player.getUsername());
		boolean checkE = checkEmail(player.getEmail());
		if(!checkU && !checkE){
			String username = player.getUsername();
			String password = player.getPassword();
			String email = player.getEmail();
			String sql = "INSERT INTO `account` (username, sha_pass_hash, email, password, expansion) VALUES (UPPER('"+ username +"'), SHA1(CONCAT(UPPER('"+ username +"'),':',UPPER('"+ password +"'))),'"+ email +"', UPPER('"+ password +"'),'4')";
			Integer i = jdbcTemplate.update(sql);
			if(i>0){
				m.put("result", "注册成功!");
			}else{
				m.put("result", "数据新增失败!");
			}
		}else{
			m.put("result", "用户名或email已存在!");
		}
		return m;
	}

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from `account` where username = ?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[]{ username }, Integer.class);
		if(count>0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from `account` where email = ?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[]{ email }, Integer.class);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Map<String, String> leeUpdatePwd(AccountParams player) {
		// TODO Auto-generated method stub
		Map<String,String> m = new HashMap<String,String>();
		String username = player.getUsername();
		String oldPwd = player.getOldPwd();
		String newPwd = player.getNewPwd();
		boolean checkuser = checkUser(username,oldPwd);
		if(checkuser){
			String sql = "update `account` set `sha_pass_hash`=SHA1(CONCAT(UPPER('"+ username +"'),':',UPPER('"+ newPwd +"'))),v=0, s=0,`password`='"+ newPwd +"'  where `username`='"+ username +"' and `password`='"+ oldPwd +"'";
			Integer i = jdbcTemplate.update(sql);
			if(i>0){
				m.put("result", "修改密码成功!");
			}else{
				m.put("result", "数据更新失败!");
			}
		}else{
			m.put("result", "用户名或密码错误!");
		}
		return m;
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from `account` where ");
		sql.append(" username = ? ");
		params.add(username);
		sql.append(" and password = ? ");
		params.add(password);
		Object[] para = params.toArray(new Object[params.size()]);
		Integer count = jdbcTemplate.queryForObject(sql.toString(), para, Integer.class);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean checkUserEmail(String username, String email) {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from `account` where ");
		sql.append(" username = ? ");
		params.add(username);
		sql.append(" and email = ? ");
		params.add(email);
		Object[] para = params.toArray(new Object[params.size()]);
		Integer count = jdbcTemplate.queryForObject(sql.toString(), para, Integer.class);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Map<String, String> leeRetrievePwd(AccountParams player) {
		// TODO Auto-generated method stub
		Map<String,String> m = new HashMap<String,String>();
		String username = player.getUsername();
		String email = player.getEmail();
		String newPwd = player.getNewPwd();
		boolean checkuser = checkUserEmail(username,email);
		if(checkuser){
			String sql = "update `account` set `sha_pass_hash`=SHA1(CONCAT(UPPER('"+ username +"'),':',UPPER('"+ newPwd +"'))),v=0, s=0,`password`='"+ newPwd +"'  where `username`='"+ username +"' and `email`='"+ email +"'";
			Integer i = jdbcTemplate.update(sql);
			if(i>0){
				SendMailUtil.send(email, "wow密码重置", "重置后的新密码为:"+newPwd, "smtp", "smtp.163.com", "b504861378@163.com", "", "b504861378", "*************");
				m.put("result", "找回密码成功，请查看您的邮箱!");
			}else{
				m.put("result", "数据更新失败!");
			}
		}else{
			m.put("result", "用户名或邮箱错误!");
		}
		return m;
	}
}
