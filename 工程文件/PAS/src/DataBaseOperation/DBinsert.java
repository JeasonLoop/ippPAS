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
				Statement sm = conn.createStatement();// 根据连接获取一个执行sql语句的对象
				if (Itype.equals("收入")) {
					int n = sm.executeUpdate(
							"call incomeInsert("+"'" + UserID + "'"+"," + Imoney + "," + "'" + Itime + "'" + "," + "'" + Iremark + "'" + ")");
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "数据添加成功！");
					} else {
						JOptionPane.showMessageDialog(null, "数据添加失败！");
					}
				} else if (Itype.equals("支出")) {
					int n = sm.executeUpdate(
							"call expendInsert("+"'" + UserID + "'"+","+"-" + Imoney + "," + "'" + Itime + "'" + "," + "'" + Iremark + "'" + ")");
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "数据添加成功！");
					} else {
						JOptionPane.showMessageDialog(null, "数据添加失败！");
					}

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
