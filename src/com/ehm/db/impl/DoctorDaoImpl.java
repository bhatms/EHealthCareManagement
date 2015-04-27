/**
 * 
 */
package com.ehm.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.Doctor;
import com.ehm.db.model.PatientQuery;

/**
 * @author MadhaviBhat
 *
 */
public class DoctorDaoImpl implements DoctorDao {

	private Connection dataConnection;

	public DoctorDaoImpl() throws ClassNotFoundException, SQLException {

		dataConnection = EHMDataConnect.getDataConn();

	}

	public DoctorDaoImpl(String forTest) throws ClassNotFoundException, SQLException {

		dataConnection = EHMDataConnect.getTestDataConn();

	}

	public List<Doctor> getSearchDoctorRecords(String specialization,
			String fName, String lName) throws SQLException {

		List<String> paramList = new ArrayList<String>();

		StringBuffer sqlBuf = new StringBuffer("select * from doctor ");
		if (specialization != null && !specialization.isEmpty()) {

			sqlBuf.append(" where specialization_id = ? ");
			paramList.add(specialization);
		}

		if (fName != null && !fName.isEmpty()) {
			if (specialization != null && !specialization.isEmpty()) {
				sqlBuf.append(" and first_name like ? ");
			} else {
				sqlBuf.append(" where first_name like ? ");
			}
			paramList.add("%"+fName+"%");
		}

		if (lName != null && !lName.isEmpty()) {
			if ((specialization != null && !specialization.isEmpty()) || (fName != null && !fName.isEmpty())) {
				sqlBuf.append(" and last_name like ? ");
			} else {
				sqlBuf.append(" where last_name like ? ");
			}
			paramList.add("%"+lName+"%");
		}

		sqlBuf.append(" order by specialization_id, first_name, last_name ");


		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		// get customer data from database
		int cnt = 1;
		for (String param : paramList) {
			ps.setString(cnt, param);
			cnt++;
		}
		ResultSet result = ps.executeQuery();

		List<Doctor> list = new ArrayList<Doctor>();

		while (result.next()) {
			Doctor doct = new Doctor();

			doct.setFirstName(result.getString("first_name"));
			doct.setLastName(result.getString("last_name"));
			doct.setSpecialization(result.getString("specialization_id"));
			doct.setDoctorId(result.getInt("doctor_id"));
			doct.setDesignation(result.getString("doctor_designation"));
			doct.setVisitingDays(result.getString("doctor_visiting_days"));
			doct.setVisitingHours(result.getString("doctor_visiting_Hours"));
			doct.setEmailId(result.getString("doctor_email"));
			doct.setPhoneNum(result.getString("doctor_phone_num"));
			list.add(doct);
		}

		return list;

	}

	public List<Doctor> getSearchDoctorRecords(String specialization) {
		// TODO Auto-generated method stub
		return null;
	}


	public Doctor getDoctorProfile(int doctorId) throws SQLException {

		Doctor doct = null;
		StringBuffer sqlBuf = new StringBuffer("select * from doctor ");
		sqlBuf.append(" where doctor_ID = ? ");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		ps.setInt(1, doctorId);

		ResultSet result = ps.executeQuery();

		while (result.next()) {
			doct = new Doctor();
			doct.setDoctorId(result.getInt("doctor_ID"));
			doct.setFirstName(result.getString("first_name"));
			doct.setLastName(result.getString("last_name"));
			doct.setQualification(result.getString("doctor_qualification"));
			doct.setRegistrationNum(result.getString("doctor_reg_num"));
			doct.setSpecialization(result.getString("specialization_id"));
			doct.setDesignation(result.getString("doctor_designation"));
			doct.setVisitingDays(result.getString("doctor_visiting_days"));
			doct.setVisitingHours(result.getString("doctor_visiting_Hours"));
			doct.setEmailId(result.getString("doctor_email"));
			doct.setPhoneNum(result.getString("doctor_phone_num"));
		}
		return doct;
	}

	public List<PatientQuery> getNewQuery(int doctorId) throws SQLException {

		StringBuffer sqlBuf = new StringBuffer("select * from patient_query where query_status = ? and doctor_ID = ? ");

		/*		StringBuffer sqlBuf = new StringBuffer("SELECT PQ.patient_id, PQ.query_id, "
				+ "PQ.query_category, PQ.query_description, PQ.query_date, "
				+ "PH.problem_description, PH.problem_date "
				+ "FROM patient_query AS PQ JOIN patient_history AS PH ON PQ.patient_id = PH.patient_id "
				+ "where query_status = ? and doctor_ID = ? ");*/


		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());

