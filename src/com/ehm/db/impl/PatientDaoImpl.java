package com.ehm.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.Patient;
import com.ehm.db.model.PatientQuery;

public class PatientDaoImpl {
	
	private Connection dataConnection;

	public PatientDaoImpl() throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getDataConn();

	}

	public PatientDaoImpl(String forTest) throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getTestDataConn();

	}


	public Patient ceateNewAccount(Patient insertPatient) throws SQLException,
	ClassNotFoundException {


		String insertUserSQL = " INSERT INTO user "
				+ " ( email , password, role ) values ( ?, ?, ? ) ;";

		PreparedStatement preparedStatement1 = dataConnection
				.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);

		preparedStatement1.setString(1, insertPatient.getEmailId());
		preparedStatement1.setString(2, insertPatient.getPassword());
		preparedStatement1.setString(3, "P");

		preparedStatement1.executeUpdate();
		ResultSet rs1 = preparedStatement1.getGeneratedKeys();

		//System.out.println(rs1.getInt("user_id"));
		if(rs1.next()){
			int newUserId = rs1.getInt(1);
			


			
			String insertTableSQL = " INSERT INTO patient "
					+ " (first_name, last_name, address_line1, address_city,address_state, address_zip , "
					+ "phone_no , email , dob, gender, user_id ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ;";

			PreparedStatement preparedStatement2 = dataConnection
					.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement2.setString(1, insertPatient.getFirstName());
			preparedStatement2.setString(2, insertPatient.getLastName());
			preparedStatement2.setString(3, insertPatient.getAddrLine1());
			preparedStatement2.setString(4, insertPatient.getCity());
			preparedStatement2.setString(5, insertPatient.getState());
			preparedStatement2.setString(6, insertPatient.getZip());
			preparedStatement2.setString(7, insertPatient.getPhoneNum());
			preparedStatement2.setString(8, insertPatient.getEmailId());
			preparedStatement2.setString(9, insertPatient.getDob());
			preparedStatement2.setString(10, insertPatient.getGender());
			preparedStatement2.setInt(11, newUserId);

			preparedStatement2.executeUpdate();

			return getPatientByEmail(insertPatient.getEmailId());

		} 
			return null;
	}

	public Patient getPatientByEmail(String emailId)
			throws ClassNotFoundException, SQLException {

		String sqlStr = "select * from patient where email = ?";

		Patient newPatient = null;
		PreparedStatement ps = dataConnection.prepareStatement(
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
			//newPatient.setPassword(result.getString("password"));
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
		
		if(newPatient.getGender() != null && !newPatient.getGender().isEmpty()){

			if(sqlStr.toString().contains("?")){
				sqlStr.append(" , ");
			}

			sqlStr.append("  gender = ? ");
			paramList.add(newPatient.getGender());
		}

		sqlStr.append(" where email = ?");
		paramList.add(newPatient.getEmailId());

		System.out.println("**update patient query :"+sqlStr.toString());

		PreparedStatement preparedStatement = dataConnection
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


