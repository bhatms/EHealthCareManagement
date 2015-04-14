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
<script>
	function getQueryList() {

		document.getElementById("patientQueryForm:hidLink").click();

	}
	
	function callAssignQuery() {
		
		alert('callAssignQuery');

		document.getElementById("patientQueryForm:assignBtn").click();

	}
</script>

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
				<h3>Assign queries</h3>
				<h:form id="patientQueryForm">
				<br>
				<h:messages infoStyle="color:green;" errorStyle="color:red;" warnStyle="color:blue;"/>

					<h:outputLabel for="categ" value="Select Category:" />
					<h:selectOneMenu value="#{adminBean.filterSpecalization}"
						id="categ" required="true"
						requiredMessage="Please Select Category."
						styleClass="form-control" onchange="getQueryList();">
						<f:selectItems value="#{adminBean.specalizationList}" />
					</h:selectOneMenu>

					<h:outputLabel for="query" value="Select Query:" rendered="#{adminBean.showQueryList}"/>
					<h:selectOneMenu value="#{adminBean.selectedQueryId}" id="query"
						styleClass="form-control" rendered="#{adminBean.showQueryList}">
						<f:selectItems value="#{adminBean.queryByCategoryList}" />
					</h:selectOneMenu>

					<h:outputLabel for="doctor" value="Select Doctor:" rendered="#{adminBean.showQueryList}"/>
					<h:selectOneMenu value="#{adminBean.selectedDoctorId}" id="doctor"
						styleClass="form-control" rendered="#{adminBean.showQueryList}">
						<f:selectItems value="#{adminBean.doctorByCateg}" />
					</h:selectOneMenu>


					<br>
					<h:commandButton value="Back" action="#{loginBean.goToMyHome}" id="bckBtn"
						styleClass="btn btn-success"></h:commandButton>

					&nbsp;
					<h:commandButton value="Assign" action="#{adminBean.assignQueries}" id="assignBtn"
						styleClass="btn btn-success" rendered="#{adminBean.showQueryList}"></h:commandButton>


					<h:commandLink value="" id="hidLink"
						action="#{adminBean.getFilterQueries}">
					</h:commandLink>
				</h:form>
			</div>
		</div>
	</f:view>

</body>
</html>