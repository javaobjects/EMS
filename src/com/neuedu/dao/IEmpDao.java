package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;
/**
 * 雇员管理-数据访问层DAO（Data Access Object）:增、删、改、查
 */
public interface IEmpDao {

	/**
	 * 查询所有的员工信息
	 * @return
	 */
	public List<Emp> selectEmps();
	
	/**
	 * 新增员工
	 * @param emp 新增的员工信息
	 * @return true 新增成功   false 新增失败
	 */
	public boolean insertEmp(Emp emp);
	
	/**
	 * 修改员工
	 * @param emp 修改的员工信息
	 * @return true 修改成功   false 修改失败
	 */
	public boolean updateEmp(Emp emp);
	
	/**
	 * 删除员工
	 * @param empno 待删除员工的empno编号
	 * @return true 删除成功   false 删除失败
	 */
	public boolean deleteEmpByEmpno(int empno);

}