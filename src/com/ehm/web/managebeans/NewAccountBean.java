package com.ehm.web.managebeans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import com.ehm.db.impl.EhealthUtilDao;
import com.ehm.db.impl.EhealthUtilDaoImpl;
import com.ehm.db.impl.PatientDaoImpl;
import com.ehm.db.model.Patient;

public class NewAccountBean {

	private String firstName;
	private String lastName;
	private String addressLine;
	private String zip;
	private String emailId;
	private String city;
	private String state;
	private List<SelectItem> stateList;
	private String phoneNo;
	private String password;
	private String confPassword;
	private String gender;
	private String dateOfBirth;
	private Patient currentPatient;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the addressLine
	 */
	public String getAddressLine() {
		return addressLine;
	}

	/**
	 * @param addressLine
	 *            the addressLine to set
	 */
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String saveAccount() {

		String saveResult = null;

		if(!password.equals(confPassword)){

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Password entered doesn't match please reenter.",
							"Please Try Again!"));
		}else{

			Patient newPatient = new Patient();
			newPatient.setFirstName(firstName);
			newPatient.setLastName(lastName);
			newPatient.setGender(gender);
			newPatient.setDob(dateOfBirth);
			newPatient.setPhoneNum(phoneNo);
			newPatient.setAddrLine1(addressLine);
			newPatient.setState(state);
			newPatient.setCity(city);
			newPatient.setZip(zip);
			newPatient.setEmailId(emailId);
			newPatient.setPassword(password);

			try {
				PatientDaoImpl patientDaoObj = new PatientDaoImpl();
				Patient addedPatient = patientDaoObj.ceateNewAccount(newPatient);
				if(addedPatient != null){
					saveResult = "navigateToLogin";
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Account created successfully. Please login to continue.",
									"Please Try Again!"));

					FacesContext context = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession) context.getExternalContext()
							.getSession(true);
					session.setAttribute("loggedInPatient", addedPatient);
					session.setAttribute("username", addedPatient.getEmailId());
					session.setAttribute("userfName", addedPatient.getFirstName());
					reset();
				}


			} catch (ClassNotFoundException e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Some error occured try again.",
								"Please Try Again!"));
				e.printStackTrace();
			} catch (SQLException e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Some error occured try again.",
								"Please Try Again!"));
				e.printStackTrace();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Some error occured try again.",
								"Please Try Again!"));
				e.printStackTrace();
			}

		}


		return saveResult;
	}

	public String viewPatientProfile() {
		reset();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		currentPatient = (Patient) session.getAttribute("loggedInPatient");

		firstName = currentPatient.getFirstName();
		lastName = currentPatient.getLastName();
		addressLine = currentPatient.getAddrLine1();
		zip = currentPatient.getZip();
		// emailId = currentPatient.getEmailId();
		city = currentPatient.getCity();
		state = currentPatient.getState();
		phoneNo = currentPatient.getPhoneNum();
		// password = currentPatient.getPassword();
		gender = currentPatient.getGender();
		dateOfBirth = currentPatient.getDob();

		return "navigatePatientProfile";
	}

	public String updateSaveProfile() {

		Patient newPatient = new Patient();

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		currentPatient = (Patient) session.getAttribute("loggedInPatient");
		boolean isUpdate = false;

		if (!firstName.equals(currentPatient.getFirstName())) {
			isUpdate = true;
			newPatient.setFirstName(firstName);
		}

		if (!lastName.equals(currentPatient.getLastName())) {
			isUpdate = true;
			newPatient.setLastName(lastName);
		}

		if (!dateOfBirth.equals(currentPatient.getDob())) {
			isUpdate = true;
			newPatient.setDob(dateOfBirth);
		}

		if (!phoneNo.equals(currentPatient.getPhoneNum())) {

			isUpdate = true;
			newPatient.setPhoneNum(phoneNo);
		}
		if (!addressLine.equals(currentPatient.getAddrLine1())) {
			isUpdate = true;
			newPatient.setAddrLine1(addressLine);
		}
		if (!city.equals(currentPatient.getCity())) {
			isUpdate = true;
			newPatient.setCity(city);
		}
		if (!zip.equals(currentPatient.getZip())) {
			isUpdate = true;
			newPatient.setZip(zip);
		}
		if (!state.equals(currentPatient.getState())) {
			isUpdate = true;
			newPatient.setState(state);
		}

		if (isUpdate) {
			
			newPatient.setEmailId(currentPatient.getEmailId());
			try {
				PatientDaoImpl patientDaoObj = new PatientDaoImpl();
				patientDaoObj.updateAndSaveProfile(newPatient);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Data updated successfully.", "Success"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, e
								.getMessage(), "error"));
			} catch (SQLException e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, e
								.getMessage(), "error"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, e
								.getMessage(), "error"));
			}
		}

		return null;
	}

	public String backToHome() {
		return "success";
	}

	/**
	 * @return the currentPatient
	 */
	public Patient getCurrentPatient() {
		return currentPatient;
	}

	/**
	 * @param currentPatient
	 *            the currentPatient to set
	 */
	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public void reset() {

		firstName = null;
		lastName = null;
		addressLine = null;
		zip = null;
		emailId = null;
		city = null;
		state = null;
		phoneNo = null;
		password = null;
		gender = null;
		dateOfBirth = null;
	}

	/**
	 * @return the stateList
	 */
	public List<SelectItem> getStateList() {

		if(stateList == null){
			
			try {
				EhealthUtilDao utilDao = new EhealthUtilDaoImpl();
				stateList = utilDao.getStateList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stateList;
	}

	/**
	 * @param stateList the stateList to set
	 */
	public void setStateList(List<SelectItem> stateList) {
		this.stateList = stateList;
	}

	/**
	 * @return the confPassword
	 */
	public String getConfPassword() {
		return confPassword;
	}

	/**
	 * @param confPassword the confPassword to set
	 */
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

}
