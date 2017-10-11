package co.edureka.banking;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankaccount")
public class BankAccount {
	
	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="accountnum")
	private long accountNum;
	
	@Column(name="dob")
	private Date dateOfBirth;
	
	@Column(name="address")
	private String address;
	
	@Column(name="emailid")
	private String emailID;
	
	@Column(name="accountType")
	private AccountType accountType;
	
	@Column(name="balance")
	private float balance;
	
	public BankAccount() {};
	public BankAccount(String name, long accountNum, Date dateOfBirth, String address, String emailID,
			AccountType accountType) {
		
		this.name = name;
		this.accountNum = accountNum;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.emailID = emailID;
		this.accountType = accountType;
	}

	@OneToOne
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
