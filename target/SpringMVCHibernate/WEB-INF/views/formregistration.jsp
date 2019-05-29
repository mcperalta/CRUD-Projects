<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Project Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">Registration Project Form</div>
	 	<form:form method="POST" modelAttribute="project" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">Nombre del Proyecto</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="name" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="description">Descripcion del Proyecto</label>
					<div class="col-md-7">
						<form:input type="text" path="description" id="description" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="description" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="manager">ProjectManager asignado</label>
					<div class="col-md-7">
						<form:input type="text" path="manager" id="manager" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="manager" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listprojects' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listprojects' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>