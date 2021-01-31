package review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.dao.MyBatisMaker;
import review.domain.Review;

public class ReviewDAO {

	private static final String NAMESPACE = "review.dao.ReviewMapper";

	public List<Review> getAll(Long sno)throws Exception {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getAll", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void deleteAllReview(Long sno) throws Exception {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
		
			session.delete(NAMESPACE + ".deleteAllReview",sno);
		
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}