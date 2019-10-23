package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Emp;

/**
 * ��Ա����--ҵ���߼���
 *
 *	1.ʵ��ע�Ṧ�ܵ�ҵ���߼���
 *		�� �ж��û����Ƿ��Ѵ��ڣ�select��
 *      �� ʵ�����ע�ᣨinsert��
 *      
 *  2.ת��  A->B
 *      �� �ж�����Ƿ��㹻��select��
 *      �� �ж϶Է����û��˻��Ƿ���ڣ�select��
 *      �� A�˻���Ǯ��update��
 *      �� B�˻���Ǯ��update��
 */
public interface IEmpService {

	/**
	 * ��ѯ����Ա������Ϣ
	 */
	public List<Emp> selectEmps();
	
	/**
	 * Ա����ְ
	 */
	public boolean in(Emp emp);
	
}
