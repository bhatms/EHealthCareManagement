/**
 * 
 */
package com.ehm.db.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.Doctor;

/**
 * @author MadhaviBhat
 *
 */
public class DoctorDaoImpl implements DoctorDao {

	public List<Doctor> getSearchDoctorRecords(String specialization,
			String fName, String lName) throws SQLException, ClassNotFoundException {

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


		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
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




	public List<SelectItem> getSpecializationList() throws ClassNotFoundException, SQLException {

		StringBuffer sqlBuf = new StringBuffer("select * from specializations ");


		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
		// get customer data from database
		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("all","All"));
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(result.getString("special_id"));
			item.setLabel(result.getString("special_title"));
			list.add(item);
		}

		return list;

	}

	/*	public List<Doctor> getDoctorProfile(int doctorId) throws SQLException, ClassNotFoundException{

		//		List<String> parameterList = new ArrayList<String>();

		StringBuffer sqlBuf = new StringBuffer("select * from doctor ");
		if (doctorId != 0) {
			sqlBuf.append(" where doctor_ID = ?1 ");
			//			parameterList.add(doctorId);
		}


		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
		// get customer data from database
		//		int cnt = 1;
		//		for (String param : parameterList) {
		//			ps.setString(cnt, param);
		//			cnt++;
		//		}
		ps.setInt(1, doctorId);

		ResultSet result = ps.executeQuery();

		List<Doctor> list = new ArrayList<Doctor>();

		//		while (result.next()) {
		Doctor doct = new Doctor();
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

		list.add(doct);
		//		}

		return list;
	}*/

	public Doctor getDoctorProfile(int doctorId) throws ClassNotFoundException, SQLException {

		Doctor doct = null;
		StringBuffer sqlBuf = new StringBuffer("select * from doctor ");
		sqlBuf.append(" where doctor_ID = ? ");

		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
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


}
