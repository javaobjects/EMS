package com.neuedu.service;

import java.util.List;

import com.neuedu.dao.BonusDaoImpl;
import com.neuedu.dao.EmpDaoImpl;
import com.neuedu.dao.IBonusDao;
import com.neuedu.dao.IEmpDao;
import com.neuedu.entity.Emp;
/**
 * 雇员管理--业务逻辑层
 */
public class EmpServiceImpl implements IEmpService{

	@Override
	public List<Emp> selectEmps() {
		/*
		 * 1.业务流程
		 * 		① 查询所有的员工信息（select）
		 */
		IEmpDao empDao = new EmpDaoImpl();
		
		//① 查询所有的员工信息（select）
		List<Emp> empList = empDao.selectEmps();
		
		return empList;
	}

	@Override
	public boolean in(Emp emp) {
		/*
		 * 1.业务流程
		 * 		① 录入一条数据在Emp表中(insert)
		 * 		② 录入一条数据在Bonus表中(insert)
		 */
		//① 录入一条数据在Emp表中(insert)
		IEmpDao empDao = new EmpDaoImpl();
		boolean result = empDao.insertEmp(emp);
		
		//② 录入一条数据在Bonus表中(insert)
		IBonusDao bonusDao = new BonusDaoImpl();
		boolean result2 = bonusDao.insertBonus(emp);

		
		return result && result2;
	}

}
