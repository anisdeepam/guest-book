<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<script type='text/javascript' src='http://code.jquery.com/jquery-git2.js'></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style type='text/css'>
@import url('http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css');
body {
  margin: 10px;
}
</style>
<script type="text/javascript">
function OnSubmitForm()
{
  if(document.pressed == 'Update'){
   document.adminForm.action ="/admin/save";
  }
  else if(document.pressed == 'Delete'){
    document.adminForm.action ="/admin/delete";
  }
  return true;
}
</script>
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
			<c:url value="admin/delete" var="saveAdminEntry"/>
			<form:form name="adminForm" method="post" onsubmit="return OnSubmitForm();" modelAttribute="adminForm">
			  <table class="table table-striped">
				<thead>
					<tr>
					    <th>Select</th>
					    <th>No</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Address</th>
						<th>Message</th>
						<th>Approved?</th>
					</tr>
				</thead>
				<c:forEach var="guestEntry" items="${adminForm.entries}" varStatus="status">
				    <tr>
				    <td><form:checkbox path="entries[${status.index}].selected" name="entries[${status.index}].selected" value="entries[${status.index}].selected"/></td>
				    <td align="center">${status.count}</td>
				    <form:hidden path="entries[${status.index}].id" name="entries[${status.index}].id" value="${guestEntry.id}"/>
					<td><input name="entries[${status.index}].firstName" value="${guestEntry.firstName}"/></td>
					<td><input name="entries[${status.index}].lastName" value="${guestEntry.lastName}"/></td>
					<td><input name="entries[${status.index}].emailAddr" value="${guestEntry.emailAddr}"/></td>
					<td><input name="entries[${status.index}].message" value="${guestEntry.message}"/></td>
					<td><form:checkbox path="entries[${status.index}].isApproved" name="entries[${status.index}].isApproved" value="${guestEntry.isApproved}" /></td>
				    </tr>
				</c:forEach>
			</table>    
			 <button type="submit" class="btn btn-primary" value="Update" onclick="document.pressed=this.value">Update</button>
			 <button type="submit" class="btn btn-primary" value="Delete" onclick="document.pressed=this.value">Delete</button>
		</form:form>	
		</div>
	</div>
	</div>
</header>
</body>
</html>