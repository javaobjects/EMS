package com.neuedu.entity;

import java.util.Date;

/**
 * 映射数据库Emp表的实体类
 */
public class Emp {

	/**员工编号*/
	private int empno;
	/**员工姓名*/
	private String ename;
	/**员工职位*/
	private String job;
	/**员工上级经理*/
	private int manager;
	/**员工入职日期*/
	private Date hiredate;
	/**员工薪水*/
	private double salary;
	/**员工奖金*/
	private double comm;
	/**所在部门*/
	private int deptno;

	/**无参构造函数*/
	public Emp()
	{
		super();
	}
	
	/**有参构造函数*/
	public Emp(int empno, String ename, String job, int manager, Date hiredate, double salary, double comm,
			int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.salary = salary;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	/**访问器（get与set方法）*/
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	/**重写Object父类的toString方法*/
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", manager=" + manager + ", hiredate="
				+ hiredate + ", salary=" + salary + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
}
