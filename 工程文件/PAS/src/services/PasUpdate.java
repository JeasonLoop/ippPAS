package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataBaseOperation.DBcon;
import DataBaseOperation.DBupdate;

public class PasUpdate extends JFrame {
	JTextField id = new JTextField(10);
	JTextField type = new JTextField(10);
	JTextField money = new JTextField(10);
	JTextField remark = new JTextField(10);
	String Uid, Utype, Umoney, Uremark, Utime;
	Box baseBox, box1, box2;
	JButton btn1 = new JButton("OK");
	DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
	JComboBox comboxType = new JComboBox<>(ComboBoxModel);
	DefaultComboBoxModel<Object> ComboBoxModel0 = new DefaultComboBoxModel<>();
	JComboBox comboxTime = new JComboBox<>(ComboBoxModel0);
	Date date = new Date();
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

	 public PasUpdate(String ac) {
		this.setBounds(100, 100, 310, 260);
		this.setTitle("UPDATE");
		this.setLayout(new java.awt.FlowLayout());
		init(ac);
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// 只关闭当前窗口
		this.setLocationRelativeTo(null);
	}

	




	void init(String ac) {
		ComboBoxModel.addElement("收入");
		ComboBoxModel.addElement("支出");
		for (int i = 0; i <= 7; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, -i);
			ComboBoxModel0.addElement(sdf.format(calendar.getTime()));

		}
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("ID："));
		box1.add(Box.createVerticalStrut(12));
		box1.add(new JLabel("TYPE："));
		box1.add(Box.createVerticalStrut(12));
		box1.add(new JLabel("MONEY："));
		box1.add(Box.createVerticalStrut(12));
		box1.add(new JLabel("DATE："));
		box1.add(Box.createVerticalStrut(12));
		box1.add(new JLabel("REMARK："));
		box1.add(Box.createVerticalStrut(12));

		box2 = Box.createVerticalBox();
		box2.add(id);
		box2.add(Box.createVerticalStrut(8));
		box2.add(comboxType);
		box2.add(Box.createVerticalStrut(8));
		box2.add(money);
		box2.add(Box.createVerticalStrut(8));
		box2.add(comboxTime);
		box2.add(Box.createVerticalStrut(8));
		box2.add(remark);
		box2.add(Box.createVerticalStrut(8));

		baseBox = Box.createHorizontalBox();
		baseBox.add(box1);
		box2.add(Box.createVerticalStrut(10));
		baseBox.add(box2);

		add(baseBox);
		add(btn1);// 按钮

		btn1.addActionListener(new ActionListener() { // 为更新按钮注册事件监听器
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Uid = id.getText();
				Utype = (String) comboxType.getSelectedItem();
				Umoney = money.getText();
				Utime = (String) comboxTime.getSelectedItem();
				Uremark = remark.getText();
				if (!Uid.equals("") && !Umoney.equals("")) {
					try {
						Integer.parseInt(Umoney); // 只能为正整数
						DBcon dBcon = new DBcon();
						Connection con = dBcon.getCon();
						if (con == null) {
							System.out.println("数据库更新连接失败");
						} else {
							System.out.println("数据库更新连接成功");

							DBupdate.update(Uid, Utype, Umoney, Utime, Uremark);
							id.setText("");
							// type.setText("");
							money.setText("");
							remark.setText("");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Money格式不正确，请重新输入！");
						money.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "数据不能为空，请补充完整！");
				}
			}
		});
	}

}
