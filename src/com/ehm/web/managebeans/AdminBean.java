package com.ehm.web.managebeans;

import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.impl.AdminDao;
import com.ehm.db.impl.AdminDaoImpl;
import com.ehm.db.model.Doctor;
import com.ehm.db.model.Patient;
import com.ehm.db.model.PatientQuery;

public class AdminBean {


	private List<Doctor> allDoctors;

	private List<SelectItem> specalizationList;

	private List<Patient> patientList	;

	private String filterSpecalization;

	private Doctor selectedDoctor;

	private Patient selectedPatient;

	private String filterFromDate;

	private String filterToDate;
	
	private List<PatientQuery> displayQueryList;





	/**
	 * @return the allDoctors
	 */
	public List<Doctor> getAllDoctors() {
		return allDoctors;
	}

	/**
	 * @param allDoctors the allDoctors to set
	 */
	public void setAllDoctors(List<Doctor> allDoctors) {
		this.allDoctors = allDoctors;
	}

	/**
	 * @return the specalizationList
	 */
	public List<SelectItem> getSpecalizationList() {
		return specalizationList;
	}

	/**
	 * @param specalizationList the specalizationList to set
	 */
	public void setSpecalizationList(List<SelectItem> specalizationList) {
		this.specalizationList = specalizationList;
	}

	/**
	 * @return the patientList
	 */
	public List<Patient> getPatientList() {
		return patientList;
	}

	/**
	 * @param patientList the patientList to set
	 */
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	/**
	 * @return the selectedDoctor
	 */
	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	/**
	 * @param selectedDoctor the selectedDoctor to set
	 */
	public void setSelectedDoctor(Doctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	/**
	 * @return the selectedPatient
	 */
	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	/**
	 * @param selectedPatient the selectedPatient to set
	 */
	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	/**
	 * @return the filterSpecalization
	 */
	public String getFilterSpecalization() {
		return filterSpecalization;
	}

	/**
	 * @param filterSpecalization the filterSpecalization to set
	 */
	public void setFilterSpecalization(String filterSpecalization) {
		this.filterSpecalization = filterSpecalization;
	}

	/**
	 * @return the filterFromDate
	 */
	public String getFilterFromDate() {
		return filterFromDate;
	}

	/**
	 * @param filterFromDate the filterFromDate to set
	 */
	public void setFilterFromDate(String filterFromDate) {
		this.filterFromDate = filterFromDate;
	}

	/**
	 * @return the filterToDate
	 */
	public String getFilterToDate() {
		return filterToDate;
	}

	/**
	 * @param filterToDate the filterToDate to set
	 */
	public void setFilterToDate(String filterToDate) {
		this.filterToDate = filterToDate;
	}

	public String viewPatientQueries(){


		AdminDao adminDao = new AdminDaoImpl();
		
		displayQueryList = adminDao.getAllQyeries();
		return "goToAllPatientQueries";
	}

	public String filterPatientQueries(){



		return "patientQueryList";
	}

	public String assignQueriesToDoctor(){



		return "patientQueryList";
	}

	/**
	 * @return the displayQueryList
	 */
	public List<PatientQuery> getDisplayQueryList() {
		return displayQueryList;
	}

	/**
	 * @param displayQueryList the displayQueryList to set
	 */
	public void setDisplayQueryList(List<PatientQuery> displayQueryList) {
		this.displayQueryList = displayQueryList;
	}
	
	
}
