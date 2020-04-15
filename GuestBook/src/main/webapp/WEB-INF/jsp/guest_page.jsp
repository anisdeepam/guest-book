<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Guest Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script>
    $(document).ready(function(){
    	$('.header').height($(window).height());
    	$('input:radio[name=messageOption]')[0].checked = true;
    	$('#fileDiv').hide();
    	$("#no-file-selected").hide();
    	$("#no-message-entered").hide();
    	
    	$('#text').click(function(){  
            $("#fileDiv").hide();
            $("#messageDiv").show();
            $("#no-file-selected").hide();
        	$("#no-message-entered").hide();
        }); 
        $('#file').click(function(){      
            $("#fileDiv").show();
            $("#messageDiv").hide();
            $("#no-file-selected").hide();
        	$("#no-message-entered").hide();
        });
        $('#guestEntrySubmit').click(function () {
        	$("#no-file-selected").hide();
         	$("#no-message-entered").hide();
            if ($("input[name='messageOption']:checked").val() == 'file') {
                if($("#guestFile").val()) {
                   return true;
                } else { 
                	$("#no-file-selected").show();
                	return false;
                }
            } 
        	if ($("input[name='messageOption']:checked").val() == 'text') {
                 if($("#message").val()) { 
                    return true;
                 } else { 
                 	$("#no-message-entered").show();
                 	return false;
                 }
            }
        });
    });
</script>
<style type='text/css'>
@import url('http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css');
body {
  margin: 10px;
}
</style>
</head>
<body>

<nav class="navbar navbar-expand-md">
  <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="main-navigation">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/logout">LogOut</a>
      </li>
    </ul>
  </div>
</nav>

<header class="page-header header container-fluid">

	<div class="overlay">
		<div class="description">
			<div id="exampleWrapper">
			<c:url value="/guest/saveGuestEntry" var="saveGuestEntry"/>
			  <form:form modelAttribute="guestEntry" ccsClass="form-horizontal" method="post" action="${saveGuestEntry }" enctype="multipart/form-data">
			  <form:hidden path="id"/>
			    <div class="form-group">
			      <label for="firstname"
			        class="col-lg-2 control-label col-sm-2 col-md-2 col-xs-2">First Name</label>
			      <div class="col-lg-3 col-sm-2 col-md-2 col-xs-2">
			        <form:input type="text" ccsClass="form-control" maxlength="255"
			          required="required" path="firstName" placeholder="Enter Your First Name" />
			      </div>
			    </div>
			    <div class="form-group">
			      <label for="lastname"
			        class="col-lg-2 control-label col-sm-2 col-md-2 col-xs-2">Last Name</label>
			      <div class="col-lg-3 col-sm-2 col-md-2 col-xs-2">
			        <form:input type="text" ccsClass="form-control" maxlength="255"
			          required="required" path="lastName" placeholder="Enter Your Last Name" />
			      </div>
			    </div>
			    <div class="clearfix"></div>
			    <div class="form-group">
			      <label for="emailAddress" class="col-lg-2 control-label">Email Address</label>
			      <div class="col-lg-3">
			        <form:input type="text" ccsClass="form-control" required="required"
			          path="emailAddr" placeholder="Enter Your Email ID" />
			      </div>
			    </div>
			    <div class="clearfix"></div>
			    <div class="form-group">
			      <label for="message" class="col-lg-2 control-label">Choose One</label>
			      <div class="col-lg-3">
			        <form:radiobutton id="text" ccsClass="form-control" path="messageOption" value="text"/> Text
			        <form:radiobutton id="file" ccsClass="form-control" path="messageOption" value="file"/> File
			           <!--<span class="input-group-addon btn btn-primary" id="submitMyForm" type="submit">Send</span>-->
			      </div>
			    </div>
			    <div class="clearfix"></div>
			    <div id="messageDiv" class="form-group">
			      <div id="no-message-entered">
			       Please Enter the Message
			      </div>
			      <div class="col-lg-3">
			        <form:textarea class="form-control" path="message" id="message" placeholder="Enter Your Message Here"/>
			      </div>
			    </div>
			    <div class="clearfix"></div>
			    <div id="fileDiv" class="form-group">
			      <div id="no-file-selected">
			       Please Choose a file
			      </div>
			      <div class="col-lg-3">
			        <form:input type="file" ccsClass="form-control" path="guestFile" id="guestFile" placeholder="Choose a file"/>
			      </div>
			    </div>
			    <div class="clearfix"></div>
			    <div class="form-group">
			      <div class="col-lg-offset-2 col-lg-10">
			        <button id="guestEntrySubmit" type="submit" class="btn btn-primary" value="Submit">Submit</button>
			      </div>
			    </div>
			  </form:form>
			  </div>
		</div>
	</div>
</header>
</body>
</html>