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
		<div class="container">
		<h3>Search For Doctor</h3>
		<h:form id="searchParamForm">

			<h:panelGrid columns="10">
				<h:outputLabel value="First Name" for="doct_fname"></h:outputLabel>
				<h:inputText value="#{doctorBean.firstName}" id="doct_fname"
				styleClass="form-control"></h:inputText>
				&nbsp;
				<h:outputLabel value="Last Name" for="doct_lname"></h:outputLabel>
				<h:inputText value="#{doctorBean.lastName}" id="doct_lname"
				styleClass="form-control"></h:inputText>
				&nbsp;
				<h:outputLabel value="Specialization" for="doct_spcl"></h:outputLabel>
				<h:selectOneMenu value="#{doctorBean.specialization}" id="doct_spcl" styleClass="form-control">
					<f:selectItems value="#{doctorBean.specializationList}" />
				</h:selectOneMenu>
				&nbsp;
			<h:commandButton action="#{doctorBean.searchDoctor}" value="Search" styleClass="btn btn-success">
			</h:commandButton>
			</h:panelGrid>



		</h:form>
		<br />
		<br />
		<h:form id="searchResultForm">
			<h:dataTable id="doctTable" value="#{doctorBean.doctorSearchList}"
				var="doct" rendered="#{doctorBean.showSearch}" border="1" 
				styleClass="table table-striped table-condensed table-bordered table-hover">

				<h:column>
					<f:facet name="header">
						<h:outputText value="Name" />
					</f:facet>
					<h:outputText value="#{doct.firstName}"></h:outputText>&nbsp;
				<h:outputText value="#{doct.lastName}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Specialization" />
					</f:facet>
					<h:outputText value="#{doct.specialization}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Designation" />
					</f:facet>
					<h:outputText value="#{doct.designation}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Visiting Days" />
					</f:facet>
					<h:outputText value="#{doct.visitingDays}"></h:outputText>

				</h:column>

				<h:column>
					<f:facet name="header">
					</f:facet>
					<h:commandLink value="Show details"
						action="#{doctorBean.goToDetailProfile}">
						<f:param name="doctorId" value="#{doct.doctorId}" />
					</h:commandLink>
				</h:column>


			</h:dataTable>

		</h:form>
	</div>
	</div>
	</f:view>

</body>
</html>