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
function cancelPage(){
	
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
			<br>

					<h3 class="panel-title">Pofile</h3>
			<br>		
			<!-- <div class="panel-body"> -->
			<h:form id="profileForm">
				<h:message for="profileForm"></h:message>
				<table>
					<tr>
						<td><h:outputLabel value="First Name"></h:outputLabel></td>
						<td><h:inputText styleClass="form-control"
								value="#{patientBean.firstName}" id="new_fname"
								required="true" requiredMessage="Please Enter first name"></h:inputText></td>
						<td><h:message for="new_fname" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Last Name"></h:outputLabel></td>
						<td><h:inputText styleClass="form-control"
								value="#{patientBean.lastName}" id="new_lname"
								required="true" requiredMessage="Please Enter last name"></h:inputText></td>
						<td><h:message for="new_lname" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Date Of Birth"></h:outputLabel></td>
						<td><h:inputText value="#{patientBean.dateOfBirth}"
								id="new_dob" required="true" styleClass="form-control"
								requiredMessage="Please date of birth">
							</h:inputText> <h:outputLabel value="mm/dd/yyyy" /></td>
						<td><h:message for="new_dob" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Phone No"></h:outputLabel></td>
						<td><h:inputText styleClass="form-control"
								value="#{patientBean.phoneNo}" id="phone_no" required="true"
								requiredMessage="Please Enter phone no."></h:inputText></td>

						<td><h:message for="phone_no" style="color:red" /></td>
					</tr>
					<tr>

						<td><h:outputLabel value="Address Line"></h:outputLabel></td>
						<td><h:inputText styleClass="form-control"
								value="#{patientBean.addressLine}" id="addrLine"
								required="true" requiredMessage="Please Enter address line"></h:inputText></td>
						<td><h:message for="addrLine" style="color:red" /></td>
					</tr>
					<tr>

						<td><h:outputLabel value="State"></h:outputLabel></td>
						<td>
							<%-- <h:inputText styleClass="form-control"
							value="#{patientBean.state}" id="state" required="true"
							requiredMessage="Please Enter state."></h:inputText> --%> <h:selectOneMenu
								value="#{patientBean.state}" id="state" required="true"
								requiredMessage="Please Enter state." styleClass="form-control">
								<f:selectItems value="#{patientBean.stateList}" />
							</h:selectOneMenu>
						</td>
						<td><h:message for="state" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="City"></h:outputLabel></td>
						<td><h:inputText value="#{patientBean.city}"
								styleClass="form-control" id="city" required="true"
								requiredMessage="Please Enter city"></h:inputText></td>
						<td><h:message for="City" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Zip"></h:outputLabel></td>
						<td><h:inputText value="#{patientBean.zip}" id="zip"
								maxlength="5" required="true" requiredMessage="Please Enter zip"
								styleClass="form-control">
							</h:inputText></td>
						<td><h:message for="Zip" style="color:red" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><h:commandButton value="Update Profile"
								action="#{patientBean.updateSaveProfile}"
								styleClass="btn btn-success" /></td>
						<td>&nbsp;<input type="button" value="Cancel"
							onclick="cancelPage();" class="btn btn-success" /></td>
						<td></td>
					</tr>
				</table>
				<h:commandLink id="cmdLnkIdSuppliers" immediate="true"
					action="#{patientBean.backToHome}" value="">
					<f:verbatim></f:verbatim>
				</h:commandLink>
			</h:form>
		</div>






	</f:view>
</body>
</html>
