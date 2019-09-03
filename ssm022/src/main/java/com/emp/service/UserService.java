package com.emp.service;

import java.util.Set;

import com.emp.entity.User;

public interface UserService {
	//ͨ���û��������û�
	public User getByUserName(String username);
	//����û�(ע��ʹ��)
	void addUser(User user);
	//ͨ���û������Ҹ��û����еĽ�ɫ��������Set������
	public Set<String> getRoles(String username);
	//ͨ���û������Ҹ��û����е�Ȩ�޲�������Set������
	public Set<String> getPermissions(String username);
}
