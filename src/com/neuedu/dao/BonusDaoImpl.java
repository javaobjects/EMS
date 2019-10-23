package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.entity.Emp;
import com.neuedu.util.DBUtil;

public class BonusDaoImpl implements IBonusDao {

	private Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;

	@Override
	public boolean insertBonus(Emp emp) {
		try {
			//1~3 获取数据库连接
			conn = DBUtil.getConnection();
			
			//4.创建PreparedStatement对象
			stat = conn.prepareStatement("insert into bonus (ename, job, sal, comm) values (?, ?, ?, ?)");

			//4.1绑定变量值
			stat.setString(1, emp.getEname());
			stat.setString(2, emp.getJob());
			stat.setDouble(3, emp.getSalary());
			stat.setDouble(4, emp.getComm());
			//5.执行查询或更新
			int result = stat.executeUpdate();
			
			//6.结果处理
			if(result > 0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//7.关闭连接
			DBUtil.close(conn, stat, rs);
		}
		
		return false;
	}
}
