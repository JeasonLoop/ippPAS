package DataBaseOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import DataBaseOperation.DBcon;

public class DBdelete {

	public static void Delete(String did, String DType, String ac) {
		if (DType.equals("支出")) {
			// TODO Auto-generated method stub
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn == null) {
				dBcon.getCon();
			}
			PreparedStatement sm = null;// PreparedStatement用于使用绑定变量重用执行计划
			try {
				String sql = "delete from expendac where TID = ? and UserID = ?";
				sm = conn.prepareStatement(sql);
				sm.setString(1, did);// 给第一个问号赋值
				sm.setString(2, ac);
				int n = sm.executeUpdate();
				if (n > 0) {
					JOptionPane.showMessageDialog(null, " 删除成功！");

				} else {
					JOptionPane.showMessageDialog(null, "请输入正确的ID！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DType.equals("收入")) {
			DBcon dBcon = new DBcon();
			Connection conn = dBcon.getCon();
			if (conn == null) {
				dBcon.getCon();
			}
			PreparedStatement sm = null;// PreparedStatement用于使用绑定变量重用执行计划
			try {
				String sql = "delete from incomeac where TID = ?";
				sm = conn.prepareStatement(sql);
				sm.setString(1, did);// 给第一个问号赋值
				int n = sm.executeUpdate();
				if (n > 0) {
					JOptionPane.showMessageDialog(null, " 删除成功！");

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
