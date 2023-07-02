package panaderias;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.mysql.cj.jdbc.DatabaseMetaDataUsingInfoSchema;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {


	final static String NULL_SENTINEL_VARCHAR = "NULL";
	final static int NULL_SENTINEL_INT = Integer.MIN_VALUE;
	final static java.sql.Date NULL_SENTINEL_DATE = java.sql.Date.valueOf("1900-01-01");

	private Connection conn = null;
	private String user;
	private String pass;
	private String url;

	public DBConnection(String server, int port, String user, String pass, String database){
		this.user = user;
		this.pass = pass;
		this.url = "jdbc:mysql://" + server + ":" + port + "/" + database;
	}

	public boolean connect() {
		if (conn != null) {
			return true;
		}
		try {
			conn = DriverManager.getConnection(url, user, pass);
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean close(){
		if (conn == null) {
			return false;
		}
		try {
			conn.close();
			conn = null;
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int update(String sql) {
		if (conn == null) {
			return -1;
		}
		try {
			Statement statement = conn.createStatement();
			return statement.executeUpdate(sql);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int update(String sql, ArrayList<Object> a) {
		if (conn == null) {
			return -1;
		}
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			for (int i = 0; i < a.size(); i++) {
				Object objeto = a.get(i);

				if (objeto == null) 
					statement.setNull(i + 1, Types.NULL);
				else if (objeto.getClass().getName() == "java.lang.String")
					statement.setString(i + 1, (String) objeto);
				else if (objeto.getClass().getName() == "java.lang.Integer")
					statement.setInt(i + 1, (Integer) objeto);
				else if (objeto.getClass().getName() == "java.lang.Float")
					statement.setFloat(i + 1, (Float) objeto);
				else if (objeto.getClass().getName() == "java.lang.Double")
					statement.setDouble(i + 1, (Double) objeto);
				else if (objeto.getClass().getName() == "java.sql.Date")
					statement.setDate(i + 1, (java.sql.Date) objeto);
				else if (objeto.getClass().getName() == "java.util.Date") {
					java.util.Date fecha = (java.util.Date) objeto;
					statement.setDate(i + 1, new java.sql.Date(fecha.getTime())); } 
				else 
					statement.setObject(i + 1, objeto);

			}
			return statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}


	public ResultSet query(String sql) {
		if (conn == null) {
			return null;
		}
		try {
			Statement statement = conn.createStatement();
			return statement.executeQuery(sql);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet query(String sql, ArrayList<Object> a) {
		if (conn == null) {
			return null;
		}
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			for (int i = 0; i < a.size(); i++) {
				Object objeto = a.get(i);

				if (objeto == null) 
					statement.setNull(i + 1, Types.NULL);
				else if (objeto.getClass().getName() == "java.lang.String")
					statement.setString(i + 1, (String) objeto);
				else if (objeto.getClass().getName() == "java.lang.Integer")
					statement.setInt(i + 1, (Integer) objeto);
				else if (objeto.getClass().getName() == "java.lang.Float")
					statement.setFloat(i + 1, (Float) objeto);
				else if (objeto.getClass().getName() == "java.lang.Double")
					statement.setDouble(i + 1, (Double) objeto);
				else if (objeto.getClass().getName() == "java.sql.Date")
					statement.setDate(i + 1, (java.sql.Date) objeto);
				else if (objeto.getClass().getName() == "java.util.Date") {
					java.util.Date fecha = (java.util.Date) objeto;
					statement.setDate(i + 1, new java.sql.Date(fecha.getTime())); } 
				else 
					statement.setObject(i + 1, objeto);

			}
			return statement.executeQuery();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean tableExists(String tableName) {
		if (conn == null) {
			return false;
		}
		try {
			DatabaseMetaData metadatos = conn.getMetaData();
			ResultSet tables = metadatos.getTables(null, null, tableName, null);
			return tables.next();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

