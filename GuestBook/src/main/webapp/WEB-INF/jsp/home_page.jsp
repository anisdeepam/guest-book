<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
  <a class="navbar-brand" href="#">Welcome To Guest Book</a>
  <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="navbar-collapse collapse justify-content-between" id="main-navigation">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="/guest">Guest</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/admin">Admin</a>
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
  	<br>
  	<c:url var="adminUrl" value="/admin" />
  	<form action="${adminUrl}" method="get" class="form-horizontal">
			<button class="btn btn-primary btn-lg" type="submit">Admin Click Here</button>
	</form> 
	<br>		             
	<c:url var="guestUrl" value="/guest" />
	<form action="${guestUrl}" method="get" class="form-horizontal">
			<button class="btn btn-secondary btn-lg" type="submit">Guest Click Here</button>
	</form>
	</div>
</div>
</header>
</body>
</html>