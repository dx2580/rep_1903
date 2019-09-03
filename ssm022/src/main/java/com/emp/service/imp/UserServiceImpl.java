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
	//ע��dao����
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
		//����,���ܵ�Ч��
		//MD5
		//�㷨   ��Ҫ���ܵ�����   ��   ���ܵĴ���
		String password = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
		//password���Ǽ��ܺ������
		//�û����ܺ�������û�ԭ����ҳ�洫��������
		user.setPassword(password);
		//��user���浽������
		userDao.save(user);
	}

}
