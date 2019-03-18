package auctionEngine;

import java.util.Objects;

public class Bid {

	private final User user;
	private final double value;

	public Bid(User user, double value) {
		this.user = user;
		this.value = value;
	}

	public Bid(User user, int value) {
		this.user = user;
		this.value = (double) value;
	}

	public User getUser() {
		return user;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "User: " + user + " BidValue: " + value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bid) {
			Bid bid = (Bid) obj;
			return bid.getUser() == user && bid.getValue() == value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, value);
	}


}
