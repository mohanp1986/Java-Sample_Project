package co.edureka.bank.services;

public class TestBankSession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userName="Mohan3";
		String password = "Pass3";
		BankSession bs=new BankSession(userName);
		 
		try {
		if(bs.authenticate(password))
			System.out.println("Autentication succesfull -- Password = " + password );
		else
			System.out.println("Autentication failed -- Password = " + password );
		}
		catch(NullPointerException ne) {
			System.out.println("Invalid user");
		}
		catch(Exception e) {
			System.out.println("Some other error");
		}
	}

}
