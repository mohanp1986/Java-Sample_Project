<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="co.edureka.bank.services.*"
    import="co.edureka.banking.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html body style="background-color:#A3D2AC;">

<p  style="text-align:center;">
<%
out.print(request.getParameter("formUserName"));
String userName = request.getParameter("formUserName");
String password = request.getParameter("formPassword");
try{
BankSession bs=new BankSession(userName);

try {
if(bs.authenticate(password))
	{
	out.print("Autentication succesfull");
	session.setAttribute("BankSession",bs);
	pageContext.setAttribute("userName", bs.getUserName(), PageContext.SESSION_SCOPE);

	
	BankUser bu = bs.getSessionBankUser();
	BankAccount ba = bu.getBankAccount();
	pageContext.setAttribute("BankAccount", ba , PageContext.SESSION_SCOPE);
	
	if(ba != null)
		{
			pageContext.setAttribute("Name", ba.getName(), PageContext.SESSION_SCOPE);
			pageContext.setAttribute("DOB", ba.getDateOfBirth(), PageContext.SESSION_SCOPE);
			pageContext.setAttribute("Address", ba.getAddress(), PageContext.SESSION_SCOPE);
			pageContext.setAttribute("EmailID", ba.getEmailID(), PageContext.SESSION_SCOPE);
			pageContext.setAttribute("AccountType", ba.getAccountType(), PageContext.SESSION_SCOPE);
		}
	else
		{
			pageContext.setAttribute("Name", "", PageContext.SESSION_SCOPE);
			pageContext.setAttribute("DOB", "", PageContext.SESSION_SCOPE);
			pageContext.setAttribute("Address", "", PageContext.SESSION_SCOPE);
			pageContext.setAttribute("EmailID", "", PageContext.SESSION_SCOPE);
			pageContext.setAttribute("AccountType", "", PageContext.SESSION_SCOPE);
		
		}
			response.sendRedirect("MainMenu.html");
	}
else
	out.print("Autentication failed" );
}
catch(NullPointerException ne) {
	out.print("Invalid user");
}
catch(Exception e) {
	out.print("Some other error");
}


}
catch(Exception e) {
	out.print("Some other error");
}




%>
</p>



</body>
</html>