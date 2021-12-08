<%-- 
    Document   : login
    Created on : Nov 16, 2021, 12:06:09 AM
    Author     : jumpman
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>User Registration</title>
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
	    form{
		background: white;
		height:95%;
		width:30em;
		position: relative;
		top:8px;
		border-top:8px solid #fcc749;
		left:11em;
	    }
	    .fa {
		border:1px solid black;
		padding:11px;
		margin-left:0px;
	    }
	    
	    .password{
		margin:0;
		height:29px;
		margin-right: 0px;
		width:26em;
		position:relative;
		top:-0.1em;
		left:-4px;
	    }
	    .box2 {
		margin:0;
		height:30px;
		margin-right:12px;
		width:10em;
		position:relative;
		top:-0.1em;
		left:-4px;
	    }
	    
	   
	    .box1{
		margin-bottom: 15px;
		margin-left: 25px;
		position: relative;
		top:4em;
		left:1em;
	    }
	    
	    .title{
		text-align: center;
	    }
	    .names{
		display: flex;
		position:relative;
		left:25px;
	    }
	    .radios {
		margin-top:15px;
		margin-left:20px;
		margin-bottom: 15px;
	    }
	    .sex{
		display: inline;
		position: relative;
		top:-3px;
	    }
	    .box3{
		margin:0;
		height:30px;
		margin-right:12px;
		width:25.5em;
		position:relative;
		top:-0.1em;
		left:-4px;
	    }
	    .box5{
		margin-bottom: 15px;
		margin-left: 25px;
		position: relative;
		top:6em;
		left:1em;
	    }
	    select {
		margin:0;
		height:30px;
		margin-right:12px;
		width:30em;
		position:relative;
		top:-0.1em;
		left:0.5px;
	    }
	    button{
		margin:0;
		height:30px;
		margin-right:12px;
		width:30em;
		position:relative;
		top:12em;
		left:4em;
		background: #fcc749;
		border:none;
		color:#fff;
	    }
	    .login{
		text-decoration: none;
		color:#fff;
		background: blue;
		height:30px;
		width:23.5em;
		position: relative;
		top:28em;
		text-align: center;
		padding-top:10px;
		left:-16em;
	    }
	    .error{
		color:red;
		font-style: italic;
	    }
	  
	    
	</style>
	
    </head>
    <body>
	<%
            Map<String, String> errors = (Map)session.getAttribute("error");
            pageContext.setAttribute("error", errors);
            session.removeAttribute("error");
	%>
	<div class="container">
	    
	<form action="register" method="GET">
	    <div class="title">
	    <h3>Login Form </h3>
	     <label class="error">${error["global"]}</label>
	    </div>
	    <div class="box1">
		<i class="fa fa-user" aria-hidden="true"></i>
		<input type="text" placeholder="username" name="username" class="password">
		<br> <label class="error">${error["username"]}</label>
	    </div>
	    <div class="box5">
		<i class="fa fa-lock" aria-hidden="true"></i>
		<input type="password" placeholder="password" name="password" class="password">
		<br> <label class="error">${error["password"]}</label>
	    </div>
	    <button>LOGIN</button>
	    
	</form>
	    <a href="index.jsp" class="login">Create Account</a>
	</div>
	
	
    </body>
    
</html>

