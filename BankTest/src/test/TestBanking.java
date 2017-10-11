package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import co.edureka.banking.AccountType;
import co.edureka.banking.BankAccount;
import co.edureka.banking.BankUser;

public class TestBanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankUser user1 = new BankUser("Mohan", "Pass1");
		Date dob = null;
		try {
			dob = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1950");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankAccount account1 = new BankAccount("Mohan", 123456L, dob , "adress line 1, address line 2", "mohan@gmail.com", AccountType.SAVING);
		user1.setBankAccount(account1);
		System.out.println(user1);
		

	}

}
