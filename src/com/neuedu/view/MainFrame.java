package com.neuedu.view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\layers.png"));
		setTitle("\u96C7\u5458\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 449);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u5458\u5DE5\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenu menu_4 = new JMenu("\u65B0\u589E\u5458\u5DE5");
		menu.add(menu_4);
		
		JMenuItem menuItem = new JMenuItem("\u65B0\u589E\u666E\u901A\u5458\u5DE5");
		menu_4.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u65B0\u589E\u7BA1\u7406\u5458");
		menu_4.add(menuItem_1);
		
		//查询
		JMenuItem menuItem_2 = new JMenuItem("\u67E5\u8BE2\u5458\u5DE5");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.先移除原panel中所有的内容
				panel.removeAll();
				panel.repaint();
				
				//2.再想panel中添加新的内容（查询员工的界面）
				SelectEmpPanel selectEmpPanel = new SelectEmpPanel();
				selectEmpPanel.setBounds(0, 0, 745, 352);
				panel.add(selectEmpPanel);
			}
		});
		menu.add(menuItem_2);
		
		JSeparator separator = new JSeparator();
		menu.add(separator);
		
		JMenuItem menuItem_3 = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u90E8\u95E8\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u5C97\u4F4D\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(menu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 745, 35);
		contentPane.add(toolBar);
		
		//新增员工
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.先移除原panel中所有的内容
				panel.removeAll();
				panel.repaint();
				
				//2.再想panel中添加新的内容（新增员工的界面）
				AddEmpPanel addEmpPanel = new AddEmpPanel();
				addEmpPanel.setBounds(0, 0, 745, 352);
				panel.add(addEmpPanel);
			}
		});
		button.setToolTipText("\u65B0\u589E\u5458\u5DE5");
		button.setIcon(new ImageIcon("icon\\add.png"));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setToolTipText("\u8C03\u8F6C\u90E8\u95E8");
		button_1.setIcon(new ImageIcon("icon\\layout_edit.png"));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setToolTipText("\u8C03\u6574\u85AA\u8D44");
		button_2.setIcon(new ImageIcon("icon\\money.png"));
		toolBar.add(button_2);
		
		panel = new JPanel();
		panel.setBounds(0, 38, 745, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icon\\bg.jpg"));
		lblNewLabel.setBounds(0, 0, 745, 352);
		panel.add(lblNewLabel);
		
		//窗体居中
		this.setLocationRelativeTo(null);
	}
}
