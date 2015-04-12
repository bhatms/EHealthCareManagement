package com.ehm.db.impl;

import java.util.List;

import com.ehm.db.model.PatientQuery;

public interface AdminDao {
	
	List<PatientQuery> getAllQyeries();

}
