package com.hcl.hibernate.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.hibernate.dao.ProductDao;
import com.hcl.hibernate.model.Product;


public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;

	@Override
	public void init() {
		productDao = new ProductDao();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		addProduct(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("addProduct.jsp");
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String product = request.getParameter("product");
		String quantity = request.getParameter("quantity");

		Product products = new Product();
		products.setProduct(product);
		products.setQuantity(quantity);

		productDao.saveProduct(products);

		RequestDispatcher dispatcher = request.getRequestDispatcher("add-success.jsp");
		dispatcher.forward(request, response);
	}
}
