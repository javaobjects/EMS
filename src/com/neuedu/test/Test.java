package com.neuedu.test;

import java.util.List;

import com.neuedu.dao.EmpDaoImpl;
import com.neuedu.dao.IEmpDao;
import com.neuedu.entity.Emp;

public class Test {

	public static void main(String[] args) {
		IEmpDao dao = new EmpDaoImpl();
		
		//����
	/*	Emp param = new Emp();
		param.setEmpno(9999);
		param.setEname("java����");
		param.setJob("����Գ");
		param.setHiredate(new Date());
		boolean result = dao.insertEmp(param);
		
		System.out.println("���������" + result);*/
		
		//�޸�
	/*	Emp param = new Emp();
		param.setEmpno(7);
		param.setEname("java����2");
		
		boolean result = dao.updateEmp(param);
		System.out.println("�޸Ľ����" + result);*/
		
		//ɾ��
		/*int empno = 7;
		boolean result = dao.deleteEmpByEmpno(empno);
		System.out.println("ɾ�������" + result);
		*/
		//��ѯ
		List<Emp> empList = dao.selectEmps();
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
