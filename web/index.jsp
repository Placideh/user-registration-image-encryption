<%-- 
    Document   : index
    Created on : Nov 16, 2021, 12:03:57 AM
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
	    
	   
	    .box{
		margin-bottom: 15px;
		margin-left: 25px;
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
	    .box4{
		margin:0;
		height:30px;
		margin-right:12px;
		width:25.5em;
		position:relative;
		top:-0.1em;
		left:-4px;
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
		top:-0.1em;
		left:2.7em;
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
		top:38em;
		text-align: center;
		left:-17em;
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
	    
	<form action="register" method="POST">
	    <div class="title">
	    <h3>Responsive Registration Form </h3>
	    <label class="error">${error["global"]}</label>
	</div>
	    <div class="box">
		<i class="fa fa-user" aria-hidden="true"></i>
		<input type="text" placeholder="Username" name="username" class="password" required>
		<br> <label class="error">${error["username"]}</label>
	    </div>
	    <div class="box">
		<i class="fa fa-lock" aria-hidden="true"></i>
		<input type="password" placeholder="Password" name="password" class="password"required>
		<br> <label class="error">${error["password"]}</label>
	    </div>
	    <div class="names">
		<div class="box1">
		<i class="fa fa-user" aria-hidden="true"></i>
		<input type="text" class="box2" placeholder="FirstName" name="firstName" required>
		<br> <label class="error">${error["firstName"]}</label>
	    </div>
	    <div class="box1">
		<i class="fa fa-user" aria-hidden="true"></i>
		<input type="text" class="box2" placeholder="LastName" name="lastName" required>
		<br> <label class="error">${error["lastName"]}</label>
	    </div>
	    </div>
	    
	    <div class="radios" >
		<input type="radio" name="sex" value="Male" > <p class="sex">Male</p>
		<input type="radio" name="sex" value="Female"><p class="sex">Female</p>
		<br> <label class="error">${error["gender"]}</label>
	    </div>
	    
	    <div class="box">
		<i class="fa fa-calendar" aria-hidden="true"></i>
		<input type="text" placeholder="age" name="age" class="box3" required>
		<br> <label class="error">${error["age"]}</label>
	    </div>
	    <div class="box">
		<i class="fa fa-phone-square" aria-hidden="true"></i>
		<input type="text" placeholder="phone number" name="phone" class="box4" required>
		<br> <label class="error">${error["phoneNumber"]}</label>
	    </div>
	    <div class="box" >
		<select id="role" name="role" required>
		    <option value=" ">Select a role</option>
		    <option value="GUEST">Guest</option>
		    <option value="ADMIN">Admin</option>
		</select>
	    </div>
	    
	    <button>Register</button>
	    
	</form>
	    <a href="login.jsp" class="login">Login</a>
	</div>
	
	<script  type="text/javascript">
	    const btn=document.getElementById("btn");
	    const user={
			username:"jumpman2",
			password:"plc12",
			firstName:"placide",
			lastName:"placide",
			age:"22",
			phoneNumber:"0789394104",
			sex:"Female",
			role:"GUEST"
	    };
	    btn.addEventListener('click',login);
//	    function hello() {
//		fetch('http://localhost:8080/UserRegistration/webresources/user/users')
//			.then(res=>res.json())
//			.then(data=>console.log(data));
//	    }
//	  
	    function hello(){
		 fetch('http://localhost:8080/UserRegistration/webresources/user/register',{
		method:'POST',
		headers:{
		    'Content-Type':'application/json'
		},
		body: JSON.stringify(user)
		}).then(res=> res.json())
		    .then(data=>console.log('success:',data))
		    .catch(error=>console.log('Error:',error));
	    }
	    const logs={
		username:"jumpman2",
		password:"plc12"
		}
	    function login(){
		fetch('http://localhost:8080/UserRegistration/webresources/user/login',{
		    method:'POST',
		    headers:{
			'Content-Type':'application/json'
		    },
		    body:JSON.stringify(logs)
		})
			.then(res=> res.json())
			.then(data=> console.log(data))
	    }
	   
	</script>
    </body>
    
</html>

