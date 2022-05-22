package com.hrc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hrc.pojo.winter;

public class crud {
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/grey_goose";
		String user = "root";
		String pass = "Rahul@9298#";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ArrayList<winter> getData() {
		ArrayList<winter> ALLInvoice = new ArrayList<winter>();
		long doc_id;
		String business_code, clear_date, buisness_year, posting_date, document_create_date, document_create_date1,
				due_in_date, invoice_currency, baseline_create_date, cust_payment_terms;

		int sl_no, posting_id, cust_number, invoice_id;
		double total_open_amount;
		try {
			Connection conn = getConnection();
			String sql_query = "SELECT * from winter_internship";
			PreparedStatement pst = conn.prepareStatement(sql_query);
			// System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				winter w = new winter();
				sl_no = rs.getInt("sl_no");
				doc_id = rs.getLong("doc_id");
				posting_id = rs.getInt("posting_id");
				cust_number = rs.getInt("cust_number");
				invoice_id = rs.getInt("invoice_id");
				total_open_amount = rs.getDouble("total_open_amount");
				business_code = rs.getString("business_code");
				clear_date = rs.getString("clear_date");
				buisness_year = rs.getString("buisness_year");
				posting_date = rs.getString("posting_date");
				document_create_date = rs.getString("document_create_date");
				document_create_date1 = rs.getString("document_create_date1");
				due_in_date = rs.getString("due_in_date");
				invoice_currency = rs.getString("invoice_currency");
				baseline_create_date = rs.getString("baseline_create_date");
				cust_payment_terms = rs.getString("cust_payment_terms");
				w.setSl_no(sl_no);
				w.setDoc_id(doc_id);
				w.setPosting_id(posting_id);
				w.setCust_number(cust_number);
				w.setInvoice_id(invoice_id);
				w.setTotal_open_amount(total_open_amount);
				w.setBusiness_code(business_code);
				w.setClear_date(clear_date);
				w.setBuisness_year(buisness_year);
				w.setPosting_date(posting_date);
				w.setDocument_create_date(document_create_date);
				w.setDocument_create_date1(document_create_date1);
				w.setDue_in_date(due_in_date);
				w.setInvoice_currency(invoice_currency);
				w.setBaseline_create_date(baseline_create_date);
				w.setCust_payment_terms(cust_payment_terms);
				ALLInvoice.add(w);
			}
			for (winter stud : ALLInvoice) {
				System.out.println(stud.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		return ALLInvoice;
	}

}
