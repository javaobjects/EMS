package com.neuedu.dao;

import com.neuedu.entity.Emp;
/**
 * ��Ա����-���ݷ��ʲ�DAO��Data Access Object��:����ɾ���ġ���
 */
public interface IBonusDao {

	/**
	 * ����Ա��
	 * @param emp ������Ա��������Ϣ
	 * @return true �����ɹ�   false ����ʧ��
	 */
	public boolean insertBonus(Emp emp);

}