package com.ehm.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.config.EHMDataConnect;

public class EhealthUtilDaoImpl implements EhealthUtilDao{
	
	private Connection dataConnection;

	public EhealthUtilDaoImpl() throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getDataConn();

	}

	public EhealthUtilDaoImpl(String forTest) throws ClassNotFoundException, SQLException {
		
		dataConnection = EHMDataConnect.getTestDataConn();

	}

	public List<SelectItem> getStateList() throws ClassNotFoundException,
			SQLException {
		StringBuffer sqlBuf = new StringBuffer("select code, name from state ");


		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		// get customer data from database
		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(result.getString("code"));
			item.setLabel(result.getString("name"));
			list.add(item);
		}

		return list;
	}

	public List<SelectItem> getSpecializationList()
			throws ClassNotFoundException, SQLException {
		StringBuffer sqlBuf = new StringBuffer("select * from specializations order by special_id ");


		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
		// get customer data from database
		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("all","All"));
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(result.getString("special_id"));
			item.setLabel(result.getString("special_title"));
			list.add(item);
		}

		return list;
	}
	
	public List<SelectItem> getCategoryList()
			throws ClassNotFoundException, SQLException {
		StringBuffer sqlBuf = new StringBuffer("select * from specializations ");


		PreparedStatement ps = dataConnection.prepareStatement(sqlBuf.toString());
		// get customer data from database
		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("0","Select Categoy"));
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(result.getString("special_id"));
			item.setLabel(result.getString("special_title"));
			list.add(item);
		}

		return list;
	}

}
