package com.lee.service.impl;

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
			jdbcTemplate.update(sql);
			m.put("result", "注册成功!");
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
}
