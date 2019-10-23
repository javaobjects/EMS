package com.neuedu.service;

import java.util.List;

import com.neuedu.dao.BonusDaoImpl;
import com.neuedu.dao.EmpDaoImpl;
import com.neuedu.dao.IBonusDao;
import com.neuedu.dao.IEmpDao;
import com.neuedu.entity.Emp;
/**
 * ��Ա����--ҵ���߼���
 */
public class EmpServiceImpl implements IEmpService{

	@Override
	public List<Emp> selectEmps() {
		/*
		 * 1.ҵ������
		 * 		�� ��ѯ���е�Ա����Ϣ��select��
		 */
		IEmpDao empDao = new EmpDaoImpl();
		
		//�� ��ѯ���е�Ա����Ϣ��select��
		List<Emp> empList = empDao.selectEmps();
		
		return empList;
	}

	@Override
	public boolean in(Emp emp) {
		/*
		 * 1.ҵ������
		 * 		�� ¼��һ��������Emp����(insert)
		 * 		�� ¼��һ��������Bonus����(insert)
		 */
		//�� ¼��һ��������Emp����(insert)
		IEmpDao empDao = new EmpDaoImpl();
		boolean result = empDao.insertEmp(emp);
		
		//�� ¼��һ��������Bonus����(insert)
		IBonusDao bonusDao = new BonusDaoImpl();
		boolean result2 = bonusDao.insertBonus(emp);

		
		return result && result2;
	}

}
