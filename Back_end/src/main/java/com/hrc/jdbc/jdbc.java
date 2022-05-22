package com.hrc.jdbc;

import java.sql.*;

public class jdbc {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/grey_goose";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "Rahul@9298#";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT sl_no,doc_id,posting_id,cust_number,invoice_id,total_open_amount,business_code,clear_date,buisness_year,posting_date,document_create_date,document_create_date1,due_in_date,invoice_currency,baseline_create_date,cust_payment_terms FROM winter_internship LIMIT 0,50";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {

				// Retrieve by column name

				int sl_no = rs.getInt("sl_no");
				long doc_id = rs.getLong("doc_id");
				int posting_id = rs.getInt("posting_id");
				int cust_number = rs.getInt("cust_number");
				int invoice_id = rs.getInt("invoice_id");
				double total_open_amount = rs.getDouble("total_open_amount");
				String business_code = rs.getString("business_code");
				String clear_date = rs.getString("clear_date");
				String buisness_year = rs.getString("buisness_year");
				String posting_date = rs.getString("posting_date");
				String document_create_date = rs.getString("document_create_date");
				String document_create_date1 = rs.getString("document_create_date1");
				String due_in_date = rs.getString("due_in_date");
				String invoice_currency = rs.getString("invoice_currency");
				String baseline_create_date = rs.getString("baseline_create_date");
				String cust_payment_terms = rs.getString("cust_payment_terms");

				// Display values

				System.out.print("Sl_No: " + sl_no);
				System.out.print(",doc_id : " + doc_id);
				System.out.print(",posting_id : " + posting_id);
				System.out.print(",cust_number : " + cust_number);
				System.out.print(",invoice_id : " + invoice_id);
				System.out.print(",total_open_amount : " + total_open_amount);
				System.out.print(",business_code : " + business_code);
				System.out.print(",clear_date : " + clear_date);
				System.out.print(",buisness_year : " + buisness_year);
				System.out.print(",posting_date : " + posting_date);
				System.out.print(",document_create_date : " + document_create_date);
				System.out.print(",document_create_date1 : " + document_create_date1);
				System.out.print(",due_in_date : " + due_in_date);
				System.out.print(",invoice_currency : " + invoice_currency);
				System.out.print(",baseline_create_date : " + baseline_create_date);
				System.out.print(",cust_payment_terms : " + cust_payment_terms);
			}
			// STEP 6: Clean-up environment

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
