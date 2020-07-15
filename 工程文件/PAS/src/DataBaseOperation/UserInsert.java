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
				Statement sm = conn.createStatement();// 根据连接获取一个执行sql语句的对象
				int n = sm.executeUpdate("call Userinsert(" + "'" + userAc + "'" + "," + "'" + userpassword + "'" + ","
						+ "'" + userMobile + "'" + ")");
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "数据添加成功！");
				} else {
					JOptionPane.showMessageDialog(null, "数据添加失败！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
