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

public class DoctorDaoImplTest implements BaseTest {

	final static Logger logger = Logger.getLogger(DoctorDaoImplTest.class);
	private DoctorDao docObj;
	
	private String specialization;
	
	private String fName;
	
	private String lName;
	

	@Before
	public void beforeSetting() {
		docObj = new DoctorDaoImpl();
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

		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetSpecializationList() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetSpecializationList() failed due to" + e);
		}
	}

	@Test
	public void testGetSpecializationList() {

		EhealthUtilDao docObj = new EhealthUtilDaoImpl();
		try {

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
}
