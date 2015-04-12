package com.ehm.test.modeltests;

import org.junit.After;
import org.junit.Before;

public interface BaseTest {
	
	@Before
	public void beforeSetting();
	
	@After
	public void afterSetting();

}
