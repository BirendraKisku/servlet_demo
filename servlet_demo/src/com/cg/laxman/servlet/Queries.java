package com.cg.laxman.servlet;

public class Queries {
	public static String check_login="select role from Users where login_id=? and password=?";
	public static String view_programs="select * from Programs_Offered";
}
