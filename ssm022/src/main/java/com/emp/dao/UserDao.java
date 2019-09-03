package com.emp.dao;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.emp.entity.User;

public interface UserDao {
	//通过用户名查找用户
	@Select("select id,username,password from sh_user "
			+ " where username=#{username}")
	public User getByUserName(@Param("username")String username);
	//注册
	//添加用户
	@Insert("insert into sh_user(username,password) values(#{username},#{password})")
	void save(User user);
	//通过用户名查询用户所有的角色
	//返回值类型是Shiro框架定义的
	@Select("select r.rolename from sh_user u inner join sh_user_role ur on u.id=ur.user_id "
			+ "inner join sh_role r on ur.role_id=r.id where u.username=#{username}")
	public Set<String> getRoles(@Param("username")String username);
	
	//通过用户名查找该用户所有的权限并保存在Set集合中
	@Select("select DISTINCT p.permission_name from sh_user u inner join "
			+ " sh_user_role ur on u.id = ur.user_id inner join sh_role r "
			+ " on ur.role_id = r.id inner join  sh_role_permission rp "
			+ " on r.id = rp.role_id inner join sh_permission p "
			+ " on rp.permission_id = p.id where u.username=#{username}")
	public Set<String> getPermissions(@Param("username")String username);

}
