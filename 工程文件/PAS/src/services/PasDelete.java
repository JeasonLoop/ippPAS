package services;

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
import javax.swing.JTextField;

import DataBaseOperation.DBcon;
import DataBaseOperation.DBdelete;

public class PasDelete extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField id = new JTextField(10);
	String Did;// 需要删除的id号
	Box baseBox, box1, box2;// 面板
	JButton btn1 = new JButton("OK");
	DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
	JComboBox deleteType = new JComboBox<>(ComboBoxModel);

	public PasDelete(String ac) {
		this.setBounds(100, 100, 310, 100);
		this.setTitle("DELETE");
		this.setLayout(new java.awt.FlowLayout());// 容器
		init(ac);
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// 只关闭当前窗口
		this.setLocationRelativeTo(null);
	}

	
	void init(String ac) {// 布局
		ComboBoxModel.addElement("支出");
		ComboBoxModel.addElement("收入");
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("ID："));
		box2 = Box.createVerticalBox();
		box2.add(id);

		baseBox = Box.createHorizontalBox();
		baseBox.add(box1);
		box2.add(Box.createVerticalStrut(10));
		baseBox.add(box2);

		add(baseBox);// 容器
		add(btn1);
		add(deleteType);
		btn1.addActionListener(new ActionListener() { // 为删除按钮注册时间监听器
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Did = id.getText();
				String DType = (String) deleteType.getSelectedItem();
				if (!id.equals("")) {// ID不为空
					try {
						Integer.parseInt(Did); // 只能为正整数
						DBcon dBcon = new DBcon();
						Connection con = dBcon.getCon();
						if (con == null) {
							System.out.println("数据库删除连接失败");
						} else {
							System.out.println("数据库删除连接成功");
							DBdelete.Delete(Did, DType,ac);
							id.setText("");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "ID格式不正确，请重新输入！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "数据不能为空，请补充完整！");
				}
			}
		});
	}

}
