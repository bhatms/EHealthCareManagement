package com.ehm.test.modeltests;

import java.sql.SQLException;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ehm.db.impl.LoginDao;
import com.ehm.db.impl.LoginDaoImpl;
import com.ehm.db.model.User;

public class LoginDaoImplTest implements BaseTest {

	final static Logger logger = Logger.getLogger(LoginDaoImplTest.class);
	private LoginDao logObj;

	@Before
	public void beforeSetting() throws ClassNotFoundException, SQLException {
		logObj = new LoginDaoImpl("testing");

	}

	@After
	public void afterSetting() {

	}

	@Test
	public void testvalidate() {
		try {
			User testPatient = logObj.validateLogin("6783287", "487386");
			if (testPatient == null) {
				System.out.println("No User Found");
			}

			testPatient = logObj.validateLogin("jt@uncc.edu", "opop");
			if (testPatient != null) {
				System.out.println("User Found" + testPatient.getEmailId());
			}
		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testValidate() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testValidate() failed due to" + e);
		}
	}
}
