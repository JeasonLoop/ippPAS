package DataBaseOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import DataBaseOperation.DBcon;

public class DBdelete {

	public static void Delete(String did, String DType, String ac) {
		if (DType.equals("֧��")) {
			// TODO Auto-generated method stub
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn == null) {
				dBcon.getCon();
			}
			PreparedStatement sm = null;// PreparedStatement����ʹ�ð󶨱�������ִ�мƻ�
			try {
				String sql = "delete from expendac where TID = ? and UserID = ?";
				sm = conn.prepareStatement(sql);
				sm.setString(1, did);// ����һ���ʺŸ�ֵ
				sm.setString(2, ac);
				int n = sm.executeUpdate();
				if (n > 0) {
					JOptionPane.showMessageDialog(null, " ɾ���ɹ���");

				} else {
					JOptionPane.showMessageDialog(null, "��������ȷ��ID��");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DType.equals("����")) {
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn == null) {
				dBcon.getCon();
			}
			PreparedStatement sm = null;// PreparedStatement����ʹ�ð󶨱�������ִ�мƻ�
			try {
				String sql = "delete from incomeac where TID = ?";
				sm = conn.prepareStatement(sql);
				sm.setString(1, did);// ����һ���ʺŸ�ֵ
				int n = sm.executeUpdate();
				if (n > 0) {
					JOptionPane.showMessageDialog(null, " ɾ���ɹ���");

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
