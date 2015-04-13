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
							action="#{loginBean.goToMyHome }" />
					</div>
					<%
						}
					%>
				</div>
			</div>
		</h:form>
		<div class="jumbotron">
			<h:form id="acc_form">
			<br>
				<h:messages globalOnly="true" style="color:red" />
				<br>
				<table>
					<tr>
						<td><h:outputLabel value="First Name"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.firstName}"
								id="new_fname" required="true" styleClass="form-control"
								requiredMessage="Please Enter first name" maxlength="15"></h:inputText></td>
						<td><h:message for="new_fname" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Last Name"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.lastName}"
								id="new_lname" required="true" maxlength="15"
								requiredMessage="Please Enter last name"
								styleClass="form-control"></h:inputText></td>
						<td><h:message for="new_lname" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Date Of Birth"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.dateOfBirth}"
								id="new_dob" required="true" maxlength="10"
								requiredMessage="Please date of birth" styleClass="form-control">
							</h:inputText> <h:outputLabel value="mm/dd/yyyy" /></td>
						<td><h:message for="new_dob" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Gender"></h:outputLabel></td>
						<td><h:selectOneRadio value="#{newAccountBean.gender}"
								styleClass="input-group-addon" id="gender" required="true"
								requiredMessage="Please select Gender">
								<f:selectItem itemValue="m" itemLabel="Male" />
								<f:selectItem itemValue="f" itemLabel="Female" />
							</h:selectOneRadio></td>
						<td><h:message for="gender" style="color:red" /></td>
					</tr>

					<tr>
						<td><h:outputLabel value="Phone No"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.phoneNo}"
								id="phone_no" required="true" maxlength="15"
								requiredMessage="Please Enter phone no."
								styleClass="form-control"></h:inputText></td>

						<td><h:message for="phone_no" style="color:red" /></td>
					</tr>

					<tr>

						<td><h:outputLabel value="Address Line"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.addressLine}"
								id="addrLine" required="true"
								requiredMessage="Please Enter address line" maxlength="30"
								styleClass="form-control"></h:inputText></td>
						<td><h:message for="addrLine" style="color:red" /></td>
					</tr>
					<tr>

						<td><h:outputLabel value="State"></h:outputLabel></td>
						<td><h:selectOneMenu value="#{newAccountBean.state}"
								id="state" required="true" requiredMessage="Please Enter state."
								styleClass="form-control">
								<f:selectItems value="#{newAccountBean.stateList}" />
							</h:selectOneMenu></td>
						<td><h:message for="state" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="City"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.city}" id="city"
								required="true" requiredMessage="Please Enter city"
								styleClass="form-control"></h:inputText></td>
						<td><h:message for="City" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Zip"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.zip}" id="zip"
								maxlength="5" required="true" requiredMessage="Please Enter zip"
								styleClass="form-control" validatorMessage="Please correct the zip.">
								<f:validateRegex pattern="^\d{5}$"/>
							</h:inputText></td>
						<td><h:message for="Zip" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Email Id"></h:outputLabel></td>
						<td><h:inputText value="#{newAccountBean.emailId}"
								id="email_id" required="true"
								requiredMessage="Please Enter Email" styleClass="form-control"
								validatorMessage="Please correct the email address.">
								<f:validateRegex pattern="[\w-]+@([\w-]+\.)+[\w-]+"/>
								</h:inputText></td>
						<td><h:message for="email_id" style="color:red" /></td>

						<td>
					</tr>
					<tr>
						<td><h:outputLabel value="Set Password" for="set_password"></h:outputLabel></td>
						<td><h:inputSecret value="#{newAccountBean.password}"
								id="set_password" required="true"
								requiredMessage="Please Enter Password"
								validatorMessage="Minimum length of password should be 8."
								styleClass="form-control" maxlength="20">
								<f:validateLength maximum="20" minimum="8"/>
								</h:inputSecret></td>
						<td><h:message for="set_password" style="color:red" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="Confirm Password" for="cnf_password"></h:outputLabel></td>
						<td><h:inputSecret value="#{newAccountBean.confPassword}"
								id="cnf_password" required="true"
								requiredMessage="Please Confirm Password"
								styleClass="form-control">
								</h:inputSecret></td>
						<td><h:message for="cnf_password" style="color:red" id="cnf_pswd_err"/></td>
					</tr>
					<tr>
						<td><h:commandButton value="Save and Create Account"
								styleClass="btn btn-success"
								action="#{newAccountBean.saveAccount}"></h:commandButton></td> 
						<td></td>
						<td></td>
					</tr>
				</table>

			</h:form>
		</div>
	</f:view>

</body>
</html>