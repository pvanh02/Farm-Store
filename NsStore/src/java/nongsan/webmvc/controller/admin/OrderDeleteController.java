package nongsan.webmvc.controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import nongsan.webmvc.service.TransactionService;
import nongsan.webmvc.service.impl.TransactionServicesImpl;


public class OrderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionService transactionService =  new TransactionServicesImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		transactionService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/order/list");
	}
}
