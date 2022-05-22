package com.hrc.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HashMap<Object, Object> Response = new HashMap<Object, Object>();
			int slNo = Integer.parseInt(request.getParameter("sl_no"));
			String invoiceCurrency = request.getParameter("invoice_currency");
			String customerPaymentTerms = request.getParameter("cust_payment_terms");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root",
					"Rahul@9298#");

			String sql = "UPDATE winter_internship SET invoice_currency = ?, cust_payment_terms = ? WHERE sl_no = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, invoiceCurrency);
			ps.setString(2, customerPaymentTerms);
			ps.setInt(3, slNo);

			ps.executeUpdate();

			Gson gson = new Gson();
			response.setHeader("Access-Control-Allow-Origin", "*");
			String Responsejson = gson.toJson(Response);
			response.getWriter().append(Responsejson);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
