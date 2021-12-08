<%-- 
    Document   : list
    Created on : Nov 14, 2021, 8:04:28 AM
    Author     : jumpman
--%>

<%@page import="model.User"%>
<%@page import="model.Guest"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Profile</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
	     body{
		font-family: Arial, Helvetica, sans-serif;
	    }
	     .container {
		background: #ddd;
		display: flex;
		justify-content: center;
		width: 60em;
		height: 43em;
		position: relative;
		left:18em;
	    }
	    .user{
		background: #f4f4f4;
		height:30px;
		width: 100%;
		padding:10px;
	    }
	    .fa{
		/*margin: 10px;*/
		font-size:30px;
	    }
	    span {
		margin:5px;
		font-size:20px;
	    }
	       form{
		height:85%;
		width:95em;
		position: relative;
		top:5em;
		border-top:8px solid #fcc749;
		left:-17em;
		margin-top:10px;
		padding-top:15px;
	    }
	    input[type=text]{
		margin-bottom: 15px;
		width: 30em;
		height:3em;
	    }
	    .password{
		margin-bottom: 15px;
		width: 30em;
		height:3em;
	    }
	   a{
		margin:0;
		height:90px;
		margin-right:12px;
		width:12em;
		position:relative;
		top:-34.5em;
		right:-43em;
		background:blue;
		border:none;
		color:#fff;
		border-radius:5px;
		text-decoration: none;
		padding:10px;
	    }
	    
	</style>
    </head>
    <%
	String username=request.getParameter("username");
	User user=null;
	Guest geust=new Guest();
	     geust=(Guest)geust.getList().get(username);
	     pageContext.setAttribute("guest", geust);
    %>
    <body>
	<div class="container">
	    <div class="user">
		<span>Username: ${guest.username} </span>	
	    </div>
	   <form action="login.html" >
	    <div class="title">
	    
	</div>
	   
	    <div class="box">
		<input type="password" placeholder="password" id="password" name="password" value=<%= geust.getPassword() %> class="password" disabled>
	    </div>
	    <div class="names">
		<div class="box1">
		<input type="text" class="box2" placeholder="firstName" id="firstName" value=<%= geust.getFirstName()%>  name="firstName" disabled>
	    </div>
	    <div class="box1">
		<input type="text" class="box2" placeholder="lastName" id="lastName" value=<%= geust.getLastName() %>  name="lastName" disabled>
	    </div>
	    </div>
	        <div class="box">
		<input type="text" placeholder="gender" name="gender" value="Male" value=<%= geust.getSex() %>  id="gender" class="box3" disabled>
	    </div>
	    
	    
	    <div class="box">
		<input type="text" placeholder="age" name="age" id="age" value=<%= geust.getAge() %>  class="box3" disabled>
	    </div>
	    <div class="box">
		<input type="text" placeholder="phone number" id="phone" value=<%= geust.getPhoneNumber()%> name="phone" class="box4" disabled >
	    </div>
	         <div class="box">
		<input type="text" placeholder="Role" name="role" id="role" value=<%= geust.getRole() %> class="box4" disabled >
	    </div>
	    </div>
	         <div class="box">
		     <input type="file" name="image" id="image"  class="box4" >
		     <form action="encrypt" method="post"> 
			 <input type="text" name="encryptionKey" class="box4" disabled>
			 <button>Encrypt</button>
			 
		     </form>
		     
		     <form action="encrypt" method="post"> 
			 <input type="text" name="decryptionKey" class="box4">
			 <button>Decrypt</button>
			 
		     </form>
	    </div>
	    
	    <a href="login.jsp">Logout</a>
	    
	</form>
	</div>

    </body>
</html>

