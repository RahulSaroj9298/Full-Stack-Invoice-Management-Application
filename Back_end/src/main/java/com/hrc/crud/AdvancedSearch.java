package com.hrc.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrc.pojo.winter;

@WebServlet("/AdvancedSearch")
public class AdvancedSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		response.setCharacterEncoding("UTF-8");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root",
					"Rahul@9298#");

			long docId = Long.parseLong(request.getParameter("doc_id"));
			String custNumberInURL = request.getParameter("cust_number");
			int custNumber = Integer.parseInt(custNumberInURL);
			String invoiceIdInURL = request.getParameter("invoice_id");
			int invoiceId = Integer.parseInt(invoiceIdInURL);
			String businessYear = request.getParameter("buisness_year");

			String query = "SELECT * FROM `grey_goose`.`winter_internship` WHERE doc_id LIKE '%" + docId + "%'"
					+ " AND cust_number LIKE '%" + custNumber + "%'" + " AND invoice_id LIKE '%" + invoiceId + "%'"
					+ " AND buisness_year LIKE '%" + businessYear + "%'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			ArrayList<winter> data = new ArrayList<winter>();
			while (rs.next()) {
				winter w = new winter();
				w.setSl_no(rs.getInt("sl_no"));
				w.setBusiness_code(rs.getString("business_code"));
				w.setCust_number(rs.getInt("cust_number"));
				w.setClear_date(rs.getString("clear_date"));
				w.setBuisness_year(rs.getString("buisness_year"));
				w.setDoc_id(rs.getLong("doc_id"));
				w.setPosting_date(rs.getString("posting_date"));
				w.setDocument_create_date(rs.getString("document_create_date"));
				w.setDue_in_date(rs.getString("due_in_date"));
				w.setInvoice_currency(rs.getString("invoice_currency"));
				w.setDocument_create_date(rs.getString("document_type"));
				w.setPosting_id(rs.getInt("posting_id"));
				w.setTotal_open_amount(rs.getDouble("total_open_amount"));
				w.setBaseline_create_date(rs.getString("baseline_create_date"));
				w.setCust_payment_terms(rs.getString("cust_payment_terms"));
				w.setInvoice_id(rs.getInt("invoice_id"));

				data.add(w);

			}
			Gson gson = new GsonBuilder().serializeNulls().create();
			String invoices = gson.toJson(data);
			try {
				response.getWriter().write(invoices);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

	}
}
