package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import com.ehm.db.model.Doctor;
import com.ehm.db.model.PatientQuery;

public interface DoctorDao {
	
	List<Doctor> getSearchDoctorRecords(String specialization, String fName, String lName) throws SQLException;
	
	List<Doctor> getSearchDoctorRecords(String specialization);

	Doctor getDoctorProfile(int doctoId) throws SQLException;
	

	List<PatientQuery> getNewQuery(int doctorId) throws SQLException;
	
	List<PatientQuery> getOtherQuery(int doctorId) throws SQLException;

	Doctor getDoctorByEmail(String emailId) throws  SQLException;
	
	void saveQueryAnswer(int queryId, String queryAnswer) throws SQLException;
}
