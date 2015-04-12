package com.ehm.db.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.Patient;

public class PatientDaoImpl {


	public Patient ceateNewAccount(Patient insertPatient) throws SQLException,
	ClassNotFoundException {

		String insertTableSQL = " INSERT INTO patient "
				+ " (first_name, last_name, address_line1, address_city,address_state, address_zip , "
				+ "phone_no , email , password, dob, gender ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ;";

		PreparedStatement preparedStatement = EHMDataConnect.getDataConn()
				.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, insertPatient.getFirstName());
		preparedStatement.setString(2, insertPatient.getLastName());
		preparedStatement.setString(3, insertPatient.getAddrLine1());
		preparedStatement.setString(4, insertPatient.getCity());
		preparedStatement.setString(5, insertPatient.getState());
		preparedStatement.setString(6, insertPatient.getZip());
		preparedStatement.setString(7, insertPatient.getPhoneNum());
		preparedStatement.setString(8, insertPatient.getEmailId());
		preparedStatement.setString(9, insertPatient.getPassword());
		preparedStatement.setString(10, insertPatient.getDob());
		preparedStatement.setString(11, insertPatient.getGender());

		preparedStatement.executeUpdate();

		return getPatientByEmail(insertPatient.getEmailId());
	}

	public Patient getPatientByEmail(String emailId)
			throws ClassNotFoundException, SQLException {

		String sqlStr = "select * from patient where email = ?";

		Patient newPatient = null;
		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(
				sqlStr);
		ps.setString(1, emailId);

		ResultSet result = ps.executeQuery();

		while(result.next()){

			newPatient = new Patient();
			newPatient.setPatientId(result.getInt("patient_id"));
			newPatient.setFirstName(result.getString("first_name"));
			newPatient.setLastName(result.getString("last_name"));
			newPatient.setAddrLine1(result.getString("address_line1"));
			newPatient.setCity(result.getString("address_city"));
			newPatient.setState(result.getString("address_state"));
			newPatient.setZip(result.getString("address_zip"));
			newPatient.setPhoneNum(result.getString("phone_no"));
			newPatient.setEmailId(result.getString("email"));
			newPatient.setDob(result.getString("dob"));
			newPatient.setGender(result.getString("gender"));
			newPatient.setPassword(result.getString("password"));
		}

		return newPatient;
	}


	public Patient updateAndSaveProfile(Patient newPatient)
			throws ClassNotFoundException, SQLException {

		StringBuffer sqlStr = new StringBuffer("update patient set ");

		List<String> paramList = new ArrayList<String>();

		if(newPatient.getFirstName() != null && !newPatient.getFirstName().isEmpty()){
			sqlStr.append("  first_name = ? ");
			paramList.add(newPatient.getFirstName());
		}

		if(newPatient.getLastName() != null && !newPatient.getLastName().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" last_name = ?");
			paramList.add(newPatient.getLastName());
		}


		if(newPatient.getDob() != null && !newPatient.getDob().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" dob = ?");
			paramList.add(newPatient.getDob());
		}

		if(newPatient.getPhoneNum() != null && !newPatient.getPhoneNum().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" phone_no = ?");
			paramList.add(newPatient.getPhoneNum());
		}


		if(newPatient.getAddrLine1() != null && !newPatient.getAddrLine1().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" address_line1 = ?");
			paramList.add(newPatient.getAddrLine1());
		}


		if(newPatient.getState() != null && !newPatient.getState().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" address_state = ?");
			paramList.add(newPatient.getState());
		}

		if(newPatient.getCity() != null && !newPatient.getCity().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" address_city = ?");
			paramList.add(newPatient.getCity());
		}

		if(newPatient.getZip() != null && !newPatient.getZip().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}
			sqlStr.append(" address_zip = ?");
			paramList.add(newPatient.getZip());
		}

		sqlStr.append(" where email = ?");
		paramList.add(newPatient.getEmailId());
		
		System.out.println("**update patient query :"+sqlStr.toString());
		
		PreparedStatement preparedStatement = EHMDataConnect.getDataConn()
				.prepareStatement(sqlStr.toString());
		
		int cnt = 1;
		for (String paramVal : paramList) {
			preparedStatement.setString(cnt, paramVal);
			cnt++;
		}

		preparedStatement.executeUpdate();

		return newPatient;
	}
}
