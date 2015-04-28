package com.ehm.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.PatientQuery;

public class PatientQueryDaoImpl implements PatientQueryDao {
	
	private Connection dataConnection;

	public PatientQueryDaoImpl() throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getDataConn();

	}

	public PatientQueryDaoImpl(String forTest) throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getTestDataConn();

	}

	public List<PatientQuery> patientQuery(int patientId) throws SQLException, ClassNotFoundException {

		/*
		 * Class.forName("com.mysql.jdbc.Driver"); connection =
		 * DriverManager.getConnection
		 * ("jdbc:mysql://127.0.0.1:3306/ssdi","root","123456");
		 */

		PreparedStatement ps = dataConnection.prepareStatement(
				"Select * from patient_query where patient_id = ? order by query_status desc ,"
				+ " query_date desc");
		
		ps.setInt(1, patientId);
		List<PatientQuery> list = new ArrayList<PatientQuery>();
		ResultSet resultSet = ps.executeQuery();
		PatientQuery patque = null;
		
		while(resultSet.next()){ 
			patque = new PatientQuery();
			patque.setQueryCategory(resultSet.getString("query_category"));
			patque.setQueryDescription(resultSet.getString("query_description"));
			patque.setQueryStatus(resultSet.getString("query_status"));
			patque.setQueryDate(resultSet.getDate("query_date"));
			patque.setDoctorsReply(resultSet.getString("doctors_reply"));
			list.add(patque);
		}
		return list;
	}

	
	public List<SelectItem> getPatientCategoryList() throws ClassNotFoundException, SQLException {

		StringBuffer sqlBuf = new StringBuffer("select * from specializations ");


		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		// get customer data from database
		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("select","Select"));
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(result.getString("special_id"));
			item.setLabel(result.getString("special_title"));
			list.add(item);
		}

		return list;

	}
	
	public void insertPatientQueryRecords(PatientQuery insertPatientQuery) 
			throws SQLException, ClassNotFoundException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();
	     
//	    System.out.println(insertPatientQuery.getPatientId()+insertPatientQuery.getPatientCategory()+
//	    		insertPatientQuery.getPatientDescription()+"New"+dateFormat.format(date));

	    
	    StringBuffer insertTableSQL = new StringBuffer(" INSERT INTO patient_query ");
	    insertTableSQL.append(" (patient_id, query_category, query_description, query_status, query_date) ");
	    insertTableSQL.append(" values ( ?, ?, ?, ?, ?); ");


		PreparedStatement preparedStatement = dataConnection.prepareStatement(insertTableSQL.toString());
		System.out.println(insertTableSQL.toString());
		preparedStatement.setInt(1, insertPatientQuery.getPatientId());
		preparedStatement.setString(2, insertPatientQuery.getPatientCategory());
		preparedStatement.setString(3, insertPatientQuery.getPatientDescription());
		preparedStatement.setString(4, "New");
		preparedStatement.setString(5, dateFormat.format(date));
		preparedStatement.executeUpdate();
	
	}

}
