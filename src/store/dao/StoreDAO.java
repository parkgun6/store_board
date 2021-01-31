package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.dao.MyBatisMaker;
import store.domain.Store;

public class StoreDAO {

	private static final String NAMESPACE = "store.dao.StoreMapper";
	
	public List<Store> getAll() {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			return session.selectList(NAMESPACE + ".getAll");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Store getOne(Long sno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getOne", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertStore(Store store) throws Exception {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			session.insert(NAMESPACE + ".insertStore",store);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStore(Long sno) throws Exception {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
		
			session.delete(NAMESPACE + ".deleteStore",sno);
		
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void updateStore(Store store) throws Exception {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			session.update(NAMESPACE + ".updateStore",store);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
