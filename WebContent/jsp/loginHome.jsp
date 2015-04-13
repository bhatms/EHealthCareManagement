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
		<div class="jumbotron">

			<h:form>
				<table>
					<tr>
						<td>
							<h3>
								Welcome&nbsp;
								<%=session.getAttribute("userfName")%></h3>
						</td>
					</tr>
				</table>




				<ul class="nav nav-pills nav-stacked col-md-2">
					<h:commandLink value="Profile"
						action="#{patientBean.viewPatientProfile}"
						styleClass="list-group-item"></h:commandLink>

					<h:commandLink value="Post a query"
						action="#{patientBean.goToQuery}" styleClass="list-group-item"></h:commandLink>

					<h:commandLink value="View Past Queries"
						action="#{patientBean.displayQuery}" styleClass="list-group-item"></h:commandLink>

				</ul>

			</h:form>
		</div>
	</f:view>

</body>
</html>