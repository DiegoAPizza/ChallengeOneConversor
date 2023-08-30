package com.alura.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/?user=root",
				"root",
				"root1234");
		System.out.println("Cerrando la conexion");
		
		con.close();
		
	}
	
}
