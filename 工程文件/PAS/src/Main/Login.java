package Main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import DataBaseOperation.DBcon;
import Userinfo.UserRegister;

//登录界面
public class Login extends JFrame implements ActionListener {

	JTextField account;// 输入账号
	JPasswordField password;// 输入密码
	JButton login;
	JButton register;
	JButton exit;

	public Login() {
		this.setTitle("天天记账");
		this.setSize(250, 220);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		account = new JTextField(20);
		password = new JPasswordField(20);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());

		JLabel L1 = new JLabel("账号");
		JLabel L2 = new JLabel("密码");
		login = new JButton("登录");
		exit = new JButton("退出");
		register = new JButton("注册");

		login.addActionListener(this);
		exit.addActionListener(this);
		register.addActionListener(this);

		p.add(L1);
		p.add(account);
		p.add(L2);
		p.add(password);
		p.add(login);
		p.add(exit);
		p.add(register);
		this.add(p);
		this.setVisible(true);
		this.validate();
		this.repaint();

	}

	public void actionPerformed(ActionEvent e) {// 处理登录点击事件
		// TODO Auto-generated method stub
		if (e.getSource() == login) {
			DBcon dbc = new DBcon();
			Connection c = dbc.getCon();
			String a1 = account.getText();
			String p1 = password.getText();
			if (c != null) {
				try {
					Statement s = c.createStatement();
					boolean f = false;
					ResultSet n = s.executeQuery("select * from userinfo");
					while (n.next()) {
						String t1 = n.getString(1), t2 = n.getString(2);
						if (a1.equals(t1) && p1.equals(t2)) {
							f = true;
							break;
						}
					}
					n.close();
					s.close();
					c.close();
					if (f == true) {
						JOptionPane.showMessageDialog(null, "登录成功！");
						Frame_main m = new Frame_main(a1);
						dispose();
					} else if (f == false)
						JOptionPane.showMessageDialog(null, "登录失败！");

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			} else if (account.getText() == null || password.getText() == null) {
				JOptionPane.showMessageDialog(null, "用户名或密码为空！");
			}
		}

		if (e.getSource() == exit) {
			System.exit(0);
		}

		if (e.getSource() == register) {
			UserRegister ur = new UserRegister();
		}
	}

	public static void main(String[] args) {
		Login frame = new Login();

	}

}
