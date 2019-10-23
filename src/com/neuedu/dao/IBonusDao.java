package com.neuedu.dao;

import com.neuedu.entity.Emp;
/**
 * 雇员管理-数据访问层DAO（Data Access Object）:增、删、改、查
 */
public interface IBonusDao {

	/**
	 * 新增员工
	 * @param emp 新增的员工福利信息
	 * @return true 新增成功   false 新增失败
	 */
	public boolean insertBonus(Emp emp);

}