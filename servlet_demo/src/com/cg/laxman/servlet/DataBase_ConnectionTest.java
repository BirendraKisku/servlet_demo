package com.cg.laxman.servlet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import junit.framework.Assert;

public class DataBase_ConnectionTest {
	static Connection conn;

	public void testGetConnection() throws SQLException, IOException {
		conn=DataBase_Connection.getInstance().getConnection();
		Assert.assertNotNull(conn);
	}

}
