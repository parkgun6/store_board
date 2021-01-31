package store.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import common.dao.MyBatisMaker;
import store.dao.StoreDAO;
import store.domain.Store;

public class StoreDAOTests {

	private StoreDAO dao;
	
	@Before
	public void ready() {
		dao = new StoreDAO();
	}
	
	@Test
	public void testSqlSessionFactory() {
		
		System.out.println(MyBatisMaker.INSTANCE.getFactory().openSession());
		
	}
	
	@Test
	public void testGetAll() {
		
		List<Store> stores = dao.getAll();
		
		System.out.println(stores);
	}
	
	@Test
	public void testGetOne() {
		
		Store store = dao.getOne(1L);
		
		System.out.println(store);
	}
	

	
}









