<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="com.cg.laxman.servlet.DataBase_Connection" %>
<%@ page import="com.cg.laxman.servlet.Queries" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.cg.laxman.servlet.Programs" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.3.911/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.3.911/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.3.911/styles/kendo.material.mobile.min.css" />

    <script src="https://kendo.cdn.telerik.com/2018.3.911/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2018.3.911/js/kendo.all.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%!
	/*
	 public List<Programs> list() throws SQLException, IOException {
	
	
	List<Programs> Programs_Offered = new ArrayList<Programs>();
	
	Connection conn=DataBase_Connection.getInstance().getConnection();
	Statement ps=conn.createStatement();
	ResultSet rs = ps.executeQuery(Queries.view_programs);
	
	
	while(rs.next()){
		Programs p=new Programs();
		p.setProgramName(rs.getString("ProgramName"));
		p.setDescription(rs.getString("Description"));
		p.setApplication_Eligibility(rs.getString("Applicant_Eligibility"));
		p.setDuration(rs.getInt("Duration"));
		p.setDegree_Certificate_Offered(rs.getString("Degree_Certificate_Offered"));
		Programs_Offered.add(p);	
	}
	return Programs_Offered;
	}
	//String Programs_Json = new Gson().toJson(Programs_Offered);
	
	*/%>

<div id="example">
    <div id="grid"></div>
    <script>
    var data_admin = <%=session.getAttribute("variable")%>;
    console.log(2);
    console.log(data_admin);
    var localDataSource = new kendo.data.DataSource({
        data: data_admin
    });
    console.log(localDataSource);
        $(document).ready(function () {
            $("#grid").kendoGrid({
                dataSource: localDataSource,
                pageSize: 20,
                height: 550,
                groupable: true,
                sortable: true,
                pageable: {
                    refresh: true,
                    pageSizes: true,
                    buttonCount: 5
                },
                columns: [ {
                    field: "ProgramName",
                    title: "Contact Title"
                }, {
                    field: "Description",
                    title: "Company Name"
                },{
                    field: "Application_Eligibility",
                    title: "Company Name"
                },{
                    field: "Degree_Certificate_Offered",
                    title: "Company Name"
                },{
                    field: "duration",
                    title: "Company Name"
                }, ]
            });
        });
    </script>
</div>

</body>
<style type="text/css">
    .customer-photo {
        display: inline-block;
        width: 32px;
        height: 32px;
        border-radius: 50%;
        background-size: 32px 35px;
        background-position: center center;
        vertical-align: middle;
        line-height: 32px;
        box-shadow: inset 0 0 1px #999, inset 0 0 10px rgba(0,0,0,.2);
        margin-left: 5px;
    }

    .customer-name {
        display: inline-block;
        vertical-align: middle;
        line-height: 32px;
        padding-left: 3px;
    }
</style>
</html>