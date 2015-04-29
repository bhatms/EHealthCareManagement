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
import com.ehm.db.impl.PatientQueryDao;
import com.ehm.db.impl.PatientQueryDaoImpl;
import com.ehm.db.model.Patient;
import com.ehm.db.model.PatientQuery;

public class PatientBean {

	private int patientId;
	private boolean showQuery;

	private String queryCategory;
	private String queryDescription;
	private String queryStatus;
	private String queryDate;
	private String doctorsReply;
	private List<PatientQuery> patientQueryList;

	
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
	private String gender;
	private String dateOfBirth;
	private Patient currentPatient;

	
	private List<SelectItem> patientCategoryList;
	private String patientCategory;
	private String patientDescription;


	
	private String patientHistoryDescription;	
	private String patientHistoryDate;
	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	public String getPatientHistoryDate() {
		return patientHistoryDate;
	}

	public void setPatientHistoryDate(String patientHistoryDate) {
		this.patientHistoryDate = patientHistoryDate;
	}

	public String getPatientHistoryDescription() {
		return patientHistoryDescription;
	}

	public void setPatientHistoryDescription(String patientHistoryDescription) {
		this.patientHistoryDescription = patientHistoryDescription;
	}


	/**
	 * @param patientId
	 *            the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getQueryCategory() {
		return queryCategory;
	}

	public void setQueryCategory(String queryCategory) {
		this.queryCategory = queryCategory;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public String getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getDoctorsReply() {
		return doctorsReply;
	}

	public void setDoctorsReply(String doctorsReply) {
		this.doctorsReply = doctorsReply;
	}

	public List<PatientQuery> getPatientQueryList() {
		return patientQueryList;
	}

	public void setPatientQueryList(List<PatientQuery> patientQueryList) {
		this.patientQueryList = patientQueryList;
	}


	
	public String displayQuery() {

		try {
			PatientQueryDao patientqueryDao = new PatientQueryDaoImpl();
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext()
					.getSession(true);
			currentPatient = (Patient) session.getAttribute("loggedInPatient");

			int selectedPatientId = currentPatient.getPatientId();
			patientQueryList = patientqueryDao.patientQuery(Integer.valueOf(selectedPatientId));

			if (patientQueryList != null && !patientQueryList.isEmpty()) {
				showQuery = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "navigateToQueryPage";
	}
	
	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
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
	 * @param addressLine the addressLine to set
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
	 * @param zip the zip to set
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
	 * @param emailId the emailId to set
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
	 * @param city the city to set
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
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
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
	 * @param password the password to set
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
	 * @param gender the gender to set
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
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the currentPatient
	 */
	public Patient getCurrentPatient() {
		return currentPatient;
	}

	/**
	 * @param currentPatient the currentPatient to set
	 */
	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}


	public String saveAccount() {

		String saveResult = null;
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
			saveResult = "success";

			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext()
					.getSession(true);
			session.setAttribute("loggedInPatient", addedPatient);
			session.setAttribute("username", addedPatient.getEmailId());
			session.setAttribute("userfName", addedPatient.getFirstName());
			reset();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveResult;
	}

	public String viewPatientProfile() {
		reset();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		
		try {
			PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
			currentPatient = patientDaoImpl.getPatientByEmail(((Patient) session.getAttribute("loggedInPatient")).getEmailId());
			
			firstName = currentPatient.getFirstName().trim();
			lastName = currentPatient.getLastName().trim();
			addressLine = currentPatient.getAddrLine1();
			zip = currentPatient.getZip();
			// emailId = currentPatient.getEmailId();
			city = currentPatient.getCity();
			state = currentPatient.getState();
			phoneNo = currentPatient.getPhoneNum();
			//password = currentPatient.getPassword();
			gender = currentPatient.getGender();
			dateOfBirth = currentPatient.getDob();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
		if (!gender.equals(currentPatient.getGender())) {
			isUpdate = true;
			newPatient.setGender(gender);
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
				if(newPatient.getFirstName() != null){
					session.setAttribute("userfName",newPatient.getFirstName());
				}
				
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



	public void reset() {

		showQuery = false;
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


	
	public String insertPatientQuery() {

		String result = null;
		PatientQuery insertPatientQuery = new PatientQuery();
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context
				.getExternalContext().getSession(true);
		// =
			//	(Patient)session.getAttribute("loggedInPatient");
		Patient loginPatient = (Patient)session.getAttribute("loggedInPatient");
		int patientId = loginPatient.getPatientId();
		insertPatientQuery.setPatientId(patientId);
		insertPatientQuery.setPatientCategory(patientCategory);
		insertPatientQuery.setPatientDescription(patientDescription);

		
		try {

			PatientQueryDao patientQueryDao = new PatientQueryDaoImpl();
			patientQueryDao.insertPatientQueryRecords(insertPatientQuery);
			result = "navigatePatientHome";

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	

	/**
	 * @return the showQuery
	 */
	public boolean isShowQuery() {
		return showQuery;
	}

	/**
	 * @param showQuery
	 *            the showQuery to set
	 */
	public void setShowQuery(boolean showQuery) {
		this.showQuery = showQuery;
	}


	public List<SelectItem> getPatientCategoryList() {
		
		
		try {
			EhealthUtilDao eDao = new EhealthUtilDaoImpl();
			patientCategoryList = eDao.getCategoryList();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return patientCategoryList;
	}

	public void setPatientCategoryList(List<SelectItem> patientCategoryList) {
		this.patientCategoryList = patientCategoryList;
	}

	public String getPatientCategory() {
		return patientCategory;
	}

	public void setPatientCategory(String patientCategory) {
		this.patientCategory = patientCategory;
	}

	public String getPatientDescription() {
		return patientDescription;
	}

	public void setPatientDescription(String patientDescription) {
		this.patientDescription = patientDescription;
	}
	
	public String goToQuery() {
		
		return "navigateToQuery";
	}
	

}