package com.frames.springJDBC.example1;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/frames/springJDBC/example1/applicationContext.xml");
		UserManager um = (UserManager) ctx.getBean("userManager");

		// UserManager um = (UserManager) SpringUtil.getBean("userManager");
		// 新增
		/*
		 * String name="test"; um.addUser(name);
		 */
		// 列表
		List<Map> users = um.getUsers();
		for (int i = 0; i < users.size(); i++) {
			String t_id = users.get(i).get("id").toString();
			String t_name = users.get(i).get("name").toString();
			System.out.println(t_id + "-" + t_name);
		}
		// 修改
		// um.updateUser("test6", 6);
		// 删除
		// um.deleteUser(1);
		// 获取某个字段
		// String name2=um.getUser(2);
		// System.out.println(name2+"-"+name2);
		// 获取对象列表
		List<User> users2 = um.getUserList();
		for (int i = 0; i < users2.size(); i++) {
			Long t_id2 = users2.get(i).getId();
			String t_name2 = users2.get(i).getName();
			System.out.println(t_id2 + "-" + t_name2);
		}
		// 获取对象
		User u = um.getUserByID(2);
		System.out.println(u.getId() + "-" + u.getName());
	}
}