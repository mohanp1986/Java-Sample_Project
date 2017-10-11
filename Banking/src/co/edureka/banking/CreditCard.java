package co.edureka.banking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CreditCard")
public class CreditCard {
	
	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cardnumber")
	private long cardNumber;
	
	@Column(name="cvv")
	private int cvv2;

	
	public CreditCard(String name, long cardNumber, int cvv2) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv2 = cvv2;
	}
	
	public boolean authorize(int cvv2, float amount) {
		if (amount>100000 || cvv2 != this.cvv2) 
			return(false);
		else
			return(true);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv2() {
		return cvv2;
	}

	public void setCvv2(int cvv2) {
		this.cvv2 = cvv2;
	}

	
	

	
}
