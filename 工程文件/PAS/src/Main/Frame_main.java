package Main;

import services.PasUpdate;
import services.SelectALL;
import services.Detail_Accounts;
import services.PasDelete;
import services.PasSelect;
import services.PasInsert;

import java.awt.Font;
import java.awt.Frame;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Frame_main extends JFrame implements ActionListener {
	JButton jb1 = null;
	JButton ADD, CHANGE, DELETE, OUT, SELECT, BROWSE;
     static String ac;
	public Frame_main(String User) {// 主页面布局设置
		this.setSize(573, 350);
		this.setTitle("Menu");
		ac=User;
		BufferedImage BF = null;
		try {
			BF = ImageIO.read(new File("D:/Java-workspace/PAS/image/P1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel contentPane = new JPanel();
		JLabel j = new JLabel(new ImageIcon(BF));
		j.setBounds(0, -25, this.getWidth() - 10, this.getHeight() - 10);

		contentPane.add(j);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ADD = new JButton("新账目");
		ADD.setFont(new Font("楷体", Font.PLAIN, 18));
		ADD.setFocusable(true);
		ADD.setBounds(91, 100, 150, 27);

		CHANGE = new JButton("更新");
		CHANGE.setFont(new Font("楷体", Font.PLAIN, 18));
		CHANGE.setFocusable(true);
		CHANGE.setBounds(91, 150, 150, 27);

		DELETE = new JButton("删除");
		DELETE.setFont(new Font("楷体", Font.PLAIN, 18));
		DELETE.setFocusable(true);
		DELETE.setBounds(91, 200, 150, 27);

		SELECT = new JButton("查询");
		SELECT.setFont(new Font("楷体", Font.PLAIN, 18));
		SELECT.setFocusable(true);
		SELECT.setBounds(300, 100, 150, 27);

		BROWSE = new JButton("账目浏览");
		BROWSE.setFont(new Font("楷体", Font.PLAIN, 18));
		BROWSE.setFocusable(true);
		BROWSE.setBounds(300, 150, 150, 27);
		contentPane.add(BROWSE);

		OUT = new JButton("退出");
		OUT.setFont(new Font("楷体", Font.PLAIN, 18));
		OUT.setFocusable(true);
		OUT.setBounds(300, 200, 150, 27);

		ADD.addActionListener(this);
		CHANGE.addActionListener(this);
		DELETE.addActionListener(this);
		SELECT.addActionListener(this);
		BROWSE.addActionListener(this);
		OUT.addActionListener(this);

		contentPane.add(ADD);
		contentPane.add(CHANGE);
		contentPane.add(DELETE);
		contentPane.add(SELECT);
		contentPane.add(OUT);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ADD) {
			PasInsert ins = new PasInsert(ac);

			if (ins == null || !ins.isVisible())
				ins = new PasInsert(ac);
			else {
				ins.setLocationRelativeTo(null);
				ins.setState(Frame.NORMAL);
			}

		} else if (e.getSource() == CHANGE) {
			PasUpdate upd = new PasUpdate(ac);
			if (upd == null || !upd.isVisible())
				upd = new PasUpdate(ac);
			else {
				upd.setLocationRelativeTo(null);
				upd.setState(Frame.NORMAL);
			}

		} else if (e.getSource() == DELETE) {
			PasDelete dr=new PasDelete(ac);
			if (dr == null || !dr.isVisible())
				dr = new PasDelete(ac);
			else {
				dr.setLocationRelativeTo(null);
				dr.setState(Frame.NORMAL);
			}
		} else if (e.getSource() == SELECT) {
			PasSelect ps=new PasSelect(ac);
			if (ps == null || !ps.isVisible())
				ps = new PasSelect(ac);
			else {
				ps.setLocationRelativeTo(null);
				ps.setState(Frame.NORMAL);
			}

		} else if (e.getSource() == BROWSE) {
			Detail_Accounts DA=new Detail_Accounts(ac);
			if (DA == null || !DA.isVisible())
				DA = new Detail_Accounts(ac);
			else {
				DA.setLocationRelativeTo(null);
				DA.setState(Frame.NORMAL);
			}

		} else if (e.getSource() == OUT) {
			System.exit(0);
		}

		// 连接数据库 测试
		String URL = "jdbc:mysql://localhost/pas?useSSL=FALSE&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "root";// sql用户名
		String psd = "lyp82nlf.";// sql密码
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, user, psd);
			Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// JOptionPane.showMessageDialog(null, "RUNNING......");
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "SQL链接不成功！"); // 未查找到相应的连接内容
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "FAIL！"); // 数据库未连接
		}

	}

	public static void main(String[] args) {
		Frame_main fr = new Frame_main(ac);
	}

}
