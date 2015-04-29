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

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">

$(function() {
    $( "#datepicker" ).datepicker({
    	
      changeMonth: true,
      changeYear: true,
      yearRange: "-100:+0",
      maxDate: "+0M +0D"
    });
  });
		


	
	function submitForm(){
		
		if(document.getElementById("datepicker").value != null && document.getElementById("datepicker").value != ""){
			
			document.getElementById("acc_form:dobId").value = document.getElementById("datepicker").value; 
			document.getElementById("acc_form:saveBtn").click();
		}

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
							action="#{loginBean.goToMyHome }" />
					</div>
					<%
						}
					%>
				</div>
			</div>
		</h:form>
		<div class="jumbotron">
			<div class="container">
				<h:form id="acc_form">
					<br>
					<h:messages globalOnly="true" style="color:red" />
					<br>
					<table>
						<tr>
							<td><h:outputText value="First Name"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.firstName}"
									id="new_fname" required="true" styleClass="form-control"
									requiredMessage="Please Enter first name" maxlength="15"
									validatorMessage="Correct value of first name.">
									<f:validateRegex pattern="[a-zA-Z]+[ a-zA-Z-_]*" />
									<f:validateLength minimum="1" maximum="15"/>
								</h:inputText></td>
							<td><h:message for="new_fname" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputText value="Last Name"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.lastName}"
									id="new_lname" required="true" maxlength="15"
									requiredMessage="Please Enter last name"
									styleClass="form-control"
									validatorMessage="Correct value of last name.">
									<f:validateRegex pattern="[a-zA-Z]+[ a-zA-Z-_]*" />
									<f:validateLength minimum="1" maximum="15"/>
								</h:inputText></td>
							<td><h:message for="new_lname" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputText value="Date Of Birth"></h:outputText></td>
							<td><p>
									<input type="text" id="datepicker" class="form-control"
									autocomplete="off" required="required"> 
									<h:inputHidden id="dobId" value="#{newAccountBean.dateOfBirth}" />
								</p></td>
							<td></td>
						</tr>
						<tr>
							<td><h:outputText value="Gender"></h:outputText></td>
							<td><h:selectOneRadio value="#{newAccountBean.gender}"
									styleClass="input-group-addon" id="gender" required="true"
									requiredMessage="Please select Gender">
									<f:selectItem itemValue="m" itemLabel="Male" />
									<f:selectItem itemValue="f" itemLabel="Female" />
								</h:selectOneRadio></td>
							<td><h:message for="gender" style="color:red" /></td>
						</tr>

						<tr>
							<td><h:outputText value="Phone No"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.phoneNo}"
									id="phone_no" required="true" maxlength="13"
									requiredMessage="Please Enter phone no."
									styleClass="form-control"
									validatorMessage="Correct the phone no, length shoukd be 10 digit number.">
									<f:validateRegex pattern="^\d{10}$" />
									<f:validateLength minimum="10" maximum="10"/>
								</h:inputText></td>

							<td><h:message for="phone_no" style="color:red" /></td>
						</tr>

						<tr>

							<td><h:outputText value="Address Line"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.addressLine}"
									id="addrLine" required="true"
									requiredMessage="Please Enter address line" maxlength="30"
									styleClass="form-control"></h:inputText></td>
							<td><h:message for="addrLine" style="color:red" /></td>
						</tr>
						<tr>

							<td><h:outputText value="State"></h:outputText></td>
							<td><h:selectOneMenu value="#{newAccountBean.state}"
									id="state" required="true"
									requiredMessage="Please Enter state." styleClass="form-control">
									<f:selectItems value="#{newAccountBean.stateList}" />
								</h:selectOneMenu></td>
							<td><h:message for="state" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputText value="City"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.city}" id="city"
									required="true" requiredMessage="Please Enter city"
									styleClass="form-control"></h:inputText></td>
							<td><h:message for="City" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputText value="Zip"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.zip}" id="zip"
									maxlength="5" required="true"
									requiredMessage="Please Enter zip" styleClass="form-control"
									validatorMessage="Please correct the zip.">
									<f:validateRegex pattern="^\d{5}$" />
								</h:inputText></td>
							<td><h:message for="Zip" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputText value="Email Id"></h:outputText></td>
							<td><h:inputText value="#{newAccountBean.emailId}"
									id="email_id" required="true"
									requiredMessage="Please Enter Email" styleClass="form-control"
									validatorMessage="Please correct the email address.">
									<f:validateRegex pattern="[\w-]+@([\w-]+\.)+[\w-]+" />
								</h:inputText></td>
							<td><h:message for="email_id" style="color:red" /></td>

							<td>
						</tr>
						<tr>
							<td><h:outputText value="Set Password"></h:outputText></td>
							<td><h:inputSecret value="#{newAccountBean.password}"
									id="set_password" required="true"
									requiredMessage="Please Enter Password"
									validatorMessage="Minimum length of password should be 8."
									styleClass="form-control" maxlength="20">
									<f:validateLength maximum="20" minimum="8" />
								</h:inputSecret></td>
							<td><h:message for="set_password" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputText value="Reenter Password"></h:outputText></td>
							<td><h:inputSecret value="#{newAccountBean.confPassword}"
									id="cnf_password" required="true"
									requiredMessage="Please Confirm Password"
									styleClass="form-control">
								</h:inputSecret></td>
							<td><h:message for="cnf_password" style="color:red"
									id="cnf_pswd_err" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td><h:commandButton value="Save and Create Account"
									styleClass="btn btn-success" onclick="submitForm();"
									action="#{newAccountBean.saveAccount}"></h:commandButton></td>
							<td></td>
						</tr>
					</table>

					<h:commandLink id="saveBtn" action="#{newAccountBean.saveAccount}"></h:commandLink>

				</h:form>
			</div>
		</div>
	</f:view>

</body>
</html>