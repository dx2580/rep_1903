package com.emp.service.imp;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.emp.dao.UserDao;
import com.emp.entity.User;
import com.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	//注入dao对象
	@Resource
	private UserDao userDao;
	
	@Override
	public User getByUserName(String username) {
		return userDao.getByUserName(username);
	}

	@Override
	public Set<String> getRoles(String username) {
		return userDao.getRoles(username);
	}

	@Override
	public Set<String> getPermissions(String username) {
		return userDao.getPermissions(username);
	}

	@Override
	public void addUser(User user) {
		//加盐,加密的效果
		//MD5
		//算法   需要加密的密码   盐   加密的次数
		String password = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
		//password就是加密后的密码
		//用户加密后的密码置换原来从页面传来的密码
		user.setPassword(password);
		//将user保存到数据中
		userDao.save(user);
	}

}
