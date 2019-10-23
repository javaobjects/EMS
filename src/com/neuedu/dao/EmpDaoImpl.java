package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Emp;
import com.neuedu.util.DBUtil;

public class EmpDaoImpl implements IEmpDao {

	private Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;
	
	@Override
	public List<Emp> selectEmps() {
		try {
			//1~3 获取数据库连接
			conn = DBUtil.getConnection();
			
			//4.创建PreparedStatement对象
			stat = conn.prepareStatement("select empno, ename empName, job, mgr, hiredate, sal, comm, deptno from emp");

			//5.执行查询或更新
			rs = stat.executeQuery();
			
			//6.结果处理
			List<Emp> empList = new ArrayList<Emp>();
			while(rs.next())
			{
				//每遍历一次，获得一个Emp的员工信息
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("empName"));
				emp.setJob(rs.getString("job"));
				emp.setManager(rs.getInt("mgr"));
				
				/**
				 * java.sql.Date（子类） -> java.util.Date（父类）：子类自动转换为父类
				 * java.sql.Time（子类） -> java.util.Date（父类）：子类自动转换为父类
				 * java.sql.Timestamp（子类） -> java.util.Date（父类）：子类自动转换为父类
				 * 
				 * java.sql.Date：表示年月日
				 * java.sql.Time：表示时分秒
				 * java.sql.Timestamp：表示年月日时分秒
				 */
				//emp.setHiredate(rs.getDate("hiredate"));     //Date  2019-09-16
				//emp.setHiredate(rs.getTimestamp("hiredate"));//Timestamp  2019-09-16 15:49:49.0
				emp.setHiredate(rs.getTime("hiredate"));       //Time  15:49:49
				
				emp.setSalary(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				//将当前的emp添加到集合
				empList.add(emp);
			}
			return empList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//7.关闭连接
			DBUtil.close(conn, stat, rs);
		}
		
		return null;
	}

	@Override
	public boolean insertEmp(Emp emp) {
		try {
			//1~3 获取数据库连接
			conn = DBUtil.getConnection();
			
			//4.创建PreparedStatement对象
			// 使用序列完成主键自增：create sequence seq_emp;
			stat = conn.prepareStatement("insert into emp(empno,ename,job,hiredate) values(seq_emp.nextval,?,?,?)");

			//4.1绑定变量值
			//stat.setInt(1, emp.getEmpno());
			stat.setString(1, emp.getEname());
			stat.setString(2, emp.getJob());
			
			/**
			 * java.util.Date（父类）  -> java.sql.Date（子类）：
			 * 	
			 * 		① 将java.util.Date（父类） -> 毫秒值
			 * 			long milliSeconds = emp.getHiredate().getTime();
			 * 
			 *		② 毫秒值 -> java.sql.Date（子类）
			 *			java.sql.Date date = new java.sql.Date(milliSeconds);
			 *			java.sql.Time date = new java.sql.Time(milliSeconds);
			 *			java.sql.Timestamp date = new java.sql.Timestamp(milliSeconds);
			 * 			
			 */
			stat.setDate(3, new java.sql.Date(emp.getHiredate().getTime()));
			//stat.setTime(3, new java.sql.Time(emp.getHiredate().getTime()));
			//stat.setTimestamp(3, new java.sql.Timestamp(emp.getHiredate().getTime()));
			
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

	@Override
	public boolean updateEmp(Emp emp) {
		try {
			//1~3 获取数据库连接
			conn = DBUtil.getConnection();
			
			//4.创建PreparedStatement对象
			stat = conn.prepareStatement("update emp set ename = ? where empno = ?");

			//4.1绑定变量值
			stat.setString(1, emp.getEname());
			stat.setInt(2, emp.getEmpno());

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

	@Override
	public boolean deleteEmpByEmpno(int empno) {
		try {
			//1~3 获取数据库连接
			conn = DBUtil.getConnection();
			
			//4.创建PreparedStatement对象
			stat = conn.prepareStatement("delete from emp where empno = ?");

			//4.1绑定变量值
			stat.setInt(1, empno);

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
