package com.ehm.web.managebeans;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ehm.db.impl.DoctorDao;
import com.ehm.db.impl.DoctorDaoImpl;
import com.ehm.db.impl.LoginDao;
import com.ehm.db.impl.LoginDaoImpl;
import com.ehm.db.impl.PatientDaoImpl;
import com.ehm.db.model.Doctor;
import com.ehm.db.model.Patient;
import com.ehm.db.model.User;

public class LoginBean {

	private String email;
	private String password;
	private boolean loginError;

	public LoginBean() {
		resetFields();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*	public String validAndLoginUser() {
		
		String loginResult = "failure";
		loginError = true;

		try {
			LoginDao loginDao = new LoginDaoImpl();
			Patient logedPatient = loginDao.validate(email, password);

			if (logedPatient != null) {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) context
						.getExternalContext().getSession(true);
				session.setAttribute("loggedInPatient", logedPatient);
				session.setAttribute("email", logedPatient.getEmailId());
				session.setAttribute("userfName", logedPatient.getFirstName());
				loginError = false;
				loginResult = "success";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Invalid email or password.",
								"Please Try Again!"));
				loginResult = "failure";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginResult;
	}*/

	public String validateLogin() {
		
		String loginResult = "failure";
		loginError = true;
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context
				.getExternalContext().getSession(true);
		
		try {
			LoginDao loginDao = new LoginDaoImpl();
			User logedUser = loginDao.validateLogin(email, password);

			if (logedUser != null) {

				session.setAttribute("role", logedUser.getRole());

				if ("P".equals(logedUser.getRole())) {

					PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
					
					Patient loginPatient = patientDaoImpl.getPatientByEmail(logedUser.getEmailId());
					session.setAttribute("loggedInPatient", loginPatient);
					//session.setAttribute("loggedInUser", logedUser);
					session.setAttribute("email", logedUser.getEmailId());
					session.setAttribute("userfName", loginPatient.getFirstName());
					loginError = false;
					loginResult = "navigatePatientHome";

				} else if ("A".equals(logedUser.getRole())) {
					session.setAttribute("userfName", logedUser.getEmailId());
					loginResult = "navigateAdminHome";
				} else {
					DoctorDao docDao = new DoctorDaoImpl();
					Doctor loginDoc = docDao.getDoctorByEmail(logedUser.getEmailId());
					session.setAttribute("loggedInDoctor", loginDoc);
					session.setAttribute("email", logedUser.getEmailId());
					session.setAttribute("userfName", loginDoc.getFirstName());
					loginError = false;
					loginResult = "navigateDoctorHome";
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Invalid email or password.",
								"Please Try Again!"));
				loginResult = "failure";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginResult;
	}

	public String goToMyHome() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		String returnPath = null; 
		if(session != null && "P".equals(session.getAttribute("role"))){
			returnPath = "navigatePatientHome"; 
		} else if(session != null && "A".equals(session.getAttribute("role"))){
			returnPath = "navigateAdminHome"; 
		} else if(session != null && "D".equals(session.getAttribute("role"))){
			returnPath = "navigateDoctorHome"; 
		} 
		return returnPath;
	}

	public String userLogout() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		session.removeAttribute("loggedInPatient");
		session.removeAttribute("email");
		session.removeAttribute("userfName");
		session.invalidate();

		resetFields();
		return "navigateToHomePage";
	}

	private void resetFields() {

		email = null;
		password = null;
		loginError = false;

	}

	/**
	 * @return the loginError
	 */
	public boolean isLoginError() {
		return loginError;
	}

	/**
	 * @param loginError
	 *            the loginError to set
	 */
	public void setLoginError(boolean loginError) {
		this.loginError = loginError;
	}
}