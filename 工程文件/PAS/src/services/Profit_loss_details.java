package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DataBaseOperation.DBcon;

public class Profit_loss_details extends JFrame {
	Box baseBox, box1, box2;

	public Profit_loss_details(String user) {
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("��ϸ����:"));
		box1.add(Box.createVerticalStrut(8));

		DBcon drop = new DBcon();
		Connection conn = drop.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();
				ResultSet n = sm.executeQuery("select * from pld where loginUser = "+"'"+user+"'"); // ���ڲ�����������������
				Double sum = 0.0, t;
				while (n.next()) {
					String time = n.getString(1);
					String money = n.getString(2);
					t = Double.parseDouble(money);
					sum += t;
					String remark = n.getString(3);
					box1.add(new JLabel("��¼ʱ��:" + time + " ���:" + money + "  ��ע:" + remark + ""));
					box1.add(Box.createVerticalStrut(8));
				}
				box1.add(new JLabel(" �����:" + sum));
				n.close();
				sm.close();
				conn.close();
			} catch (SQLException i) {
				// TODO Auto-generated catch block
				i.printStackTrace();
			}

			baseBox = Box.createHorizontalBox();
			baseBox.add(box1);
			add(baseBox);

			this.setBounds(100, 100, 600, 260);
			this.setTitle("DETAILS");
			this.setLayout(new java.awt.FlowLayout());
			this.setVisible(true);
			this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// ֻ�رյ�ǰ����
			this.setLocationRelativeTo(null);

		}
	}
}
