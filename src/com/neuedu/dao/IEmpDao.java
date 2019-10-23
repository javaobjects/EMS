package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;
/**
 * ��Ա����-���ݷ��ʲ�DAO��Data Access Object��:����ɾ���ġ���
 */
public interface IEmpDao {

	/**
	 * ��ѯ���е�Ա����Ϣ
	 * @return
	 */
	public List<Emp> selectEmps();
	
	/**
	 * ����Ա��
	 * @param emp ������Ա����Ϣ
	 * @return true �����ɹ�   false ����ʧ��
	 */
	public boolean insertEmp(Emp emp);
	
	/**
	 * �޸�Ա��
	 * @param emp �޸ĵ�Ա����Ϣ
	 * @return true �޸ĳɹ�   false �޸�ʧ��
	 */
	public boolean updateEmp(Emp emp);
	
	/**
	 * ɾ��Ա��
	 * @param empno ��ɾ��Ա����empno���
	 * @return true ɾ���ɹ�   false ɾ��ʧ��
	 */
	public boolean deleteEmpByEmpno(int empno);

}