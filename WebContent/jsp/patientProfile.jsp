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
  
	function cancelPage() {

		document.getElementById("profileForm:cmdLnkIdSuppliers").click();

	}

	function enablePasswordEdit() {
		document.getElementById("paswdDiv1").style.display = 'block';
		document.getElementById("paswdDiv2").style.display = 'block';
	}

	function submitForm() {

		if (document.getElementById("datepicker").value != null
				&& document.getElementById("datepicker").value != "") {

			
			document.getElementById("profileForm:dobId").value = document
					.getElementById("datepicker").value;
			document.getElementById("profileForm:saveBtn").click();
		}

	}
	
function loadMethod(){
		
		document.getElementById("datepicker").value= document.getElementById("profileForm:dobId").value; 
	}
</script>
</head>


<body onload="loadMethod();">
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

				<h3 class="panel-title">Pofile</h3>
				<br>
				<h:messages globalOnly="true" infoStyle="color:green;"></h:messages>
				<!-- <div class="panel-body"> -->
				<h:form id="profileForm">
					<h:message for="profileForm"></h:message>
					<table>
						<tr>
							<td><h:outputLabel value="First Name"></h:outputLabel></td>
							<td><h:inputText styleClass="form-control"
									value="#{patientBean.firstName}" id="new_fname" required="true"
									requiredMessage="Please Enter first name" 
									validatorMessage="Correct value of first name.">
									<f:validateRegex pattern="[a-zA-Z]+[ a-zA-Z-_]*" />
									<f:validateLength minimum="1" maximum="15"/></h:inputText></td>
							<td><h:message for="new_fname" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputLabel value="Last Name"></h:outputLabel></td>
							<td><h:inputText styleClass="form-control"
									value="#{patientBean.lastName}" id="new_lname" required="true"
									requiredMessage="Please Enter last name" 
									validatorMessage="Correct value of last name.">
									<f:validateRegex pattern="[a-zA-Z]+[ a-zA-Z-_]*" />
									<f:validateLength minimum="1" maximum="15"/>
									</h:inputText></td>
							<td><h:message for="new_lname" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputLabel value="Date Of Birth"></h:outputLabel></td>
							<td><p>
									<input type="text" id="datepicker" class="form-control"
									autocomplete="off" required="required"> 
									<h:inputHidden id="dobId" value="#{patientBean.dateOfBirth}" />
								</p></td>
							<td></td>
						</tr>
						<tr>
							<td><h:outputLabel value="Gender"></h:outputLabel></td>
							<td><h:selectOneRadio value="#{patientBean.gender}"
									styleClass="input-group-addon" id="gender" required="true"
									requiredMessage="Please select Gender">
									<f:selectItem itemValue="m" itemLabel="Male" />
									<f:selectItem itemValue="f" itemLabel="Female" />
								</h:selectOneRadio></td>
							<td><h:message for="gender" style="color:red" /></td>
						</tr>
						<tr>
							<td><h:outputLabel value="Phone No"></h:outputLabel></td>
							<td><h:inputText styleClass="form-control"
									value="#{patientBean.phoneNo}" id="phone_no" required="true"
									requiredMessage="Please Enter phone no."
									validatorMessage="Enter correct phone number.">
									<f:validateRegex pattern="^\d{10}$" />
									<f:validateLength minimum="10" maximum="10"/>
									</h:inputText></td>

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
							<td><h:selectOneMenu value="#{patientBean.state}" id="state"
									required="true" requiredMessage="Please Enter state."
									styleClass="form-control">
									<f:selectItems value="#{patientBean.stateList}" />
								</h:selectOneMenu></td>
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
									maxlength="5" required="true"
									validatorMessage="Enter correct zip."
									requiredMessage="Please Enter zip" styleClass="form-control">
									<f:validateRegex pattern="^\d{5}$" />
								</h:inputText></td>
							<td><h:message for="Zip" style="color:red" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input type="button" value="Cancel"
								onclick="cancelPage();" class="btn btn-success" /></td>
							<td>&nbsp; <h:commandButton value="Update Profile"
									action="#{patientBean.updateSaveProfile}"
									styleClass="btn btn-success" onclick="submitForm();" />
							</td>
							<td></td>
						</tr>
					</table>
					<h:commandLink id="cmdLnkIdSuppliers" immediate="true"
						action="#{patientBean.backToHome}" value="">
						<f:verbatim></f:verbatim>
					</h:commandLink>

					<h:commandLink id="saveBtn"
						action="#{patientBean.updateSaveProfile}" />

				</h:form>
			</div>
		</div>


	</f:view>
</body>
</html>
