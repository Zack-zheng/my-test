package com.zzz.frames.springJDBC.example1;

import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring工具类
 * 
 * @author
 * 
 */
public class SpringUtil {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserManager um = (UserManager) SpringUtil.getBean("userManager");
		List<Map> users = um.getUsers();
		for (int i = 0; i < users.size(); i++) {
			String t_id = users.get(i).get("id").toString();
			String t_name = users.get(i).get("name").toString();
			System.out.println(t_id + "-" + t_name);
		}
	}

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"classpath:com/zzz/frames/springJDBC/example1/applicationContext.xml");

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
}