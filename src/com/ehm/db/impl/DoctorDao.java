package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import com.ehm.db.model.Doctor;

public interface DoctorDao {
	
	List<Doctor> getSearchDoctorRecords(String specialization, String fName, String lName) throws SQLException, ClassNotFoundException;
	
	List<Doctor> getSearchDoctorRecords(String specialization);

	Doctor getDoctorProfile(int doctoId) throws ClassNotFoundException, SQLException;

}
