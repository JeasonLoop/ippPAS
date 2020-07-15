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
	String Did;// ��Ҫɾ����id��
	Box baseBox, box1, box2;// ���
	JButton btn1 = new JButton("OK");
	DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
	JComboBox deleteType = new JComboBox<>(ComboBoxModel);

	public PasDelete(String ac) {
		this.setBounds(100, 100, 310, 100);
		this.setTitle("DELETE");
		this.setLayout(new java.awt.FlowLayout());// ����
		init(ac);
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);// ֻ�رյ�ǰ����
		this.setLocationRelativeTo(null);
	}

	
	void init(String ac) {// ����
		ComboBoxModel.addElement("֧��");
		ComboBoxModel.addElement("����");
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("ID��"));
		box2 = Box.createVerticalBox();
		box2.add(id);

		baseBox = Box.createHorizontalBox();
		baseBox.add(box1);
		box2.add(Box.createVerticalStrut(10));
		baseBox.add(box2);

		add(baseBox);// ����
		add(btn1);
		add(deleteType);
		btn1.addActionListener(new ActionListener() { // Ϊɾ����ťע��ʱ�������
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Did = id.getText();
				String DType = (String) deleteType.getSelectedItem();
				if (!id.equals("")) {// ID��Ϊ��
					try {
						Integer.parseInt(Did); // ֻ��Ϊ������
						DBcon dBcon = new DBcon();
						Connection con = dBcon.getCon();
						if (con == null) {
							System.out.println("���ݿ�ɾ������ʧ��");
						} else {
							System.out.println("���ݿ�ɾ�����ӳɹ�");
							DBdelete.Delete(Did, DType,ac);
							id.setText("");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "ID��ʽ����ȷ�����������룡");
					}
				} else {
					JOptionPane.showMessageDialog(null, "���ݲ���Ϊ�գ��벹��������");
				}
			}
		});
	}

}
