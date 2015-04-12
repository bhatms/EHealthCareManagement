package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import com.ehm.db.model.PatientQuery;


public interface PatientQueryDao {

	List<PatientQuery> patientQuery(int patientId) throws SQLException, ClassNotFoundException;
}
