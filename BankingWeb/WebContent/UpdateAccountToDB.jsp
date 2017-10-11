<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="co.edureka.bank.services.*"
    import="co.edureka.banking.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html body style="background-color:#A3D2AC;">

<p  style="text-align:center;">
<%
      String name = request.getParameter("formName");
      long accountNum = Long.parseLong("12345");
   	//request.getParameter("formName")
   	  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      Date dateOfBirth = df.parse("01/01/1900");
      try
    	{
      		
     	 	dateOfBirth = df.parse(request.getParameter("formDOB"));
    	}
   	  catch(Exception e)
   	  	{
   		  out.print(e);
   		 }
   	  
      String address = request.getParameter("formAddress");
      String emailID = request.getParameter("formEmailID");
      String atype   = request.getParameter("formAccountType");
	  AccountType accountType = AccountType.SAVING;
	  
	  if(atype.equals("CURRENT"))
	     accountType = AccountType.CURRENT;
	  
//	  System.out.println(name+accountNum+dateOfBirth+address+emailID+accountType);
	 BankAccount pageBA = new BankAccount(name,accountNum,dateOfBirth,address,emailID,accountType);
	 BankSession bs = (BankSession)session.getAttribute("BankSession");
	 
	 Object so = pageContext.getAttribute("BankAccount",PageContext.SESSION_SCOPE);

	 if( so == null)
	 	{
		 
		 bs.setSessionBankAccount(pageBA);
		 
		 out.print("Account succefully created");
	 	}
	 else
	 	{
 		 bs.updateSessionBankAccount(pageBA);
		 
		 out.print("Account updated successfully");
	 	}



%>

</p>



</body>
</html>
