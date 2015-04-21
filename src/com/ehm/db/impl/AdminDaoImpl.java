package com.ehm.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.PatientQuery;

public class AdminDaoImpl  implements AdminDao{


	private Connection dataConnection;

	public AdminDaoImpl() throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getDataConn();

	}

	public AdminDaoImpl(String forTest) throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getTestDataConn();

	}



	public List<PatientQuery> getAllQyeries() throws ClassNotFoundException, SQLException {


		StringBuffer sqlBuf = new StringBuffer("select * from patient_query where query_status = 'New' "
				+ " order by query_date ");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		// get customer data from database

		ResultSet result = ps.executeQuery();

		List<PatientQuery> list = new ArrayList<PatientQuery>();

		while (result.next()) {
			PatientQuery patientQuery = new PatientQuery();

			//patient_id, query_category, query_description, query_status, query_date, doctor_id ,doctors_reply
			patientQuery.setPatientId(result.getInt("patient_id"));
			patientQuery.setQueryId(result.getInt("query_id"));
			patientQuery.setQueryCategory(result.getString("query_category"));
			patientQuery.setQueryDescription(result.getString("query_description"));
			patientQuery.setQueryStatus(result.getString("query_status"));
			patientQuery.setQueryDate(result.getDate("query_date"));
			patientQuery.setDoctorId(result.getInt("doctor_id"));
			patientQuery.setDoctorsReply(result.getString("doctors_reply"));

			list.add(patientQuery);
		}

		return list;

	}



	public void assignQueryToDoctor(PatientQuery insertPatientQuery) 
			throws SQLException, ClassNotFoundException {

		StringBuffer insertTableSQL = new StringBuffer(" update patient_query ");
		insertTableSQL.append(" set doctor_id = ? , query_status = ? where query_id = ? ");

		PreparedStatement preparedStatement = dataConnection.prepareStatement(insertTableSQL.toString());
		System.out.println(insertTableSQL.toString());
		preparedStatement.setInt(1, insertPatientQuery.getDoctorId());
		preparedStatement.setString(2,"In-Progress");
		preparedStatement.setInt(3, insertPatientQuery.getQueryId());
		preparedStatement.executeUpdate();

	}

	public List<SelectItem> getQyeryByCateg(String category) throws ClassNotFoundException, SQLException {


		StringBuffer sqlBuf = new StringBuffer("select query_id, query_description "
				+ " from patient_query where query_status = 'New' "
				+ " and query_category = ?");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		ps.setString(1, category);

		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();

		list.add(new SelectItem("0", "Select Query"));

		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(Integer.toString(result.getInt("query_id")));
			item.setLabel(result.getString("query_description"));

			list.add(item);
		}

		return list;

	}



	public List<SelectItem> getDoctorByCateg(String category)
			throws ClassNotFoundException, SQLException {
		StringBuffer sqlBuf = new StringBuffer("select doctor_id, first_name , last_name "
				+ " from doctor where  specialization_id = ?");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		ps.setString(1, category);

		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("0", "Select Doctor"));
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(Integer.toString(result.getInt("doctor_id")));
			item.setLabel(result.getString("first_name") +" "+result.getString("last_name"));

			list.add(item);
		}

		return list;	
	}

	public List<PatientQuery> getClosedQuery() throws SQLException, ClassNotFoundException {

		StringBuffer sqlBuf = new StringBuffer("select * from patient_query where query_status = ? ");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());

		ps.setString(1, "Closed");


		ResultSet result = ps.executeQuery();

		List<PatientQuery> closedList = new ArrayList<PatientQuery>();

		while (result.next()) {
			PatientQuery patientQuery = new PatientQuery();

			patientQuery.setPatientId(result.getInt("patient_id"));
			patientQuery.setQueryId(result.getInt("query_id"));
			patientQuery.setQueryCategory(result.getString("query_category"));
			patientQuery.setQueryDescription(result.getString("query_description"));
			patientQuery.setQueryDate(result.getDate("query_date"));
			patientQuery.setDoctorId(result.getInt("doctor_id"));
			patientQuery.setDoctorsReply(result.getString("doctors_reply"));
			closedList.add(patientQuery);
		}



		return closedList;
	}



	public List<PatientQuery> getInProgressQuery() throws SQLException, ClassNotFoundException{

		StringBuffer sqlBuf = new StringBuffer("select * from patient_query where query_status = ?");

		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());

		ps.setString(1, "In-Progress");


		ResultSet result = ps.executeQuery();

		List<PatientQuery> inProgressList = new ArrayList<PatientQuery>();

		while (result.next()) {
			PatientQuery patientQuery = new PatientQuery();

			patientQuery.setPatientId(result.getInt("patient_id"));
			patientQuery.setQueryId(result.getInt("query_id"));
			patientQuery.setQueryCategory(result.getString("query_category"));
			patientQuery.setQueryDescription(result.getString("query_description"));
			patientQuery.setQueryDate(result.getDate("query_date"));
			patientQuery.setDoctorId(result.getInt("doctor_id"));
			patientQuery.setDoctorsReply(result.getString("doctors_reply"));
			inProgressList.add(patientQuery);

		}


		return inProgressList;
	}

}
