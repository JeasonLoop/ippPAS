package DataBaseOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DataBaseOperation.DBcon;

public class DBinsert {
	public static void Register(String UserID,String Itype, String Imoney, String Itime, String Iremark) {
		DBcon dBcon = new DBcon();
		Connection conn = dBcon.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();// �������ӻ�ȡһ��ִ��sql���Ķ���
				if (Itype.equals("����")) {
					int n = sm.executeUpdate(
							"call incomeInsert("+"'" + UserID + "'"+"," + Imoney + "," + "'" + Itime + "'" + "," + "'" + Iremark + "'" + ")");
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "������ӳɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "�������ʧ�ܣ�");
					}
				} else if (Itype.equals("֧��")) {
					int n = sm.executeUpdate(
							"call expendInsert("+"'" + UserID + "'"+","+"-" + Imoney + "," + "'" + Itime + "'" + "," + "'" + Iremark + "'" + ")");
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "������ӳɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "�������ʧ�ܣ�");
					}

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
