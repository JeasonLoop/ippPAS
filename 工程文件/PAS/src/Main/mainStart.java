package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class mainStart {
	JButton comein = new JButton("COME TO LOGIN");
	JLabel label = new JLabel("欢迎使用天天记账");
	JFrame start = new JFrame();

	private void init() {
		start.setTitle("MENU");
		start.setSize(573, 350);
		String basepath = "D:\\Java-workspace\\PAS\\image\\main_0.jpg";// 获取图片路径
		try {
			basepath = URLDecoder.decode(basepath, "utf-8");// 解决路径乱码问题
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon ico = new ImageIcon(basepath);
		JLabel j = new JLabel(ico);
		j.setBounds(0, -15, start.getWidth() - 10, start.getHeight() - 10);
		JPanel t = new JPanel();
		t.add(comein);
		t.add(label);
		t.add(j);

		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setVisible(true);

		start.setLocationRelativeTo(null);
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setForeground(Color.BLACK);
		label.setBounds(185, 20, 250, 60);

		t.setLayout(null);
		comein.setBounds(210, 230, 140, 60);

		start.add(t);

		comein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comein) {
					new Login();
					start.dispose();
				}
			}
		});
	}

	public mainStart() {
		this.init();
	}

	public static void main(String[] args) {

		new mainStart();
	}
}
