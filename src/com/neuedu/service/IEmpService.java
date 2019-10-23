package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Emp;

/**
 * 雇员管理--业务逻辑层
 *
 *	1.实现注册功能的业务逻辑：
 *		① 判断用户名是否已存在（select）
 *      ② 实现完成注册（insert）
 *      
 *  2.转账  A->B
 *      ① 判断余额是否足够（select）
 *      ② 判断对方的用户账户是否存在（select）
 *      ③ A账户扣钱（update）
 *      ④ B账户加钱（update）
 */
public interface IEmpService {

	/**
	 * 查询所有员工的信息
	 */
	public List<Emp> selectEmps();
	
	/**
	 * 员工入职
	 */
	public boolean in(Emp emp);
	
}
