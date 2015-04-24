<%@ page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<html>
<head>
<title>Login E-healthCare</title>
<link href="/EHealthcareManagement/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resources/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.js"></script>


<script type="text/javascript">
	function cancelPage() {

		document.getElementById("PatientQueries:cancelLink").click();

	}

	$(function() {
		$('[data-toggle="popover"]').popover()	})

	/* 	$(function() {
	 $('[data-toggle="popover"]').popover({

	 trigger : 'hover',
	 placement : 'right',
	 html : 'true',
	 content : 'Hiiiii'
	 }).on('show.bs.modal', function() {
	 // var html = document.getElementById("replyId").value;
	 popover.attr('data-content', 'hi there');
	 }

	 )
	 })
	 */
</script>
</head>
<body>
	<f:view>
		<h:form id="navForm">
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
						<h:commandLink value="Logout" style="color: white;"
							action="#{loginBean.userLogout }" />
					</div>
					<div class="navbar-header navbar-right">
						<h:commandLink value="My Home |" style="color: white;"
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
				<br>

				<h3>Queries</h3>
				<h:form id="PatientQueries">
					<h:dataTable id="patientQueryTable"
						value="#{patientBean.patientQueryList}" var="patque" border="1"
						styleClass="table table-striped table-condensed table-bordered table-hover">

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Category" />
							</f:facet>
							<h:outputText value="#{patque.queryCategory}"></h:outputText>

						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Description" />
							</f:facet>
							<h:outputText value="#{patque.queryDescription}"></h:outputText>

						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Status" />
							</f:facet>
							<h:outputText value="#{patque.queryStatus}"></h:outputText>

						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Query Date" />
							</f:facet>
							<h:outputText value="#{patque.queryDate}"></h:outputText>

						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Doctors Reply" />
							</f:facet>

							<button type="button" class="btn btn-primary btn-lg"
								data-toggle="popover" title="Doctor Says" data-html = "true"
								data-content="<div>
								<h:outputText value="#{patque.doctorsReply}"></h:outputText>
								</div>">
								<h:outputText value="#{patque.doctorsReply}"></h:outputText>
								..
							</button>
						</h:column>

					</h:dataTable>
					<br>
					<input type="button" value="Back" class="btn btn-success"
						onclick="cancelPage();" />
					&nbsp;	
					<h:commandLink id="cancelLink" immediate="true"
						action="#{patientBean.backToHome}" value="">
					</h:commandLink>
				</h:form>
			</div>
		</div>

	</f:view>
</body>
</html>