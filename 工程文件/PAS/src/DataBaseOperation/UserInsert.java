package DataBaseOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserInsert {
	public static void Register(String userAc, String userpassword, String userMobile) {
		DBcon dBcon = new DBcon();
		Connection conn = dBcon.getCon();
		if (conn != null) {
			try {
				Statement sm = conn.createStatement();// �������ӻ�ȡһ��ִ��sql���Ķ���
				int n = sm.executeUpdate("call Userinsert(" + "'" + userAc + "'" + "," + "'" + userpassword + "'" + ","
						+ "'" + userMobile + "'" + ")");
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "������ӳɹ���");
				} else {
					JOptionPane.showMessageDialog(null, "�������ʧ�ܣ�");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
