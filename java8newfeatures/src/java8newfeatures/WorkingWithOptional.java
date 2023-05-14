package java8newfeatures;

import java.util.Optional;

class User {
	private int id;
	
	public User(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}

public class WorkingWithOptional {

	public static void main(String[] args) {
		User user = new User(1);
		User user2 = new User(2);
		Optional<User> optional = Optional.empty();
		User elseif = optional.orElseGet(() -> user);
		
		System.out.println(elseif.getId());
	}

}
