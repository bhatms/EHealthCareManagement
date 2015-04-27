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

<script type="text/javascript">
	function cancelPage() {

		document.getElementById("profileForm:cmdLnkIdSuppliers").click();

	}
	

</script>
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
							action="#{loginBean.goToMyHome}" />
					</div>
					<%
						}
					%>
				</div>
			</div>
		</h:form>
		<div class="jumbotron">
			<div class="container">
				<br>

				<h3 class="panel-title">Edit Query</h3>
				<br>
				<h:messages globalOnly="true" infoStyle="color:green;"></h:messages>
				<!-- <div class="panel-body"> -->
				<h:form id="profileForm">
					<h:message for="profileForm"></h:message>
					<table>
						<tr>
							<td><h:outputLabel value="Category"></h:outputLabel></td>
							<td><h:inputText styleClass="form-control"
									value="#{PatientBean.queryPatientCategory}" id="new_fname" required="true"
									requiredMessage="Please Enter Category"></h:inputText></td>
							<td><h:message for="new_fname" style="color:red" /></td>
						</tr>


		
						<tr>

							<td><h:outputLabel value="Description"></h:outputLabel></td>
							<td><h:inputText styleClass="form-control"
									value="#{PatientBean.queryPatientDescription}" id="addrLine"
									required="true" requiredMessage="Please Enter Description"></h:inputText></td>
							<td><h:message for="addrLine" style="color:red" /></td>
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input type="button" value="Cancel"
								onclick="cancelPage();" class="btn btn-success" /></td>
							<td>&nbsp; <h:commandButton value="Update Query"
									action="#{patientBean.updateSaveQuery}"
									styleClass="btn btn-success" />
							</td>
							<td></td>
						</tr>
					</table>
					<h:commandLink id="cmdLnkIdSuppliers" immediate="true"
						action="#{patientBean.backToHome}" value="">
						<f:verbatim></f:verbatim>
					</h:commandLink>
				</h:form>
			</div>
		</div>


	</f:view>
</body>
</html>
