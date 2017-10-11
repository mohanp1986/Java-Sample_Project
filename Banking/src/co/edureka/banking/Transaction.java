package co.edureka.banking;

import java.util.Date;

public class Transaction {
	
	private long tranID;
	private Date tranDate;
	private String description;
	private String chequeNo;
	private float withdraw,deposit, balance;
	
	public Transaction(long tranID, Date tranDate, String description, String chequeNo, float withdraw, float deposit,
			float balance) {
		this.tranID = tranID;
		this.tranDate = tranDate;
		this.description = description;
		this.chequeNo = chequeNo;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.balance = balance;
	}
	
	
	

}
