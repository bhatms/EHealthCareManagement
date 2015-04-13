package com.ehm.test.modeltests;

import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ehm.db.impl.PatientQueryDao;
import com.ehm.db.impl.PatientQueryDaoImpl;
import com.ehm.db.model.PatientQuery;

public class PatientQueryDaoImplTest2 implements BaseTest {

	final static Logger logger = Logger.getLogger(PatientQueryDaoImplTest2.class);
	private PatientQueryDao patqueObj;

	@Before
	public void beforeSetting() {
		patqueObj = new PatientQueryDaoImpl();

	}

	@After
	public void afterSetting() {

	}

	@Test
	public void testpatientQuery() {
		try {
			List<PatientQuery> testPatientQueryList = patqueObj.patientQuery(Integer.valueOf("9999"));
			if (testPatientQueryList == null) {
				Assert.assertNull("Query Found");
			}

		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testPatientQuery() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testPatientQuery() failed due to" + e);
		}
	}
}
