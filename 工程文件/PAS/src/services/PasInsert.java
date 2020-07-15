package services;

import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataBaseOperation.DBcon;
import DataBaseOperation.DBinsert;

import java.awt.event.ActionEvent;
import java.sql.Connection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PasInsert extends JFrame {
	// JTextField type = new JTextField(10);//设置类型一列
	JTextField money = new JTextField(10);// 设置数额
	// JTextField Time = new JTextField(10);//设置时间
	JTextField remark = new JTextField(10);// 设置备注

	String Itype, Iremark, Itime, Imoney;
	Box baseBox, box1, box2;// 创建面板
	DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
	JComboBox comboxType = new JComboBox<>(ComboBoxModel);
	Date date = new Date();
	DefaultComboBoxModel<Object> ComboBoxModel0 = new DefaultComboBoxModel<>();
	JComboBox comboxTime = new JComboBox<>(ComboBoxModel0);
	JButton btn1 = new JButton("OK");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

	public PasInsert(String User) {
		this.setBounds(100, 100, 310, 210);// 窗口大小
		this.setTitle("ADD");
		this.setLayout(new java.awt.FlowLayout());
		init(User);
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// 只关闭当前窗口
		this.setLocationRelativeTo(null);
	}

	void init(String User) {
		ComboBoxModel.addElement("支出");
		ComboBoxModel.addElement("收入");
		for (int i = 0; i <= 7; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, -i);
			ComboBoxModel0.addElement(sdf.format(calendar.getTime()));
		}
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("TYPE："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("MONEY："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("TIME："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("REMARK："));
		box1.add(Box.createVerticalStrut(8));

		box2 = Box.createVerticalBox();
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
		add(btn1);

		btn1.addActionListener(new ActionListener() {// 新增添加按钮注册监听器
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Itype = (String) comboxType.getSelectedItem();
				Imoney = money.getText();
				Itime = (String) comboxTime.getSelectedItem();
				Iremark = remark.getText();
				// 判断是否为空，因为不能插入空金额
				if (!Imoney.equals("") && Double.parseDouble(Imoney) > 0) {
					try {
						Double.parseDouble(Imoney);// 只能为Double
						DBcon dBcon = new DBcon();
						Connection con = dBcon.getCon();
						if (con == null) {
							System.out.println("数据库插入连接失败");
						} else {
							System.out.println("数据库插入连接成功");
							DBinsert.Register(User,Itype, Imoney, Itime, Iremark);

							money.setText("");
							remark.setText("");
						}
					} catch (Exception e2) {
						// TODO: handle exception
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