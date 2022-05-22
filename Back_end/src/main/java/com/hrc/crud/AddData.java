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

@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddData() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HashMap<Object, Object> Response = new HashMap<Object, Object>();

			String businessCode = request.getParameter("business_code");

			int custNumber = Integer.parseInt(request.getParameter("cust_number"));
			String clearDate = request.getParameter("clear_date");
			int businessYear = Integer.parseInt(request.getParameter("buisness_year"));
			long docId = Long.parseLong(request.getParameter("doc_id"));
			String postingDate = request.getParameter("posting_date");
			String documentCreateDate = request.getParameter("document_create_date");
			String dueInDate = request.getParameter("due_in_date");
			String invoiceCurrency = request.getParameter("invoice_currency");
			String documentType = request.getParameter("document_type");
			int postingId = Integer.parseInt(request.getParameter("posting_id"));
			double totalOpenAmount = Double.parseDouble(request.getParameter("total_open_amount"));
			String baselineCreateDate = request.getParameter("baseline_create_date");
			String customerPaymentTerms = request.getParameter("customer_payment_terms");
			int invoiceId = Integer.parseInt(request.getParameter("invoice_id"));

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root",
					"Rahul@9298#");
			String sql = "INSERT INTO winter_internship(business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, businessCode);
			ps.setInt(2, custNumber);
			ps.setString(3, clearDate);
			ps.setInt(4, businessYear);
			ps.setLong(5, docId);
			ps.setString(6, postingDate);
			ps.setString(7, documentCreateDate);
			ps.setString(8, dueInDate);
			ps.setString(9, invoiceCurrency);
			ps.setString(10, documentType);
			ps.setInt(11, postingId);
			ps.setDouble(12, totalOpenAmount);
			ps.setString(13, baselineCreateDate);
			ps.setString(14, customerPaymentTerms);
			ps.setInt(15, invoiceId);

			ps.executeUpdate();
			Gson gson = new Gson();
			String JSONresponse = gson.toJson(Response);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(JSONresponse);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
