package com.ehm.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.Patient;
import com.ehm.db.model.User;

public class LoginDaoImpl implements LoginDao {
	
	private Connection dataConnection;

	public LoginDaoImpl() throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getDataConn();

	}

	public LoginDaoImpl(String forTest) throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getTestDataConn();

	}

	/*public Patient validate(String userEmail, String password) throws ClassNotFoundException, SQLException {

		
		 * Class.forName("com.mysql.jdbc.Driver"); connection =
		 * DriverManager.getConnection
		 * ("jdbc:mysql://127.0.0.1:3306/ssdi","root","123456");
		 
		Patient logedinPatient = null;

		PreparedStatement ps = dataConnection.prepareStatement(
				"Select * from patient where email = ? and password = ?");
		
		ps.setString(1, userEmail);
		ps.setString(2, password);

		ResultSet resultSet = ps.executeQuery();
		
		if(resultSet != null && resultSet.next()){
			logedinPatient = new Patient();
			logedinPatient.setFirstName(resultSet.getString("first_name"));
			logedinPatient.setLastName(resultSet.getString("last_name"));
			logedinPatient.setAddrLine1(resultSet.getString("address_line1"));
			logedinPatient.setCity(resultSet.getString("address_city"));
			logedinPatient.setZip(resultSet.getString("address_zip"));
			logedinPatient.setState(resultSet.getString("address_state"));
			logedinPatient.setEmailId(resultSet.getString("email"));
			logedinPatient.setPhoneNum(resultSet.getString("phone_no"));
			logedinPatient.setPatientId(resultSet.getInt("patient_id"));
			logedinPatient.setDob(resultSet.getString("dob"));
			logedinPatient.setGender(resultSet.getString("gender"));
		}
		
		return logedinPatient;
	}
	*/
	
	public User validateLogin(String userEmail, String password) throws ClassNotFoundException, SQLException {

		/*
		 * Class.forName("com.mysql.jdbc.Driver"); connection =
		 * DriverManager.getConnection
		 * ("jdbc:mysql://127.0.0.1:3306/ssdi","root","123456");
		 */
		User logedinUser = null;

		PreparedStatement ps = dataConnection.prepareStatement(
				"Select * from user where email = ? and password = ?");
		
		ps.setString(1, userEmail);
		ps.setString(2, password);

		ResultSet resultSet = ps.executeQuery();
		
		if(resultSet != null && resultSet.next()){
			logedinUser = new User();
			logedinUser.setUserId(resultSet.getInt("user_id"));
			logedinUser.setEmailId(resultSet.getString("email"));
			logedinUser.setPassword(resultSet.getString("password"));
			logedinUser.setRole(resultSet.getString("role"));
		}
		
		return logedinUser;
	}

}
