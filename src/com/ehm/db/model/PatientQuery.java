package com.ehm.db.model;

import java.util.Date;

public class PatientQuery {

	private int patientId;
	private int queryId;
	private String queryCategory;
	private String queryDescription;
	private String queryStatus;
	// private Date queryDate;
	private String patientCategory;
	private String patientDescription;
	
	private Date queryDate;
	private int doctorId;
	private String doctorsReply;
	
	private String problemDescription;
	private String problemDate;
	private String doctorName;
	
	private String patientName;
	
	
	public String getProblemDescription() {
		return problemDescription;  
	}
	
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	
	
	public String getProblemDate() {
		return problemDate;
	}
	public void setProblemDate(String problemDate) {
		this.problemDate = problemDate;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
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
/*	public Date getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
*/
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorsReply() {
		return doctorsReply;
	}
	public void setDoctorsReply(String doctorsReply) {
		this.doctorsReply = doctorsReply;
	}
	
	/**
	 * @return the patientCategory
	 */
	public String getPatientCategory() {
		return patientCategory;
	}
	/**
	 * @param patientCategory the patientCategory to set
	 */
	public void setPatientCategory(String patientCategory) {
		this.patientCategory = patientCategory;
	}
	
	
	/**
	 * @return the patientDescription
	 */
	public String getPatientDescription() {
		return patientDescription;
	}
	/**
	 * @param patientDescription the patientDescription to set
	 */
	public void setPatientDescription(String patientDescription) {
		this.patientDescription = patientDescription;
	}
	/**
	 * @return the queryDate
	 */
	public Date getQueryDate() {
		return queryDate;
	}
	/**
	 * @param queryDate the queryDate to set
	 */
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}