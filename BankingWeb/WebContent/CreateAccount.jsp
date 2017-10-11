<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="co.edureka.bank.services.*"
    import="java.text.SimpleDateFormat"
    
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

<form style="text-align:left;" action="UpdateAccountToDB.jsp" method=post>
<p>Name : &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<input type="text" name="formName" value="<% out.print(pageContext.getAttribute("Name",PageContext.SESSION_SCOPE)); %>"/></p>
<p>DOB : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<input type="text" name="formDOB" 
value="<% 
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String DOB="";
			Object DOBObj = pageContext.getAttribute("DOB",PageContext.SESSION_SCOPE);
			if (DOBObj instanceof Date)
				DOB = df.format(DOBObj);
			out.print(DOB);   
%>"/></p>
		
<p>Address : <br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<textarea rows="6" cols="30" name="formAddress" >
<% out.print(pageContext.getAttribute("Address",PageContext.SESSION_SCOPE)); %>
  </textarea></p>		

<p>Email ID : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<input type="text" name="formEmailID" value="<% out.print(pageContext.getAttribute("EmailID",PageContext.SESSION_SCOPE)); %>"/></p>


<p>Type of account : 
<select name="formAccountType" >
    <option value="SAVINGS">SAVINGS</option>
    <option value="CURRENT">CURRENT</option>
</select>
</p>
<br>
<button><%

Object so = pageContext.getAttribute("BankAccount",PageContext.SESSION_SCOPE);

if( so == null)
	{
		out.print("Create Account");
	}
else
	{
		out.print("Update Account");
	}

%></button>
</form>
<br>

<p  style="text-align:center;">

</p>



</body>
</html>