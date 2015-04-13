package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.model.PatientQuery;

public interface AdminDao {
	
	List<PatientQuery> getAllQyeries() throws ClassNotFoundException, SQLException;

	void assignQueryToDoctor(PatientQuery insertPatientQuery) 
			throws SQLException, ClassNotFoundException;
	
	List<SelectItem> getQyeryByCateg(String category) throws ClassNotFoundException, SQLException;

	List<SelectItem> getDoctorByCateg(String selectedSpecl) throws ClassNotFoundException, SQLException;
	
	List<PatientQuery> getClosedQuery() throws SQLException, ClassNotFoundException;
	
	List<PatientQuery> getInProgressQuery() throws SQLException, ClassNotFoundException;
}
