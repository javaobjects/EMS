package com.neuedu.test;

import java.util.List;

import com.neuedu.dao.EmpDaoImpl;
import com.neuedu.dao.IEmpDao;
import com.neuedu.entity.Emp;

public class Test {

	public static void main(String[] args) {
		IEmpDao dao = new EmpDaoImpl();
		
		//新增
	/*	Emp param = new Emp();
		param.setEmpno(9999);
		param.setEname("java测试");
		param.setJob("程序猿");
		param.setHiredate(new Date());
		boolean result = dao.insertEmp(param);
		
		System.out.println("新增结果：" + result);*/
		
		//修改
	/*	Emp param = new Emp();
		param.setEmpno(7);
		param.setEname("java测试2");
		
		boolean result = dao.updateEmp(param);
		System.out.println("修改结果：" + result);*/
		
		//删除
		/*int empno = 7;
		boolean result = dao.deleteEmpByEmpno(empno);
		System.out.println("删除结果：" + result);
		*/
		//查询
		List<Emp> empList = dao.selectEmps();
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
