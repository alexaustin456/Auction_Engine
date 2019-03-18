package auctionEngine;

import java.util.List;

public interface BidTracker {

	void addBidOnItem(Bid bid, Item item) throws IllegalArgumentException;

	Double getCurrentWinningBid(Item item);

	List<Bid> getItemBids(Item item);

	List<Item> getUserBids(User user);
}
