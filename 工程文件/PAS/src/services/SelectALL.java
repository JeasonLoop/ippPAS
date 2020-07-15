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
		if (acType.equals("��ѯ����")) {
			this.setTitle("��ѯ����");
			init(user);
		} else if (acType.equals("��ѯ֧��")) {
			this.setTitle("��ѯ֧��");
			init1(user);
		}

		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// ֻ�رյ�ǰ����
		this.setLocationRelativeTo(null);

	}

	private void init1(String User) {
		// TODO Auto-generated method stub
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("��ѯ������£�"));
		box1.add(Box.createVerticalStrut(8));
		DBcon drop = new DBcon();
		Connection conn = drop.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();
				ResultSet n = sm.executeQuery("call SelectExpend("+"'"+User+"'"+")"); // ���ڲ�����������������
				while (n.next()) {
					String id = n.getString(1);
					String date = n.getString(2);
					String money = n.getString(3);
					String remark = n.getString(4);
					box1.add(
							new JLabel("ID:" + id + " ����:" + date + "," + " ���:" + money + "," + " ��ע:" + remark + ""));
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
		boxV1.add(new JLabel("��ѯ������£�"));
		boxV1.add(Box.createVerticalStrut(8));
		DBcon drop = new DBcon();
		Connection conn = drop.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();
				ResultSet n = sm.executeQuery("call SelectIncome("+"'"+user+"'"+")"); // ���ڲ�����������������
				while (n.next()) {
					String id = n.getString(1);
					String date = n.getString(2);
					String money = n.getString(3);
					String remark = n.getString(4);
					boxV1.add(
							new JLabel("ID:" + id + " ����:" + date + "," + " ���:" + money + "," + " ��ע:" + remark + ""));
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
