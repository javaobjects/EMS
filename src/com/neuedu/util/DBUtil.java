package com.neuedu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ���ݿ⹤����
 */
public class DBUtil {

	private static Properties properties = new Properties();
	
	/**��̬�����:�����ʱ������ִ��һ��*/
	static{
		try {
			//0.�����ⲿ�����ļ�db.properties
			properties.load(new FileInputStream("config/db.properties"));
			
			//1.����JDBC��������
			Class.forName(properties.getProperty("jdbc.driverClassName"));//����������  oracle.jdbc.driver.OracleDriver
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection()
	{
		try {
			//2.��������URL  jdbc:oracle:thin:@<����IP>:1521:<���ݿ������>
			String url = properties.getProperty("jdbc.url");
			
			//3.��������
			Connection conn = DriverManager.getConnection(url, properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
			
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * �ر����ݿ���Դ
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void close(Connection conn,Statement stat,ResultSet rs)
	{
		//7.�ر�����
		//ʹ��˳��Connection -> Statement -> ResultSet
		//�ر�˳��ResultSet -> Statement -> Connection
		try {
			if(rs != null)
			{
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stat != null)
			{
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null)
			{
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
