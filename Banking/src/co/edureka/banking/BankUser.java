package co.edureka.banking;
//import org.hibernate.annotations.*;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="bankuser")
public class BankUser {
	@Id
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	
	@OneToOne
	private BankAccount bankAccount;
	@OneToOne
	private CreditCard creditCard;
	
	public BankUser() {};	
	public BankUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public BankAccount getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String name, long accountNum, Date dateOfBirth, String address, String emailID,
			AccountType accountType) {
		this.bankAccount = new BankAccount(name, accountNum, dateOfBirth, address, emailID, accountType);
	}

	
	public CreditCard getCreditCard() {
		return creditCard;
	}


	public void setCreaditCard(String name, long cardNumber, int cvv2) {
		this.creditCard = new CreditCard(name, cardNumber, cvv2);
	}


	


	@Override
	public String toString() {
		return "BankUser [userName=" + userName + ", bankAccount=" + bankAccount
				+ ", creditCard=" + creditCard + "]";
	}


	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount=bankAccount;		
		
	}


	
	
	

}
