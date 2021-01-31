package store.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.controller.MultiController;
import review.dao.ReviewDAO;
import review.domain.Review;
import store.dao.StoreDAO;
import store.domain.Store;

@WebServlet("/store/*")
public class StoreController extends MultiController {
	
	private StoreDAO storeDAO = new StoreDAO();
	private ReviewDAO reviewDAO = new ReviewDAO();
	
	public String listGET(HttpServletRequest req, 
			HttpServletResponse res)throws Exception{
		
		List<Store> stores = storeDAO.getAll();
		System.out.println(stores);
		req.setAttribute("stores", stores);
		
		return "store/list";
		
	}

	public String viewGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));
		
		Store store = storeDAO.getOne(sno);	
		List<Review> reviewList = reviewDAO.getAll(sno);
		
		request.setAttribute("reviews", reviewList);
		request.setAttribute("store", store);
		return "store/view";
	}

	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		return "store/register";
	}

	public String registerPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String menu = request.getParameter("menu");
		
		Store store = Store.builder().name(name).lat(lat).lng(lng).menu(menu).build();

		storeDAO.insertStore(store);
		return "re:list";
	}

	public String modifyGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));

		Store store = storeDAO.getOne(sno);
		request.setAttribute("store", store);
		return "store/modify";
	}

	public String modifyPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long sno = Long.parseLong(request.getParameter("sno"));
		String name = request.getParameter("name");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String menu = request.getParameter("menu");
		Store store = Store.builder().sno(sno).name(name).lat(lat).lng(lng).menu(menu).build();
		
		storeDAO.updateStore(store);
		
		return "re:view?sno="+sno;
	}

	public String removePOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));		
		storeDAO.deleteStore(sno);


		return "re:list";
	}
	
	public String removeReviewPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));		
		reviewDAO.deleteAllReview(sno);
		
		
		return "re:view?sno="+sno;
	}
}
