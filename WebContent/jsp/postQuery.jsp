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

		document.getElementById("postingQuery:cancelLink").click();

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

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<div class="container">
								<div class="row">
						<div class="col-md-6">
				<br> <br>

				<h3>Post a Query</h3>
				<br>
				<h:form id="postingQuery">


					<h:outputLabel value="Category"></h:outputLabel>

					<h:selectOneMenu value="#{patientBean.patientCategory}"
						id="patient_category" styleClass="form-control">
						<f:selectItems value="#{patientBean.patientCategoryList}" />
					</h:selectOneMenu>
				&nbsp;				
				<br>
					<br>

					<h:outputLabel value="Problem Description"></h:outputLabel>
					<br>
					<h:inputTextarea value="#{patientBean.patientDescription}"
						id="pblm_desc" required="true"
						requiredMessage="Please enter the problem description"
						styleClass="form-control" cols="7" rows="6"></h:inputTextarea>
						
						<h:message for="pblm_desc" errorStyle="color:red;"/>
				
				&nbsp;
				<br>
					<br>

					<input type="button"
						value="Cancel" class="btn btn-success" onclick="cancelPage();"/>
					&nbsp;

					<h:commandButton action="#{patientBean.insertPatientQuery}"
						value="Submit Query" styleClass="btn btn-success">

					</h:commandButton>

					<h:commandLink id="cancelLink" immediate="true"
					action="#{patientBean.backToHome}" value="">
				</h:commandLink>
				</h:form>
			</div></div>
			</div>
		</div>
	</f:view>
</body>
</html>