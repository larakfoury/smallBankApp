<%@page import="com.banks.dao.Customer"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Software</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
</head>
<body>
<FORM>


Name: <input type = "text" name = "name" id = "name">
         <br />
         About: <input type = "text" name = "about" id= "about"/>
         Birth Year: <input type = "text" name = "birthYear" id = "birthYear" />
         <input type = "button" value = "Submit" id="submit" />
         
         <hr />
         
         Search By Name: <input type = "text" name = "searchbyname" id = "searchbyname">
                  <INPUT TYPE="BUTTON" VALUE="Get Info for name"  id="getInfo" />
         <div id="info" style="display: none;">
         <h3> Person information: </h3>
         
</div>

         
         <script type="text/javascript">
    $("#submit").click(function() {
    	var name = $("#name").val();
        var about = $("#about").val();
        var birthYear = $("#birthYear").val();
        $.ajax({
            url: '/customer',
            type: 'POST',
            data: {
            	name: name,
            	about: about,
            	birthYear: birthYear
            },
            success: function(data) {
                alert('Person created successfully');
            },
            failure: function(data) {
                alert('person creation Failed');
            }
        });
    });
    
    $("#getInfo").click(function() {
    	var name = $("#searchbyname").val();
        $.ajax({
            url: '/customer',
            dataType: 'html',
            type: 'GET',
            data: {
            	name: name
            },
            success: function(response) {
            	$('#info').html(response); 
                alert('Person info retreived successfully');
                $( "#info" ).show();
            },
            failure: function(data) {
                alert('person info Failed');
            }
        });
    });
</script>
</FORM>


</body>
</html>