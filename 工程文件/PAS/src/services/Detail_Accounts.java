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
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// ֻ�رյ�ǰ����
		this.setLocationRelativeTo(null);
        User=ac;
		income = new JButton("��ѯ����");
		income.addActionListener(this);
		expend = new JButton("��ѯ֧��");
		expend.addActionListener(this);
		details = new JButton("��֧��ϸ");
		details.addActionListener(this);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		this.setBounds(620, 360, 310, 100);
		this.setTitle("��ϸ��ѯ");

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
			SelectALL SA = new SelectALL("��ѯ����",User);
		} else if (e.getSource() == expend) {
			SelectALL S = new SelectALL("��ѯ֧��",User);
		} else if (e.getSource() == details) {
			new Profit_loss_details(User);
		}
	}

}
