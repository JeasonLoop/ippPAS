package services;

import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DataBaseOperation.DBcon;
import DataBaseOperation.DBselect;

public class PasSelect extends JFrame {
	JTextField id = new JTextField(10);// 要查询的ID
	DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
	JComboBox comboxType = new JComboBox<>(ComboBoxModel);
	JTextField money = new JTextField(10);
	JTextField date = new JTextField(10);
	JTextField remark = new JTextField(10);

	JLabel showMe = new JLabel();// 显示结果标签
	Box baseBox, box1, box2;
	JButton btn1 = new JButton("查询");

	public PasSelect(String ac) {
		this.setBounds(100, 100, 310, 260);
		this.setTitle("查询账目");
		this.setLayout(new java.awt.FlowLayout());
		init(ac);
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// 只关闭当前窗口
		this.setLocationRelativeTo(null);

	}

	void init(String ac) {

		box1 = Box.createVerticalBox();
		box1.add(new JLabel("请输入要查询的ID："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("结果如下："));
		box1.add(Box.createVerticalStrut(8));

		box1.add(new JLabel("      "));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("DATE:"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("MONEY:"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("REMARK:"));
		box1.add(Box.createVerticalStrut(8));

		box2 = Box.createVerticalBox();
		box2.add(id);
		box2.add(Box.createVerticalStrut(8));
		box2.add(comboxType);
		box2.add(Box.createVerticalStrut(8));
		ComboBoxModel.addElement("支出");
		ComboBoxModel.addElement("收入");

		box2.add(btn1);

		money.setEnabled(false);
		box2.add(money);
		box2.add(Box.createVerticalStrut(8));
		date.setEnabled(false);
		box2.add(date);
		box2.add(Box.createVerticalStrut(8));
		remark.setEnabled(false);
		box2.add(remark);
		box2.add(Box.createVerticalStrut(8));

		baseBox = Box.createHorizontalBox();
		baseBox.add(box1);
		box2.add(Box.createVerticalStrut(10));
		baseBox.add(box2);

		add(baseBox);

		btn1.addActionListener(new ActionListener() {// 为查询按钮注册时间监听器
			public void actionPerformed(ActionEvent e) {

				DBcon dBcon = new DBcon();
				Connection con = dBcon.getCon();
				if (con == null) {
					System.out.println("数据库查询连接失败");
				} else {
					System.out.println("数据库查询连接成功");
					String idString = id.getText();
					String getItem = (String) comboxType.getSelectedItem();
					if (!idString.equals("")) {
						try {
							Integer.parseInt(idString); // 只能为正整数
							DBselect.select(idString, getItem);
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "ID格式不正确，请重新输入！");
						}

					} else {
						JOptionPane.showMessageDialog(null, " 请输入ID！");
					}
					// id.setText(DBselect.s);
					money.setText(DBselect.Smoney);
					date.setText(DBselect.Sdate);
					remark.setText(DBselect.Sremark);
				}
			}

		});

	}
}
