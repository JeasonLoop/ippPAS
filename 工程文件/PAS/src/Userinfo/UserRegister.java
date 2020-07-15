package Userinfo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataBaseOperation.DBcon;
import DataBaseOperation.UserInsert;

public class UserRegister extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7423654725196853481L;
	JTextField account= new JTextField(20);//�����˺�
	JTextField password= new JTextField(20);//��������
	JTextField confirmpassWord= new JTextField(20);//ȷ������
	JTextField phoneNumber= new JTextField(20);//����绰����
	JLabel ac=new JLabel("�������˻�:");
	JLabel tips=new JLabel(" ��ʽ:��ĸ��ͷ��λ��8-18λ ,�������ַ����»��ߵ�  ");
	JLabel pw=new JLabel("   ��������:");
	JLabel confirmPw=new JLabel("   ȷ������:");
	JLabel pN=new JLabel("   �ֻ�����:");
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	 String acc,pword,pNumber;  //������ĸ�����
	 JButton confirm0=new JButton("ȷ��");
	 JButton cancel0=new JButton("ȡ��");
	 
	 String regex="^[a-zA-Z]\\w{5,17}$";//����˺� ��ĸ��ͷ6-18λ �˺�
	 String regex1="^1(3|4|5|7|8)\\d{9}$";
	 public UserRegister()
	 {
		  this.setTitle("ע��");
		  this.setSize(300,230);  
		  this.setLayout(new BorderLayout());
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  this.setLocationRelativeTo(null); 
		 
		  jp1.setLayout(new FlowLayout());
		  jp2.setLayout(new FlowLayout());
		  
		 jp1.add(ac); jp1.add(account);
		 jp1.add(tips);
		 jp1.add(pw); jp1.add(password);
		 jp1.add(confirmPw); jp1.add(confirmpassWord);
		 jp1.add(pN); jp1.add(phoneNumber);
		 this.add(jp1);
		
		 jp2.add(confirm0); 
		 jp2.add(cancel0);
		 this.add(jp2,BorderLayout.SOUTH);
		 this.setVisible(true);
		 
		 confirm0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   DBcon dbc=new DBcon();
					   Connection c=dbc.getCon();
					   String a1=account.getText();
					   String a2=password.getText();
					   String a3=confirmpassWord.getText();
					   String a4=phoneNumber.getText();
					 
					if(e.getSource()==confirm0) {
						if(!a1.equals("")&&!a2.equals("")&&!a3.equals("")&&!a4.equals(""))
						{
							if(!a2.equals(a3)) {
								JOptionPane.showMessageDialog(null,"�������벻һ�£�" );
							     password.setText("");
							     confirmpassWord.setText("");
							}
							if(!a4.matches(regex1)) {
								JOptionPane.showMessageDialog(null,"��������ȷ���ֻ����룡" );
							}
							if(a1.matches(regex)) {
								if(c!=null) {
									try {
										 Statement s =  c.createStatement();
										 boolean f=true;
										 ResultSet n = s.executeQuery("select * from userinfo");
										 while(n.next()) {
											 String t1=n.getString(1);
											 if(a1.equals(t1))
											 {
											   f=false;
											   break;
											 }	
										 }		
										 if(f) {
											 JOptionPane.showMessageDialog(null,"ע��ɹ���" );
											 UserInsert.Register(a1, a3, a4);
											 dispose();
										 }
										 else {
											 JOptionPane.showMessageDialog(null,"�û����Ѵ��ڣ�" );
										 }
										 n.close(); s.close(); c.close();
							} catch (SQLException e1) {
								e1.printStackTrace();
							} 
								
						}
					}
			}
						else
						{
							 JOptionPane.showMessageDialog(null,"��������������ݣ�" );
						}
						
						
				
				 
			}
				}
		 });
		 cancel0.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
			 }
		 });
	 }

	
}
