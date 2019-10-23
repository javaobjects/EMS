package com.neuedu.view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.neuedu.entity.Emp;
import com.neuedu.service.EmpServiceImpl;
import com.neuedu.service.IEmpService;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SelectEmpPanel extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SelectEmpPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 725, 304);
		add(scrollPane);
		
		/*
		 * 调用service层方法，获取查询的数据
		 */
		IEmpService empService = new EmpServiceImpl();
		List<Emp> empList = empService.selectEmps();
		
		//List ——> Object[][]
		Object[][] values = new Object[empList.size()][8];
		
		Object[] objArray = empList.toArray();
		int k = 0;
		for (Object object : objArray) {
			Emp emp = (Emp)object;
			
			values[k++] = new Object[]{emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getManager(),emp.getHiredate(),emp.getSalary(),emp.getComm(),emp.getDeptno()};
		}
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			values,
			new String[] {
				"\u96C7\u5458\u7F16\u53F7", "\u96C7\u5458\u59D3\u540D", "\u804C\u4F4D", "\u4E0A\u7EA7\u7ECF\u7406", "\u5165\u804C\u65E5\u671F", "\u85AA\u8D44", "\u5956\u91D1", "\u90E8\u95E8\u7F16\u53F7"
			}
		));
		
		JLabel label = new JLabel("\u96C7\u5458\u7F16\u53F7\uFF1A");
		label.setBounds(30, 13, 67, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(99, 10, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u96C7\u5458\u59D3\u540D\uFF1A");
		label_1.setBounds(190, 13, 67, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(267, 10, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\uFF1A");
		label_2.setBounds(358, 13, 54, 15);
		add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "10", "20", "30", "40"}));
		comboBox.setBounds(417, 10, 77, 21);
		add(comboBox);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(549, 9, 93, 23);
		add(button);
	}
}
