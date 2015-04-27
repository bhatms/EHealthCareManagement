<%@ page contentType="text/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Healthcare Management</title>
<link href="/EHealthcareManagement/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link
	href="/EHealthcareManagement/resources/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
</head>


<body>
	<f:view>
		<h:form>
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
					<%
						if (session.getAttribute("userfName") != null) {
					%>
					<div class="navbar-header navbar-right">
						<h:commandLink value=" Logout" style="color: white;"
							action="#{loginBean.userLogout }" />
					</div>
					<div class="navbar-header navbar-right">
						<h:commandLink value="My Home | " style="color: white;"
							action="#{loginBean.goToMyHome }" />
					</div>
					<%
						}
					%>
				</div>
			</div>
		</h:form>


		<h:form>
			<div class="jumbotron">

				<h3>
					Welcome Dr.
					<%=session.getAttribute("userfName")%></h3>


			</div>
			<div class="row">
				<div class="col-md-3">

					<ul class="nav nav-pills nav-stacked">
						<li><h:commandLink value="New Queries"
								action="#{doctorBean.viewNewQueries}"
								styleClass="list-group-item btn btn-primary btn-lg active"
								></h:commandLink></li>
						<br>
						<li><h:commandLink value="Answered Queries"
								action="#{doctorBean.viewOtherQueries}"
								styleClass="list-group-item btn btn-primary btn-lg active">
								</h:commandLink></li>


					</ul>
				</div>
				<div class="col-md-5">
					<h:graphicImage value="/images/doctor-ipad.jpg" 
					style="max-width: 100%; max-height: 100%;"></h:graphicImage>
				</div>
				</div>

				
		</h:form>

	</f:view>

</body>
</html>