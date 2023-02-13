package kilenc.control;

import java.util.regex.Pattern;

import kilenc.dao.UserDao;
import kilenc.model.User;

public class ControlUser {

	private UserDao ud;
	private User user;
	
	public ControlUser() {
		ud = new UserDao();
	}
	
	public void registerUser(String name, String email, String password) {
		user = new User(name, email, password);
		ud.saveUser(user);
		
	}
	
	public boolean validateEmail(String email) {
		
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		
		Pattern pattern = Pattern.compile(regex);
		
		return pattern.matcher(email).matches();
		
	}
	
	public boolean login(String name, String password) {		
		for (User u : ud.listAllUsers()) {
			if (u.getName().equals(name) && u.getPassword().equals(password))
				return true;
		}
		
		return false;
	}
	
}
