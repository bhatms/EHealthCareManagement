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
     function Expand(obj){
      if (!obj.savesize) obj.savesize=obj.size;
      obj.size=Math.max(obj.savesize,obj.value.length);
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
		<br>
		<br>

		<h3>Post a Query</h3>
		<br>
		<h:form id="postingQuery">


				<h:outputLabel value="Category"></h:outputLabel>

				<h:selectOneMenu value="#{patientBean.patientCategory}" id="patient_category"
				styleClass="form-control">
				<f:selectItems value="#{patientBean.patientCategoryList}" />
				</h:selectOneMenu>
				&nbsp;				
				<br>
				<br>

				<h:outputLabel value="Problem Description"></h:outputLabel>
				<br>
				<h:inputTextarea value="#{patientBean.patientDescription}" id="pblm_desc" onkeyup="Expand(this);"
				required="true" requiredMessage="Please enter the problem description"
				styleClass="form-control"></h:inputTextarea>
				
				&nbsp;
				<br>
				<br>


				<h:commandButton action="#{patientBean.insertPatientQuery}" value="Submit" styleClass="btn btn-success">

				</h:commandButton>
	
	<%-- <f:param name="patientId" value='<%=session.getAttribute(\"patId\")%>'/> --%>
				
		</h:form>
		</div>
		</div>
	</f:view>	
</body>
</html>