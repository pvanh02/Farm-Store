package nongsan.webmvc.controller.admin; 
 
import java.io.IOException; 
 
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
 
import java.util.List; 
import nongsan.webmvc.model.Admin; 
import nongsan.webmvc.model.Catalog; 
import nongsan.webmvc.service.AdminService; 
import nongsan.webmvc.service.impl.AdminServicesImpl; 
 
/** 
 * Servlet implementation class CategoryListController 
 */ 

public class AdminListController extends HttpServlet { 
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 
	AdminService adminService = new AdminServicesImpl(); 
 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Admin> adminList = adminService.getAll(); 
		req.setAttribute("adminlist", adminList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp"); 
		dispatcher.forward(req, resp); 
	} 
}