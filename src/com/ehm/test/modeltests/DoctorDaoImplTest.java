package com.ehm.test.modeltests;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ehm.db.impl.DoctorDao;
import com.ehm.db.impl.DoctorDaoImpl;
import com.ehm.db.impl.EhealthUtilDao;
import com.ehm.db.impl.EhealthUtilDaoImpl;
import com.ehm.db.model.Doctor;
import com.ehm.db.model.PatientQuery;

public class DoctorDaoImplTest implements BaseTest {

	final static Logger logger = Logger.getLogger(DoctorDaoImplTest.class);
	private DoctorDao docObj;
	
	private String specialization;
	
	private String fName;
	
	private String lName;
	

	@Before
	public void beforeSetting() throws ClassNotFoundException, SQLException {
		docObj = new DoctorDaoImpl("testing");
	}

	@After
	public void afterSetting() {

	}

	@Test
	public void testGetSearchDoctorRecords() {
		try {
			
			createSearchDoctorStub(null,null,null);

			List<Doctor> testDocList = docObj.getSearchDoctorRecords(specialization, fName, lName);

			if (testDocList == null || testDocList.isEmpty()) {
				Assert.assertNull("No record found");
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetSearchDoctorRecords() failed due to" + e);
		}
	}
	
	@Test
	public void testGetDoctorProfile1() {
		try {

			Doctor testDoc = docObj.getDoctorProfile(Integer.valueOf("1"));

			if (testDoc == null) {
				Assert.assertNull("No record found");
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorProfile1() failed due to" + e);
		}
	}
	
	
	@Test
	public void testGetDoctorProfile2() {
		try {

			Doctor testDoc = docObj.getDoctorProfile(Integer.valueOf("-999"));

			if (testDoc == null) {
				Assert.assertNull("No record found");
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorProfile2() failed due to" + e);
		}
	}

	@Test
	public void testGetSpecializationList() {

		
		try {
			EhealthUtilDao docObj = new EhealthUtilDaoImpl("testing");
			List<SelectItem> testSpecList = docObj.getSpecializationList();

			if (testSpecList == null || testSpecList.isEmpty()) {
				System.out.println("Fail test no specialization list in database.");
			}

		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetSpecializationList() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetSpecializationList() failed due to" + e);
		}

	}

	
	private void createSearchDoctorStub(String firstNme, String lastName, String special){
		
		fName = firstNme;
		lName = lastName;
		specialization = special;
		
	}
	
	@Test
	public void testGetNewQueryInvalidId() {
		try {
			List<PatientQuery> testGetNewQueryList = docObj.getNewQuery(Integer.valueOf("-9999"));
			if (testGetNewQueryList == null) {
				Assert.assertNull(testGetNewQueryList);
			} else{
				Assert.assertTrue("No result found for invalid doctor id - New Query ", testGetNewQueryList.isEmpty());
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetNewQuery() failed due to" + e);
		}
	}


	@Test
	public void testGetNewQueryValidId() {
		try {
			List<PatientQuery> testGetNewQueryList = docObj.getNewQuery(Integer.valueOf("2"));
			if (testGetNewQueryList != null && testGetNewQueryList.isEmpty()) {
				Assert.assertNull("No datafound",testGetNewQueryList);
			} else {
				Assert.assertNotNull("Patients and their corresponding Query's found for this doctor", testGetNewQueryList.get(0).getQueryDescription());
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetNewQuery() failed due to" + e);
		}
	}

	@Test
	public void testGetOtherQueryInvalidId() {
		try {
			List<PatientQuery> testGetOtherQueryList = docObj.getOtherQuery(Integer.valueOf("-9999"));
			if (testGetOtherQueryList == null) {
				Assert.assertNull(testGetOtherQueryList);
			} else{
				Assert.assertTrue("No result found for invalid doctor id - Other Query ", testGetOtherQueryList.isEmpty());
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetOtherQuery() failed due to" + e);
		}
	}

	@Test
	public void testGetOtherQueryValidId() {
		try {
			List<PatientQuery> testGetOtherQueryList = docObj.getOtherQuery(Integer.valueOf("2"));
			if (testGetOtherQueryList != null && testGetOtherQueryList.isEmpty()) {
				Assert.assertNull("No datafound",testGetOtherQueryList);
			} else {
				Assert.assertNotNull("Patients and their corresponding Query's found for this doctor", testGetOtherQueryList.get(0).getQueryDescription());
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetNewQuery() failed due to" + e);
		}
	}
	
	
	@Test
	public void testGetDoctorByEmail1() {
		try {

			Doctor testDoc = docObj.getDoctorByEmail("dsajja@uncc.edu");

			if (testDoc == null) {
				Assert.assertNull("No record found");
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorByEmail1() failed due to" + e);
		}
	}
	
	
	@Test
	public void testGetDoctorByEmail2() {
		try {

			Doctor testDoc = docObj.getDoctorByEmail("rdusari@uncc.edu");

			if (testDoc == null) {
				Assert.assertNull("No record found");
			}

		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorByEmail2() failed due to" + e);
		}
	}
	
}