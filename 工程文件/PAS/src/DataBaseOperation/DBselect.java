package DataBaseOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DataBaseOperation.DBcon;

public class DBselect {
	// �������ݿ��ѯ����

	public static String Smoney;
	public static String Sdate;
	public static String Sremark;

	public static void select(String idString, String getItem) {
		if (getItem.equals("����")) {
			int i = 0;
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn != null) {
				try {
					Statement sm = conn.createStatement();
					ResultSet n = sm.executeQuery("call SelectSingleINCOME("+"'"+idString+"')");
					while (n.next()) {
						Sdate = n.getString(1);
						Smoney = n.getString(2);
						Sremark = n.getString(3);
						i++;

					}
					n.close();
					sm.close();
					conn.close();
					if (i >0) {
						JOptionPane.showMessageDialog(null, "��ѯ�ɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "��������ȷ��ID��");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} 
		if (getItem.equals("֧��")) {
			int i = 0;
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn != null) {
				try {
					Statement sm = conn.createStatement();
					ResultSet n = sm.executeQuery("call SelectSingleEXPEND("+"'"+idString+"')");
					while (n.next()) {
						Sdate = n.getString(1);
						Smoney = n.getString(2);
						Sremark = n.getString(3);
						i++;

					}
					n.close();
					sm.close();
					conn.close();
					if (i >0) {
						JOptionPane.showMessageDialog(null, "��ѯ�ɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "��������ȷ��ID��");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	
}
