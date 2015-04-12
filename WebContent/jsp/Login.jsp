<%@ page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<html>
<head>
<title>Login E-healthCare</title>
<link href="/EHealthcareManagement/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<f:view>
		<h:form id="navForm">
			<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="container">
					<div class="navbar-header navbar-brand">
					<h:commandLink action="#{welcomeBean.goToHome}">
						<h:graphicImage value="/images/eHealthLog.png"
							style="max-width: 100%; max-height: 100%;"></h:graphicImage>
						</h:commandLink>
					</div>
					<div class="navbar-header">

						<h3 style="color: white;">EHealthcare</h3>
					</div>
					<% if( session.getAttribute("userfName") != null) {%>
					<div class="navbar-header navbar-right">
					<h:commandLink value="Logout" style="color: white;"
							action="#{loginBean.userLogout }"/>
					</div>
					<div class="navbar-header navbar-right">
					<h:commandLink value="My Home" style="color: white;"
							action="#{loginBean.goToMyHome }"/>
					</div>
					
					<% }%>

				</div>
			</div>
			</h:form>
			
			<h:form id="loginFOrm">

			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<div class="container">
				
				<div class="row">
						<div class="col-md-4">
					<h2>Log in</h2>
					<h:messages style="color:red;"></h:messages>
					<br>
					<table>
						<tr>
							<td><h:outputLabel value="Email id: " for="email"></h:outputLabel></td>
							<td><h:inputText id="email" value="#{loginBean.email}"
									required="true" requiredMessage="Please Enter User Name"
									validatorMessage="Username value is invalid."
									styleClass="form-control">
								</h:inputText></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><h:outputLabel value="Password: " for="password"></h:outputLabel></td>
							<td><h:inputSecret id="password"
									value="#{loginBean.password}" required="true"
									requiredMessage="Please Enter Password."
									styleClass="form-control"
									validatorMessage="Password value is invalid.">
								</h:inputSecret></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td><h:commandButton value="Login"
									action="#{loginBean.validateLogin}"
									styleClass="btn btn-success"></h:commandButton> &nbsp;</td>

						</tr>
					</table>
					</div></div>
				</div>
			</div>
			<div class="container">
		<!-- Example row of columns -->


		<hr />

		<footer>
			<p>&copy; Company 2015</p>
		</footer>
	</div>
		</h:form>
		
	</f:view>

	
</body>
</html>
