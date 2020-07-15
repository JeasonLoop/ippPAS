package DataBaseOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DataBaseOperation.DBcon;

public class DBselect {
	// 创建数据库查询变量

	public static String Smoney;
	public static String Sdate;
	public static String Sremark;

	public static void select(String idString, String getItem) {
		if (getItem.equals("收入")) {
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
						JOptionPane.showMessageDialog(null, "查询成功！");
					} else {
						JOptionPane.showMessageDialog(null, "请输入正确的ID！");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} 
		if (getItem.equals("支出")) {
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
						JOptionPane.showMessageDialog(null, "查询成功！");
					} else {
						JOptionPane.showMessageDialog(null, "请输入正确的ID！");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	
}
