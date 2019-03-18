package auctionEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {

	private final String name;
	private final String id;

	public Item(String name, String id) {
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
		return "Name: " + name + " id: " + id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			Item item = (Item) obj;
			return item.getName().equals(name) && item.getId().equals(id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