		ps.setString(1, "In-Progress");

		ps.setInt(2, doctorId);


		ResultSet result = ps.executeQuery();

		List<PatientQuery> newList = new ArrayList<PatientQuery>();



		/*		while (result.next()) {
			PatientQuery patientQuery = new PatientQuery();

			patientQuery.setPatientId(result.getInt("PQ.patient_id"));
			patientQuery.setQueryId(result.getInt("PQ.query_id"));
			patientQuery.setQueryCategory(result.getString("PQ.query_category"));
			patientQuery.setQueryDescription(result.getString("PQ.query_description"));
			patientQuery.setQueryDate(result.getDate("PQ.query_date"));
			patientQuery.setProblemDescription(result.getString("PH.problem_description"));
			patientQuery.setProblemDate(result.getString("PH.problem_date"));
			newList.add(patientQuery);
		}*/

		while (result.next()) {
			PatientQuery patientQuery = new PatientQuery();

			patientQuery.setPatientId(result.getInt("patient_id"));
			patientQuery.setQueryId(result.getInt("query_id"));
			patientQuery.setQueryCategory(result.getString("query_category"));
			patientQuery.setQueryDescription(result.getString("query_description"));
			patientQuery.setQueryDate(result.getDate("query_date"));
			//patientQuery.setProblemDescription(result.getString("PH.problem_description"));
			//patientQuery.setProblemDate(result.getString("PH.problem_date"));
			newList.add(patientQuery);

		}
		return newList;
	}



	public List<PatientQuery> getOtherQuery(int doctorId) throws SQLException{

		StringBuffer sqlBuf = new StringBuffer("select * from patient_query where query_status = ? and doctor_ID = ?");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());

		ps.setString(1, "Closed");

		ps.setInt(2, doctorId);


		ResultSet result = ps.executeQuery();

		List<PatientQuery> otherList = new ArrayList<PatientQuery>();

		while (result.next()) {
			PatientQuery patientQuery = new PatientQuery();

			patientQuery.setPatientId(result.getInt("patient_id"));
			patientQuery.setQueryId(result.getInt("query_id"));
			patientQuery.setQueryCategory(result.getString("query_category"));
			patientQuery.setQueryDescription(result.getString("query_description"));
			patientQuery.setQueryDate(result.getDate("query_date"));
			patientQuery.setDoctorsReply(result.getString("doctors_reply"));
			otherList.add(patientQuery);

		}


		return otherList;
	}

	public Doctor getDoctorByEmail(String emailId)
			throws SQLException {

		String sqlStr = "select * from doctor where doctor_email = ?";

		Doctor docObj = null;
		PreparedStatement ps = dataConnection.prepareStatement(
				sqlStr);
		ps.setString(1, emailId);

		ResultSet result = ps.executeQuery();

		while(result.next()){

			docObj = new Doctor();
			docObj.setDoctorId(result.getInt("doctor_ID"));
			docObj.setFirstName(result.getString("first_name"));
			docObj.setLastName(result.getString("last_name"));
			docObj.setQualification(result.getString("doctor_qualification"));
			docObj.setRegistrationNum(result.getString("doctor_reg_num"));
			docObj.setSpecialization(result.getString("specialization_id"));
			docObj.setDesignation(result.getString("doctor_designation"));
			docObj.setVisitingDays(result.getString("doctor_visiting_days"));
			docObj.setVisitingHours(result.getString("doctor_visiting_Hours"));
			docObj.setEmailId(result.getString("doctor_email"));
			docObj.setPhoneNum(result.getString("doctor_phone_num"));
		}

		return docObj;
	}


	public void saveQueryAnswer(int queryId, String queryAnswer ) throws SQLException{

		StringBuffer sqlBuf = new StringBuffer("update patient_query set doctors_reply = ?,"
				+ " query_status = ? where query_id = ?");

		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());

		ps.setString(1, queryAnswer);
		ps.setString(2, "Closed");
		ps.setInt(3, queryId);

		ps.executeUpdate();
	}
}
