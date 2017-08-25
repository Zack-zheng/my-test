package com.zzz.frames.springJDBC.example1;

import java.util.List;

public interface UserManager {
	public void addUser(String name);

	public void updateUser(String name, int id);

	public void deleteUser(int id);

	public String getUser(int id);

	public User getUserByID(int id);

	public List getUsers();

	public List<User> getUserList();

	public void init();
}
