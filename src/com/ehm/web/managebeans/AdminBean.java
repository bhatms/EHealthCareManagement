package com.ehm.web.managebeans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.ehm.db.impl.AdminDao;
import com.ehm.db.impl.AdminDaoImpl;
import com.ehm.db.impl.EhealthUtilDao;
import com.ehm.db.impl.EhealthUtilDaoImpl;
import com.ehm.db.model.Patient;
import com.ehm.db.model.PatientQuery;

public class AdminBean {


	private List<SelectItem> doctorByCateg;

	private List<SelectItem> specalizationList;

	private String filterSpecalization;
	
	private String filterCateory;

	private Patient selectedPatient;

	private String filterFromDate;

	private String filterToDate;

	private List<PatientQuery> displayQueryList;

	private List<SelectItem> queryByCategoryList;

	private String selectedQueryId;

	private String selectedDoctorId;

	private boolean showQueryList;

	private boolean showDoctorList;

	private List<PatientQuery> closedQueriesList;
	private List<PatientQuery> inProgressQueriesList;
	private boolean showClosed;
	private boolean showInProgress;






	public String viewClosedQueries() {
		showClosed = false;

		String result = null;
		try {
			AdminDao adminDao = new AdminDaoImpl();
			closedQueriesList = adminDao.getClosedQuery();
			if (closedQueriesList != null && !closedQueriesList.isEmpty()) {
				showClosed = true;
			}

			result = "navigateToClosedQuery";

		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	public String viewInProgressQueries() {
		showInProgress = false;

		String result = null;
		try {
			AdminDao adminDao = new AdminDaoImpl();
			inProgressQueriesList = adminDao.getInProgressQuery();
			if (inProgressQueriesList != null && !inProgressQueriesList.isEmpty()) {
				showInProgress = true;
			}
			result = "navigateToInProgressQuery";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	/**
	 * @return the specalizationList
	 */
	public List<SelectItem> getSpecalizationList() {

		try {
			EhealthUtilDao eDao = new EhealthUtilDaoImpl();
			specalizationList = eDao.getCategoryList();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return specalizationList;
	}

	/**
	 * @param specalizationList the specalizationList to set
	 */
	public void setSpecalizationList(List<SelectItem> specalizationList) {
		this.specalizationList = specalizationList;
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

		try {
			AdminDao adminDao = new AdminDaoImpl();
			displayQueryList = adminDao.getAllQyeries();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "goToAllPatientQueries";
	}

	public String viewAssignQueries(){


		showDoctorList = false;

		showQueryList = false;

		return "goToAllPatientQueries";

	}


	public String getFilterQueries(){

		if(!"0".equals(filterSpecalization)){
			
			try {
				AdminDao adminDao = new AdminDaoImpl();
				queryByCategoryList = adminDao.getQyeryByCateg(filterSpecalization);


				if(queryByCategoryList != null && queryByCategoryList.size() > 1){
					showQueryList = true;
					doctorByCateg = adminDao.getDoctorByCateg(filterSpecalization);

				} else{

					showQueryList = false;
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									"No queries under this category",
									"Please Try Again!"));

				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			showQueryList = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Please select the category",
							"Please Try Again!"));

		}


		return null;
	}

	public String assignQueries(){

		if(!"0".equals(selectedQueryId) && !"0".equals(selectedDoctorId)){
			try {
				AdminDao adminDao = new AdminDaoImpl();
				PatientQuery patientQuery = new PatientQuery();
				patientQuery.setQueryId(Integer.parseInt(selectedQueryId));
				patientQuery.setDoctorId(Integer.parseInt(selectedDoctorId));
				adminDao.assignQueryToDoctor(patientQuery);
				
				getFilterQueries();

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Operation completed successfully.",
								"Please Try Again!"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please select query and doctor to be assigned.",
							"Please Try Again!"));
		}

		return null;
	}

	public String filterPatientQueries(){



		return "patientQueryList";
	}

	public String goToAssignQueries(){



		return "navigateAssignQuery";
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

	/**
	 * @return the doctorByCateg
	 */
	public List<SelectItem> getDoctorByCateg() {
		return doctorByCateg;
	}

	/**
	 * @param doctorByCateg the doctorByCateg to set
	 */
	public void setDoctorByCateg(List<SelectItem> doctorByCateg) {
		this.doctorByCateg = doctorByCateg;
	}

	/**
	 * @return the queryBuCategoryList
	 */
	public List<SelectItem> getQueryByCategoryList() {
		return queryByCategoryList;
	}

	/**
	 * @param queryBuCategoryList the queryBuCategoryList to set
	 */
	public void setQueryByCategoryList(List<SelectItem> queryBuCategoryList) {
		this.queryByCategoryList = queryBuCategoryList;
	}


	/**
	 * @return the showQueryList
	 */
	public boolean isShowQueryList() {
		return showQueryList;
	}

	/**
	 * @param showQueryList the showQueryList to set
	 */
	public void setShowQueryList(boolean showQueryList) {
		this.showQueryList = showQueryList;
	}


	/**
	 * @return the showDoctorList
	 */
	public boolean isShowDoctorList() {
		return showDoctorList;
	}

	/**
	 * @param showDoctorList the showDoctorList to set
	 */
	public void setShowDoctorList(boolean showDoctorList) {
		this.showDoctorList = showDoctorList;
	}


	/**
	 * @return the selectedQueryId
	 */
	public String getSelectedQueryId() {
		return selectedQueryId;
	}

	/**
	 * @param selectedQueryId the selectedQueryId to set
	 */
	public void setSelectedQueryId(String selectedQueryId) {
		this.selectedQueryId = selectedQueryId;
	}

	/**
	 * @return the selectedDoctorId
	 */
	public String getSelectedDoctorId() {
		return selectedDoctorId;
	}

	/**
	 * @param selectedDoctorId the selectedDoctorId to set
	 */
	public void setSelectedDoctorId(String selectedDoctorId) {
		this.selectedDoctorId = selectedDoctorId;
	}


	public List<PatientQuery> getClosedQueriesList() {
		return closedQueriesList;
	}


	public void setClosedQueriesList(List<PatientQuery> closedQueriesList) {
		this.closedQueriesList = closedQueriesList;
	}


	public List<PatientQuery> getInProgressQueriesList() {
		return inProgressQueriesList;
	}


	public void setInProgressQueriesList(List<PatientQuery> inProgressQueriesList) {
		this.inProgressQueriesList = inProgressQueriesList;
	}


	public boolean isShowClosed() {
		return showClosed;
	}


	public void setShowClosed(boolean showClosed) {
		this.showClosed = showClosed;
	}


	public boolean isShowInProgress() {
		return showInProgress;
	}


	public void setShowInProgress(boolean showInProgress) {
		this.showInProgress = showInProgress;
	}


	/**
	 * @return the filterCateory
	 */
	public String getFilterCateory() {
		return filterCateory;
	}


	/**
	 * @param filterCateory the filterCateory to set
	 */
	public void setFilterCateory(String filterCateory) {
		this.filterCateory = filterCateory;
	}
}
