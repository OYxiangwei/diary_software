package main.java.util;

import main.java.entity.User;

public class Register {
	static User user = new User();

	public static String checkName(String name) {
		user.setName(name);
		return null;
	}

	public static String checkId(String id) {
		if (id.matches("\\d{1,6}")) {
			user.setId(id);
			return null;
		}
		return "ID not conform to the rules";
	}

	public static String checkPasswd(String password) {
		if (password.matches("\\d{6,15}")) {
			user.setPassword(password);
			return null;
		}
		return "Password not conform to the rules";
	}

	public static String register(String id, String name, String password) {
		user.setName(name);
		user.setPassword(password);
		user.setId(id);
		return (JDOM.write(user.getId(), user.getName(), user.getPassword()));
	}
}
