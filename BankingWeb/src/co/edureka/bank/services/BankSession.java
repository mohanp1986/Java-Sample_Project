package co.edureka.bank.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edureka.banking.*;

public class BankSession {

	private String userName;
	private Session session;
	private BankUser sessionBankUser = new BankUser();
	

	
	
	public BankSession(String userName) {
		this.userName = userName;
		session = BankDBSessionFactory.getSession();
		Transaction t=session.beginTransaction();
		System.out.println("Session " +session );
		this.sessionBankUser = (BankUser)session.get(BankUser.class, userName);
			
		t.commit();
		session.close();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean authenticate(String password) {

		return(password.equals(sessionBankUser.getPassword()));
	}

	public BankUser getSessionBankUser() {
		return sessionBankUser;
	}
	
	public boolean setSessionBankAccount(BankAccount sessionBankAccount) {
		
		System.out.println(sessionBankAccount+userName+sessionBankUser);
		session = BankDBSessionFactory.getSession();
		Transaction t=session.beginTransaction();

		sessionBankAccount.setUserName(sessionBankUser.getUserName());
		
		session.persist(sessionBankAccount);
		sessionBankUser.setBankAccount(sessionBankAccount);
		session.update(sessionBankUser);
		t.commit();
		session.close();
		
		return true;
	}
	
	public boolean updateSessionBankAccount(BankAccount sessionBankAccount) {
		
		System.out.println(sessionBankAccount+userName+sessionBankUser);
		session = BankDBSessionFactory.getSession();
		Transaction t=session.beginTransaction();

		sessionBankAccount.setUserName(sessionBankUser.getUserName());
		
		session.update(sessionBankAccount);
		
		t.commit();
		session.close();
		
		return true;
	}
	
	
}
