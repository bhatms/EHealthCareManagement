package com.ehm.db.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.PatientQuery;

public class PatientQueryDaoImpl implements PatientQueryDao {

	public List<PatientQuery> patientQuery(int patientId) throws SQLException, ClassNotFoundException {

		/*
		 * Class.forName("com.mysql.jdbc.Driver"); connection =
		 * DriverManager.getConnection
		 * ("jdbc:mysql://127.0.0.1:3306/ssdi","root","123456");
		 */

		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(
				"Select * from patient_query where patient_id = ?");
		
		ps.setInt(1, patientId);
		List<PatientQuery> list = new ArrayList<PatientQuery>();
		ResultSet resultSet = ps.executeQuery();
		PatientQuery patque = null;
		
		while(resultSet.next()){ 
			patque = new PatientQuery();
			patque.setQueryCategory(resultSet.getString("query_category"));
			patque.setQueryDescription(resultSet.getString("query_description"));
			patque.setQueryStatus(resultSet.getString("query_status"));
			patque.setQueryDate(resultSet.getString("query_date"));
			patque.setDoctorsReply(resultSet.getString("doctors_reply"));
			list.add(patque);
		}
		return list;
	}

}
