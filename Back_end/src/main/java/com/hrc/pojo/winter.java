package com.hrc.pojo;

public class winter {
	private int sl_no;
	private long doc_id;
	private int posting_id;
	private int cust_number;
	private int invoice_id;
	private double total_open_amount;
	private String business_code;
	private String clear_date;
	private String buisness_year;
	private String posting_date;
	private String document_create_date;
	private String document_create_date1;
	private String due_in_date;
	private String invoice_currency;
	private String baseline_create_date;
	private String cust_payment_terms;

	public int getSl_no() {
		return sl_no;
	}

	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}

	public long getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(long doc_id) {
		this.doc_id = doc_id;
	}

	public int getPosting_id() {
		return posting_id;
	}

	public void setPosting_id(int posting_id) {
		this.posting_id = posting_id;
	}

	public int getCust_number() {
		return cust_number;
	}

	public void setCust_number(int cust_number) {
		this.cust_number = cust_number;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public double getTotal_open_amount() {
		return total_open_amount;
	}

	public void setTotal_open_amount(double total_open_amount) {
		this.total_open_amount = total_open_amount;
	}

	public String getBusiness_code() {
		return business_code;
	}

	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}

	public String getClear_date() {
		return clear_date;
	}

	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}

	public String getBuisness_year() {
		return buisness_year;
	}

	public void setBuisness_year(String buisness_year) {
		this.buisness_year = buisness_year;
	}

	public String getPosting_date() {
		return posting_date;
	}

	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}

	public String getDocument_create_date() {
		return document_create_date;
	}

	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}

	public String getDocument_create_date1() {
		return document_create_date1;
	}

	public void setDocument_create_date1(String document_create_date1) {
		this.document_create_date1 = document_create_date1;
	}

	public String getDue_in_date() {
		return due_in_date;
	}

	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}

	public String getInvoice_currency() {
		return invoice_currency;
	}

	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}

	public String getBaseline_create_date() {
		return baseline_create_date;
	}

	public void setBaseline_create_date(String baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}

	public String getCust_payment_terms() {
		return cust_payment_terms;
	}

	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}

	@Override
	public String toString() {
		return "winter [sl_no=" + sl_no + ", doc_id=" + doc_id + ", posting_id=" + posting_id + ", cust_number="
				+ cust_number + ", invoice_id=" + invoice_id + ", total_open_amount=" + total_open_amount
				+ ", business_code=" + business_code + ", clear_date=" + clear_date + ", buisness_year=" + buisness_year
				+ ", posting_date=" + posting_date + ", document_create_date=" + document_create_date
				+ ", document_create_date1=" + document_create_date1 + ", due_in_date=" + due_in_date
				+ ", invoice_currency=" + invoice_currency + ", baseline_create_date=" + baseline_create_date
				+ ", cust_payment_terms=" + cust_payment_terms + "]";
	}

}
