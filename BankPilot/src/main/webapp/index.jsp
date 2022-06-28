<%@page import="com.banks.model.Customer"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table, th, td {
  border:1px solid black;
}
</style>
<title>Bank Software</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
</head>
<body>
<FORM>

<label for="name">Choose a name:</label>

<select name="name" id="name">
  <option value="Ada">Ada</option>
  <option value="Kevin">Kevin</option>
  <option value="Stanley">Stanley</option>
</select>
<label for="initialCredit">Initial Credit</label>
          <input type="text" name = "initialCredit" id = "initialCredit" />
         <br />
         <input type = "button" value = "add new account" id="submit" />
         
         <hr />
         
         Search By Name:
         <select name="searchbyname" id="searchbyname">
		  <option value="Ada">Ada</option>
		  <option value="Kevin">Kevin</option>
		  <option value="Stanley">Stanley</option>
		</select>
        <INPUT TYPE="BUTTON" VALUE="get account info"  id="getInfo" />
         <div id="info" style="display: none;">         
		</div>

         
         <script type="text/javascript">
    $("#submit").click(function() {
    	var name = $("#name").val();
    	var initialCredit = $("#initialCredit").val();

        $.ajax({
            url: '/customer',
            type: 'POST',
            data: {
            	name: name,
            	initialCredit: initialCredit
            },
            success: function(data) {
                alert('Customer account created successfully');
            },
            failure: function(data) {
                alert('Customer account creation Failed');
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
                alert('Customer info retreived successfully');
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