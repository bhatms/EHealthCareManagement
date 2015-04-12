package com.ehm.db.model;

public class Doctor {

	private int doctorId;
	private String firstName;
	private String lastName;
	private String qualification;
	private String registrationNum;
	private String specialization;
	private String designation;
	private String visitingDays;
	private String visitingHours;
	private String emailId;
	private String phoneNum;

	
	
	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

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
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return the registrationNum
	 */
	public String getRegistrationNum() {
		return registrationNum;
	}

	/**
	 * @param registrationNum the registrationNum to set
	 */
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the visitingDays
	 */
	public String getVisitingDays() {
		return visitingDays;
	}

	/**
	 * @param visitingDays the visitingDays to set
	 */
	public void setVisitingDays(String visitingDays) {
		this.visitingDays = visitingDays;
	}

	/**
	 * @return the visitingHours
	 */
	public String getVisitingHours() {
		return visitingHours;
	}

	/**
	 * @param visitingHours the visitingHours to set
	 */
	public void setVisitingHours(String visitingHours) {
		this.visitingHours = visitingHours;
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
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
