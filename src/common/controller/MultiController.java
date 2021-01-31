package common.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleController
 */

public abstract class MultiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected Map<String, Method> methodMap;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiController() {
        super();
        
        methodMap = new HashMap<>();
        
        Method[] methods = this.getClass().getDeclaredMethods();
        
        for (Method method : methods) {
			methodMap.put(method.getName(), method);
		}
        
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SampleController run............");
	
		String path = request.getPathInfo().substring(1);
		System.out.println(path);
		String method = request.getMethod();
		System.out.println(method);
		
		String oper = path+method;
		
		String dest = null;
		
		Method targetMethod = methodMap.get(oper);
		
		if(targetMethod != null) {
			try {
				dest = (String)targetMethod.invoke(this, request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(dest != null && dest.startsWith("re:")) {
			response.sendRedirect(dest.substring(3));
		}else {
			request.getRequestDispatcher("/WEB-INF/"+dest+".jsp").forward(request, response);
		}
	}
	



}



















