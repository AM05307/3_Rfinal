<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*,java.net.*"%>
<%! 
public void init() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<%
String root = request.getContextPath();

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = null;
try {
	conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "playdata", "admin1234");
	String sql = "";
	sql += "select name \n";
	sql += "from member \n";
	sql += "where id = '" +id + "' and pass='" + pass + "' \n";
	System.out.println(sql);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	if(rs.next()) {
		name = rs.getString(1);
	}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		if(rs != null)
			rs.close();
		if(stmt != null)
			stmt.close();
		if(conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

if(name != null) {
	response.sendRedirect(root + "/login/loginok.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
} else {
	response.sendRedirect(root + "/login/loginfail.jsp");
}
%>














