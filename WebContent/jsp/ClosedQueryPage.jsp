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

				<h3>CLOSED QUERIES</h3>
				<h:form id="closed">

					<br>
					<br>


					<h:dataTable id="ClosedQueryTable"
						value="#{adminBean.closedQueriesList}" var="closed"
						rendered="#{adminBean.showClosed}" border="1"
						styleClass="table table-striped table-condensed table-bordered table-hover">


						<h:column>
							<f:facet name="header">
								<h:outputText value="Query ID" />
							</f:facet>
							<h:outputText value="#{closed.queryId}"></h:outputText>
						</h:column>
						
						<h:column>
							<f:facet name="header">
								<h:outputText value="Patient Name" />
							</f:facet>
							<h:outputText value="#{closed.patientName}"></h:outputText>
						</h:column>
						

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Category" />
							</f:facet>
							<h:outputText value="#{closed.queryCategory}"></h:outputText>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Description" />
							</f:facet>
							<h:outputText value="#{closed.queryDescription}"></h:outputText>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Date" />
							</f:facet>
							<h:outputText value="#{closed.queryDate}"></h:outputText>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Doctor Name" />
							</f:facet>
							<h:outputText value="#{closed.doctorName}"></h:outputText>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Doctor Reply" />
							</f:facet>
							<h:outputText value="#{closed.doctorsReply}"></h:outputText>
						</h:column>

					</h:dataTable>
					<br>
					<h:commandButton value="Back" action="#{loginBean.goToMyHome}"
						styleClass="btn btn-success"></h:commandButton>

				</h:form>
			</div>
		</div>


	</f:view>

</body>
</html>