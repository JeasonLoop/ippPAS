package services;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Detail_Accounts extends JFrame implements ActionListener {

	JButton income, expend, details;
	JPanel panel;
static String User;
	public Detail_Accounts(String ac) {
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// 只关闭当前窗口
		this.setLocationRelativeTo(null);
        User=ac;
		income = new JButton("查询收入");
		income.addActionListener(this);
		expend = new JButton("查询支出");
		expend.addActionListener(this);
		details = new JButton("收支明细");
		details.addActionListener(this);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		this.setBounds(620, 360, 310, 100);
		this.setTitle("详细查询");

		panel.add(income);
		panel.add(expend);
		panel.add(details);

		this.add(panel);
	}


	public static void main(String[] args) {
		Detail_Accounts da = new Detail_Accounts(User);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == income) {
			SelectALL SA = new SelectALL("查询收入",User);
		} else if (e.getSource() == expend) {
			SelectALL S = new SelectALL("查询支出",User);
		} else if (e.getSource() == details) {
			new Profit_loss_details(User);
		}
	}

}
