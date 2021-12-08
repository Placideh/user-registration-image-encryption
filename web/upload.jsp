<%-- 
    Document   : upload
    Created on : Dec 7, 2021, 10:28:57 PM
    Author     : jumpman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
	<form action="encrypt" enctype="multipart/form-data" method="post" >
	    
	    <p><img id="output" width="200" /></p>
	   <input type="file"  accept="image/*" name="image" id="file"  onchange="loadFile(event)">
	    <button>encrypt</button>
	</form>
	<form action="decrypt" enctype="multipart/form-data" method="post">
	    <input type="file"  accept="image/*" name="image" id="file"  onchange="loadFile(event)">
	    <button>decrypt</button>
	</form>

	    <script>
	    var loadFile = function(event) {
		    var image = document.getElementById('output');
		    image.src = URL.createObjectURL(event.target.files[0]);
	    };
	    </script>
    </body>
</html>
