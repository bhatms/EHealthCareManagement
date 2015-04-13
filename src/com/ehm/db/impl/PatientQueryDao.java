package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.model.PatientQuery;


public interface PatientQueryDao {

	List<PatientQuery> patientQuery(int patientId) throws SQLException, ClassNotFoundException;

	List<SelectItem> getPatientCategoryList() throws ClassNotFoundException, SQLException;

	void insertPatientQueryRecords(PatientQuery insertPatientQuery) throws SQLException, ClassNotFoundException;
}
