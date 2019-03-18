package auctionEngine;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BidTrackerImplementation implements BidTracker {

	private Map<Item, List<Bid>> auction;

	public BidTrackerImplementation() {
		this.auction = new ConcurrentHashMap<>();
	}

	@Override
	//Coarse implementation using sychronized if had more time would have made a fine implementation
	public synchronized void addBidOnItem(Bid bid, Item item) throws IllegalArgumentException {
		if (auction.get(item) == null) {
			List<Bid> bids = new ArrayList<>();
			bids.add(bid);
			auction.put(item, bids);
		}	else if (bid.getValue() > auction.get(item).get(auction.size() - 1).getValue()) {
			auction.get(item).add(bid);
		}
	}

	@Override
	//If there are no current bid then it is set to current winning bid is 0
	public Double getCurrentWinningBid(Item item) {
		if (auction.get(item) == null) {
			return 0.0;
		} else {
			List<Bid> bids = auction.get(item);
			return bids.get(bids.size() - 1).getValue();
		}
	}

	@Override
	public List<Bid> getItemBids(Item item) {
		return auction.get(item);
	}

	@Override
	//Goes through hashmap and checks every bid, returns a list of all items that have an associated bid by the user
	public List<Item> getUserBids(User user) {
		List<Item> userBids = new ArrayList<>();
		for (Item i : auction.keySet()) {
			for (Bid b : auction.get(i)) {
				if (b.getUser().equals(user) && !userBids.contains(i)) {
					userBids.add(i);
				}
			}
		}
		return userBids;
	}
}
