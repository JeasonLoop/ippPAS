package services;

import javax.swing.JFrame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DataBaseOperation.DBcon;

public class SelectALL extends JFrame {
	JTextField id = new JTextField(10);
	Box baseBox, boxV1, boxV2;
	Box baseBox1, box1, box2;
	String acType;

	public SelectALL(String a, String user) {
		this.acType = a;
		this.setBounds(100, 100, 450, 260);
		
		this.setLayout(new java.awt.FlowLayout());
		if (acType.equals("查询收入")) {
			this.setTitle("查询收入");
			init(user);
		} else if (acType.equals("查询支出")) {
			this.setTitle("查询支出");
			init1(user);
		}

		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// 只关闭当前窗口
		this.setLocationRelativeTo(null);

	}

	private void init1(String User) {
		// TODO Auto-generated method stub
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("查询结果如下："));
		box1.add(Box.createVerticalStrut(8));
		DBcon drop = new DBcon();
		Connection conn = drop.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();
				ResultSet n = sm.executeQuery("call SelectExpend("+"'"+User+"'"+")"); // 用于产生单个结果集的语句
				while (n.next()) {
					String id = n.getString(1);
					String date = n.getString(2);
					String money = n.getString(3);
					String remark = n.getString(4);
					box1.add(
							new JLabel("ID:" + id + " 日期:" + date + "," + " 金额:" + money + "," + " 备注:" + remark + ""));
					box1.add(Box.createVerticalStrut(8));
				}
				n.close();
				sm.close();
				conn.close();
			} catch (SQLException i) {
				// TODO Auto-generated catch block
				i.printStackTrace();
			}
		}
		baseBox1 = Box.createHorizontalBox();
		baseBox1.add(box1);
		add(baseBox1);
	}

	void init(String user) {
		boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("查询结果如下："));
		boxV1.add(Box.createVerticalStrut(8));
		DBcon drop = new DBcon();
		Connection conn = drop.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();
				ResultSet n = sm.executeQuery("call SelectIncome("+"'"+user+"'"+")"); // 用于产生单个结果集的语句
				while (n.next()) {
					String id = n.getString(1);
					String date = n.getString(2);
					String money = n.getString(3);
					String remark = n.getString(4);
					boxV1.add(
							new JLabel("ID:" + id + " 日期:" + date + "," + " 金额:" + money + "," + " 备注:" + remark + ""));
					boxV1.add(Box.createVerticalStrut(8));
				}
				n.close();
				sm.close();
				conn.close();
			} catch (SQLException i) {
				// TODO Auto-generated catch block
				i.printStackTrace();
			}
		}
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		add(baseBox);
	}

}
