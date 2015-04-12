package com.ehm.web.managebeans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.context.FacesContext;

import com.ehm.db.impl.PatientQueryDao;
import com.ehm.db.impl.PatientQueryDaoImpl;
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

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
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

		PatientQueryDao patientqueryDao = new PatientQueryDaoImpl();

		try {
			String selectedPatientId = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap()
					.get("loggedInPatient");
			if (selectedPatientId != null && !selectedPatientId.trim().isEmpty()) {
				patientQueryList = patientqueryDao.patientQuery(Integer.valueOf(selectedPatientId));
			}
			
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

	public void reset() {

		showQuery = false;

	}

}