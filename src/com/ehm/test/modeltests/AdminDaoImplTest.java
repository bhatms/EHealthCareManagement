package com.ehm.test.modeltests;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ehm.db.impl.AdminDao;
import com.ehm.db.impl.AdminDaoImpl;
import com.ehm.db.model.PatientQuery;

public class AdminDaoImplTest implements BaseTest {


	final static Logger logger = Logger.getLogger(AdminDaoImplTest.class);
	private AdminDao adminDao;
	@Before
	public void beforeSetting() throws ClassNotFoundException, SQLException {

		adminDao = new AdminDaoImpl("testing");

	}

	@After
	public void afterSetting() {
		// TODO Auto-generated method stub

	}

	@Test
	public void testGetAllQueries() {
		try {
			List<PatientQuery> testPatientQueryList = adminDao.getAllQyeries();


			if(testPatientQueryList != null && !testPatientQueryList.isEmpty()){
				Assert.assertTrue("OP=pen queries found  ", !testPatientQueryList.isEmpty());

			} else{
				Assert.assertTrue("No new queries open",testPatientQueryList == null);
			}
		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetAllQueries() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetAllQueries() failed due to" + e);
		}
	}

	@Test
	public void testGetQueryByCateg1() {
		try {
			List<SelectItem> queryList = adminDao.getQyeryByCateg("Laptop");

			Assert.assertFalse("Invalid query category, test fail", queryList.size() > 2);

			Assert.assertTrue("Test pass for valid category", queryList.size() == 1);


		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetQueryByCateg1() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetQueryByCateg2() failed due to" + e);
		}
	}


	@Test
	public void testGetQueryByCateg2() {
		try {
			List<SelectItem> queryList = adminDao.getQyeryByCateg("Cardiology");

			Assert.assertFalse("Invalid query category, tets fail", queryList.size() < 2);


			Assert.assertFalse("Test fail for valid category", queryList.size() == 1);

			Assert.assertTrue("Test pass for valid category", !"0".equals(queryList.get(1).getLabel()));


		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetQueryByCateg2() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetQueryByCateg2() failed due to" + e);
		}
	}



	@Test
	public void testGetDoctorByCateg1() {
		try {
			List<SelectItem> docList = adminDao.getDoctorByCateg("Laptop");

			Assert.assertFalse("Invalid query category, test fail", docList.size() > 2);

			Assert.assertTrue("Test pass for valid category", docList.size() == 1);


		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorByCateg1() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorByCateg1() failed due to" + e);
		}
	}


	@Test
	public void testGetDoctorByCateg2() {
		try {
			List<SelectItem> docList = adminDao.getDoctorByCateg("General");

			Assert.assertFalse("Valid query category, test fail", docList.size() < 2);


			Assert.assertFalse("Test fail for valid category", docList.size() == 1);

			Assert.assertTrue("Test pass for valid category", !"0".equals(docList.get(1).getLabel()));


		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorByCateg2() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetDoctorByCateg2() failed due to" + e);
		}
	}


	@Test
	public void testGetInProgressQueries() {
		try {
			List<PatientQuery> testPatientQueryList = adminDao.getInProgressQuery();
				Assert.assertFalse("No In Progress queries open",testPatientQueryList == null);
				Assert.assertTrue("In Progress queries found  ", !testPatientQueryList.isEmpty());
		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetInProgressQueries() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetInProgressQueries() failed due to" + e);
		}
	}


	@Test
	public void testGetClosedQueries() {
		try {
			List<PatientQuery> testPatientQueryList = adminDao.getClosedQuery();
			
			Assert.assertTrue("No Closed queries found",(testPatientQueryList == null || testPatientQueryList.isEmpty()));
			Assert.assertFalse("Wrong closed queries found  ", (testPatientQueryList != null &&
					!testPatientQueryList.isEmpty()));
		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetClosedQueries() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testGetClosedQueries() failed due to" + e);
		}
	}


}
