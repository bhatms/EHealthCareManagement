package com.ehm.db.impl;

import java.sql.SQLException;

import com.ehm.db.model.Patient;
import com.ehm.db.model.User;


public interface LoginDao {

	//Patient validate(String userName, String password) throws ClassNotFoundException, SQLException;
	
	User validateLogin(String userName, String password) throws ClassNotFoundException, SQLException;
	
}
