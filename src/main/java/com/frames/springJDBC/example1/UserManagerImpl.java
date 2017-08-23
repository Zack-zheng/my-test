package com.frames.springJDBC.example1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

public class UserManagerImpl implements UserManager {
	private DAO dao;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public void addUser(String name) {
		/*
		 * String sql="insert into t_test(name) values('"+name+"')";
		 * dao.update(sql);
		 */
		String sql = "insert into t_test(name) values(?)";
		Object[] params = new Object[] { name };
		dao.update(sql, params);
	}

	public List getUsers() {
		String sql = "select * FROM t_test";
		List<Map> lists = dao.getResult(sql);
		return lists;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public void updateUser(String name, int id) {
		/*
		 * String sql="update t_test set name='"+name+"' where id="+id;
		 * dao.update(sql);
		 */
		/*
		 * String sql="update t_test set name=? where id="+id; Object[] params =
		 * new Object[] {name};
		 */
		String sql = "update t_test set name=? where id=?";
		Object[] params = new Object[] { name, new Integer(id) };
		dao.update(sql, params);
	}

	public void deleteUser(int id) {
		String sql = "delete from t_test where id=" + id;
		dao.delete(sql);
	}

	public String getUser(int id) {
		// TODO Auto-generated method stub
		String sql = "select name from t_test where id=" + id;
		String name = dao.getResultValue(sql, "name");
		return name;
	}

	public User getUserByID(int id) {
		User user = null;
		String sql = "select id,name from t_test where id=" + id;
		List<Map> lists = dao.getResult(sql);
		if (lists.size() > 0) {
			user = new User();
			Map map = lists.get(0);
			user.setId((Long) map.get("id"));
			user.setName((String) map.get("name"));
		}
		return user;
	}

	public List<User> getUserList() {
		String sql = "select * FROM t_test";
		List<Map> lists = dao.getResult(sql);
		List<User> users = new ArrayList<User>();
		if (lists.size() > 0) {
			for (int i = 0; i < lists.size(); i++) {
				User user = new User();
				Map map = lists.get(i);
				user.setId((Long) map.get("id"));
				user.setName((String) map.get("name"));
				users.add(user);
			}
		}
		return users;
	}
}