package review.dao.test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import review.dao.ReviewDAO;
import review.domain.Review;
import store.domain.Store;

public class ReviewDAOTests {
	ReviewDAO dao;
	
	@Before
	public void ready() {
		dao = new ReviewDAO();
	}
	
	@Test
	public void testGetAll() throws Exception {
		
		List<Review> stores = dao.getAll(9L);
		
		System.out.println(stores);
	}
	
}

