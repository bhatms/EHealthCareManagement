package com.ehm.test.modeltests;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;

public interface BaseTest {
	
	@Before
	public void beforeSetting() throws ClassNotFoundException, SQLException;
	
	@After
	public void afterSetting();

}
