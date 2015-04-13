package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

public interface EhealthUtilDao {

	List<SelectItem> getStateList() throws ClassNotFoundException, SQLException;

	List<SelectItem> getSpecializationList() throws ClassNotFoundException, SQLException;

	List<SelectItem> getCategoryList() throws ClassNotFoundException, SQLException;

}
