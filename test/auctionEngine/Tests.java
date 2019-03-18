package auctionEngine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Tests {
	private BidTrackerImplementation bidTracker = new BidTrackerImplementation();

	private User user = new User("user1", "1");
	private User user1 = new User("user2", "2");

	private Item item = new Item("item1", "1");
	private Item item1 = new Item("item2", "2");
	private Item item2 = new Item("item3", "3");

	private Bid bid = new Bid(user, 1);
	private Bid bid1 = new Bid(user1, 2);
	private Bid bid2 = new Bid(user, 0.5);



	@Test
	public void test1() {
		//Testing user making a bid
		bidTracker.addBidOnItem(bid, item);
		double bidValue = bidTracker.getCurrentWinningBid(item);
		assertEquals(1, bidValue, 0);
	}

	@Test
	public void test2() {
		//Testing whether the current winning bid is updated when second user makes valid bid
		bidTracker.addBidOnItem(bid, item);
		bidTracker.addBidOnItem(bid1, item);

		double bidValue = bidTracker.getCurrentWinningBid(item);
		assertEquals(2, bidValue, 0);
	}

	@Test
	public void test3() {
		//Testing whether the current bid remain as before if invalid bid (less than previous) is placed
		bidTracker.addBidOnItem(bid1, item);
		bidTracker.addBidOnItem(bid2, item);

		double bidValue = bidTracker.getCurrentWinningBid(item);
		assertEquals(2, bidValue, 0);
	}

	@Test
	public void test4() {
		//Test whether getUserBids works correctly
		bidTracker.addBidOnItem(bid, item);
		bidTracker.addBidOnItem(bid2, item1);
		bidTracker.addBidOnItem(bid1, item2);

		assertTrue(bidTracker.getUserBids(user).contains(item));
		assertTrue(bidTracker.getUserBids(user).contains(item1));
		assertFalse(bidTracker.getUserBids(user).contains(item2));
	}

	@Test
	public void test5() {
		//Test whether getItemsBids works as required
		bidTracker.addBidOnItem(bid2, item);
		bidTracker.addBidOnItem(bid, item);
		bidTracker.addBidOnItem(bid1, item);

		assertTrue(bidTracker.getItemBids(item).contains(bid2));
		assertTrue(bidTracker.getItemBids(item).contains(bid));
		assertTrue(bidTracker.getItemBids(item).contains(bid1));
	}






}
