package DataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库连接
public class DBcon {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/pas?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";// 连接数据库的地址
	public static final String USER = "root";// 数据库用户名
	public static final String PWD = "lyp82nlf.";// 数据库密码
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public DBcon() {
		try {
			// 加载驱动程序
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 返回数据库连接
	public Connection getCon() {
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 关闭开启的资源
	public void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// pras是参数列表 sql是对应的sql执行语句 返回值是收到影响的条数
	public int update(String sql, Object... pras) {
		int resu = 0;
		con = getCon();
		try {
			ps = con.prepareStatement(sql);// 接收sql语句
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					ps.setObject(i + 1, pras[i]);
				}
			}
			resu = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return resu;
	}

	// 结果集
	public ResultSet query(String sql, Object... pras) {
		con = getCon();
		try {
			ps = con.prepareStatement(sql);
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					ps.setObject(i + 1, pras[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
