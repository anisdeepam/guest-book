<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Guest Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="../webjar/jquery/3.0.0/js/jquery-3.0.0.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script>	
$(document).ready(function(){	
	  $('.header').height($(window).height());
	})
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
			  <form:form modelAttribute="guestEntry" ccsClass="form-horizontal" method="post" action="${saveGuestEntry }">
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
			      <label for="message" class="col-lg-2 control-label">Message</label>
			      <div class="col-lg-3">
			        <form:textarea class="form-control" required="required"
			          path="message" placeholder="Enter Your Message Here"/>
			           <!--<span class="input-group-addon btn btn-primary" id="submitMyForm" type="submit">Send</span>-->
			      </div>
			    </div>
			    <div class="clearfix"></div>
			    <div class="form-group">
			      <div class="col-lg-offset-2 col-lg-10">
			        <button type="submit" class="btn btn-primary">Submit</button>
			      </div>
			    </div>
			  </form:form>
			  </div>
		</div>
	</div>
</header>
</body>
</html>