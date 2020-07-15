package DataBaseOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBupdate {
	public static void update(String Uid, String Utype, String Umoney, String Utime, String Uremark) {
		if (Utype.equals("收入")) {
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn != null) {
				try {
					Statement sm = conn.createStatement();
					int n = sm.executeUpdate("call INCOMEupdate(" + Uid + "," +Umoney + "," + "'" + Utime + "'" + ","
							+ "'" + Uremark + "'" + ")");
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "数据更新成功！");
					} else {
						JOptionPane.showMessageDialog(null, "ID信息不符合，请确认后重新输入");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (Utype.equals("支出")) {
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn != null) {
				try {
					Statement sm = conn.createStatement();
					int n = sm.executeUpdate("call EXPENDupdate("+ Uid + "," +"-"+ Umoney + "," + "'" + Utime + "'" + ","
							+ "'" + Uremark + "'" + ")");
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "数据更新成功！");
					} else {
						JOptionPane.showMessageDialog(null, "ID信息不符合，请确认后重新输入");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
