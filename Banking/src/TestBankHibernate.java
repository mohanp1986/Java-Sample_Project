
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

import co.edureka.banking.AccountType;
import co.edureka.banking.BankAccount;
import co.edureka.banking.BankUser;

import org.hibernate.Transaction;

public class TestBankHibernate {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()). buildServiceRegistry();
	    
		
		SessionFactory sf=cfg.buildSessionFactory(serviceRegistry);
		Session session=sf.openSession();
		
		Transaction t=session.beginTransaction();
		
		// Bank user
		BankUser user1 = new BankUser("Mohan3", "Pass03");
		
		session.update(user1);
		
		//Bank account
		Date dob = null;
		try {
			dob = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1950");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		BankAccount bk1 = new BankAccount("Mohan", 12345, dob, "Address l1, l2 pin - 55" , "Mohan@gmail.com", AccountType.SAVING);
		bk1.setUserName(user1.getUserName());
		session.persist(bk1);
		user1.setBankAccount(bk1);
		session.update(user1);
		
		
		
//		BankUser fromDB = (BankUser)session.get(BankUser.class, "Mohan2");
	//	System.out.println("from DB" + fromDB + " Password : " + fromDB.getPassword());
		t.commit();
		session.close();
		System.out.println("session complete");

	}
}
