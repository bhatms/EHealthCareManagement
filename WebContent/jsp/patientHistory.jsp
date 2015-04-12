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
			<br>
			<h2>Doctor Profile</h2>
			<h:form id="viewDoctorProfileForm">



				<table>
					<tr>
						<td><h:outputText value="Name:" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.firstName}"></h:outputText>&nbsp;
							<h:outputText value="#{doctorBean.doctorProfileList.lastName}"></h:outputText></td>
					</tr>
					<tr>
						<td><h:outputText value="Qualification" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.qualification}" /></td>
					</tr>
					<tr>
						<td><h:outputText value="Specialization" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.specialization}" /></td>
					</tr>
					<tr>
						<td><h:outputText value="Designation" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.designation}" /></td>
					</tr>
					<tr>
						<td><h:outputText value="Visiting Days:" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.visitingDays}" /></td>
					</tr>
					<tr>
						<td><h:outputText value="Visiting Hours:" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.visitingHours}" /></td>
					</tr>

					<tr>
						<td><h:outputText value="Email ID:" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.emailId}" /></td>
					</tr>
					<tr>
						<td><h:outputText value="Phone:" /></td>
						<td><h:outputText
								value="#{doctorBean.doctorProfileList.phoneNum}" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><h:commandButton value="Back to search"
								action="#{welcomeBean.goToSearchDoctor}"
								styleClass="btn btn-success" /></td>
						<td></td>
					</tr>
				</table>




			</h:form>
		</div>

	</f:view>
</body>
</html>