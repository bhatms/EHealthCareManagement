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

<script type="text/javascript" src="../resources/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.js"></script>


<script type="text/javascript">
	function cancelPage() {

		document.getElementById("new:cmdLnkIdSuppliers").click();

	}

	$(function() {
		$('[data-toggle="popover"]').popover()
	})

	$(window).on('shown.bs.modal', function(event) {

		document.getElementById("problemPar").innerHTML = "";
		//document.getElementById("historyPat").innerHTML = "";
		document.getElementById("new:message-text").value = "";
		document.getElementById("new:thisQueryId").value = "";

		var button = $(event.relatedTarget) // Button that triggered the modal
		var recipient = button.data('whatever') // Extract info from data-* attributes
		document.getElementById("problemPar").innerHTML = recipient;
		//var recipientHis = button.data('history') // Extract info from data-* attributes
		//document.getElementById("historyPat").innerHTML = recipientHis;
		
		document.getElementById("new:thisQueryId").value = button.data('qid');

	})

	function showModal(thisBtn) {

		var button = $(thisBtn.relatedTarget);
		document.getElementById("problemPar").innerHTML = "test";
		$('#exampleModal').modal() // initialized with defaults
		$('#exampleModal').modal('show')

	}

	var ajaxRequest; // The variable that makes Ajax possible!
	function ajaxFunction() {
		try {

			// Opera 8.0+, Firefox, Safari
			ajaxRequest = new XMLHttpRequest();
		} catch (e) {

			// Internet Explorer Browsers
			try {
				ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {

				try {
					ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {

					// Something went wrong
					alert("Your browser broke!");
					return false;
				}
			}
		}
	}

	function submitReply() {

		ajaxFunction();

		// Here processRequest() is the callback function.
		ajaxRequest.onreadystatechange = processRequest;

		var url = "CabController?addrLine="
				+ escape(document.getElementById("addrLine").value)
				+ "&addrLine_end="
				+ escape(document.getElementById("addrLine_end").value);

		ajaxRequest.open("GET", url, true);
		ajaxRequest.send(null);
	}

	function processRequest(response) {
		if (ajaxRequest.readyState == 4) {
			if (ajaxRequest.status == 200) {

				var parseText = eval("(" + ajaxRequest.response + ")")
				var msg = "Cab not found please try again";
				if (parseText.success == "true") {
					msg = "Cab :"
							+ parseText.vehicle_model
							+ " , "
							+ parseText.cab_no
							+ "<br>"
							+ "Driver : "
							+ parseText.Driver_Name
							+ "<br>"
							+ "Phone : "
							+ parseText.Phone_No
							+ "<br>"
							+ "Cab wiil reach to you within 6 minutes. Do you want to book the cab?"
					document.getElementById("bookBtn").style.display = 'block';
				}

				document.getElementById("cabInfo").innerHTML = msg;
				document.getElementById("showCab").style.display = 'block';

			}
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

				<h3>NEW QUERIES</h3>
				<h:form id="new">


					<h:dataTable id="patientQueryTable"
						value="#{doctorBean.newQueriesList}" var="patque" border="1"
						styleClass="table table-striped table-condensed table-bordered table-hover">



						<h:column>
							<f:facet name="header">
								<h:outputText value="Category" />
							</f:facet>
							<h:outputText value="#{patque.queryCategory}"></h:outputText>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Description" />
							</f:facet>


							<a href="#" data-toggle="popover" title="Description"
								data-html="true"
								data-content="<div>
								<h:outputText value="#{patque.queryDescription}"></h:outputText>
								</div> ">
								<h:outputText value="#{patque.queryDescription}"></h:outputText>..
							</a>
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="Date Posted" />
							</f:facet>
							<h:outputText value="#{patque.queryDate}"></h:outputText>
						</h:column>

						

						<h:column>
							<f:facet name="header">
								<h:outputText value="Reply" />
							</f:facet>

							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal"
								data-whatever="<div>
								<h:outputText value="#{patque.queryDescription}"></h:outputText>
								</div>" 
								data-history="<div>
								<h:outputText value="(Date: #{patque.problemDate}) #{patque.problemDescription}"></h:outputText>
								</div>" 
								
								data-qid="<h:outputText value="#{patque.queryId}"></h:outputText>">

								Post reply</button>
						</h:column>

						<%-- 					
						<h:column>
							<f:facet name="header">
								<h:outputText value="Doctor Reply" />
							</f:facet>
							<h:outputText value="#{patque.doctorsReply}"></h:outputText>
						</h:column>
--%>
					</h:dataTable>

					<br>
					<input type="button" value="Back" onclick="cancelPage();"
						class="btn btn-success" />



					<h:commandLink id="cmdLnkIdSuppliers" immediate="true"
						action="#{loginBean.goToMyHome}" value="">
						<f:verbatim></f:verbatim>
					</h:commandLink>

					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="exampleModalLabel">Send a
										reply.</h4>
								</div>
								
								<div class="modal-body">
									<div class="form-group">
										<label for="recipient-name" class="control-label"
											style="color: #265a88;">Problem Description:</label><br>
										<label id="problemPar"></label>
									</div>
									
<!-- 									<div class="form-group">
										<label for="recipient-name" class="control-label"
											style="color: #265a88;">Patient History:</label><br>
										<label id="historyPat"></label>
									</div>								
 -->									
									
									<div class="form-group">
										<label for="message-text" class="control-label"
											style="color: #265a88;">Reply:</label>
										<h:inputTextarea styleClass="form-control" id="message-text" cols="6"
											rows="6" value="#{doctorBean.queryAnswer}"></h:inputTextarea>
											<h:inputHidden value="#{doctorBean.selectedQuery}" id="thisQueryId"/>
									</div>
								</div>
								
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<h:commandButton action="#{doctorBean.submitQueryAnswer}"
										value="Submit Answer" styleClass="btn btn-success">

									</h:commandButton>
								</div>
							</div>
						</div>


					</div>
				</h:form>

			</div>
		</div>


	</f:view>

</body>
</html>