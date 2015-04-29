package com.ehm.test.modeltests;

import java.sql.SQLException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ehm.db.impl.LoginDao;
import com.ehm.db.impl.LoginDaoImpl;
import com.ehm.db.model.User;

public class LoginBeanTest extends Mockito{
	LoginDao loginDao = null;

	@Before
	public void setUp() throws Exception {
		loginDao = new LoginDaoImpl("testing");
	}

	@Test
	public void testValidAndLoginUser() throws ClassNotFoundException, SQLException {
		FacesContext context = ContextMocker.mockFacesContext();
		HttpSession session = mock(HttpSession.class);
		ExternalContext externalContext = mock(ExternalContext.class);
		
		
		when(context.getExternalContext()).thenReturn(externalContext);
		when(externalContext.getSession(true)).thenReturn(session);
		
		User logedPatient = loginDao.validateLogin("admin@ehealth.com", "adminadmin");		
		
		Assert.assertTrue("Valid user found", logedPatient != null);
		
		Assert.assertFalse("Valid user found", logedPatient == null);
		
	}

/*	@Test
	public void testValidateLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGoToMyHome() {
		fail("Not yet implemented")
	}*/
	
}
