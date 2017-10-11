<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="co.edureka.bank.services.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html body style="background-color:#A3D2AC;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking Login Page</title>
</head>
<body>
<h1 style="text-align:center;">Banking System</h1>
<hr>

<form style="text-align:center;" method=post>
<p>User Name : <input type="text" name="formUserName" value=""/></p>
<p>Password &nbsp&nbsp : <input type="password" name="formPassword"/></p>
<button>Submit</button>
</form>
<br>

<p  style="text-align:center;">
<%
out.print(request.getParameter("formUserName"));
String userName = request.getParameter("formUserName");
String password = request.getParameter("formPassword");
try{
BankSession bs=new BankSession(userName);

try {
if(bs.authenticate(password))
	out.print("Autentication succesfull -- Password = " + password );
else
	out.print("Autentication failed -- Password = " + password );
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