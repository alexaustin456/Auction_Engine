package auctionEngine;

import java.util.Objects;

public class User {

	private String name;
	private String id;

	public User(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Name: " + name + " Id: " + id;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			return id.equals(user.getId()) && name.equals(user.getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
