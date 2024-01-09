/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    public Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName+";encrypt=true;trustServerCertificate=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    private final String serverName ="LAPTOP-HGDKG65T\\TULEN";
    private final String dbName ="QuanLyPhim";
    private final String portNumber ="1433";
    private final String instance ="";
    private final String userID ="sa";
    private final String password ="123456";
    
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
            System.out.println("ttđssđsds");
        } catch (Exception e) {
        	System.out.println("Lỗi");
        }
    }
//	
	
	
//	 public static Connection getConnection() throws SQLException,ClassNotFoundException {
//	        String hostName = "LAPTOP-HGDKG65T\\TULEN:1433";
//	        String userName = "sa";
//	        String password = "123456";
//	        String dbName = "QuanLyPhim";
//	        return getConnection(hostName, dbName, userName, password);
//	    }
//	    public static Connection getConnection(String hostName, String dbName,
//	        String userName, String password) throws SQLException,ClassNotFoundException {
//	        // Khai báo class Driver cho DB MySQL
//	        // Việc này cần thiết với Java 5
//	        // Java6 tự động tìm kiếm Driver thích hợp.
//	        // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
//	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	        // Cấu trúc URL Connection dành cho Oracle
//	        // Ví dụ: jdbc:mysql://localhost:3306/simplehr
//	        String connectionURL = "jdbc:sqlserver://" + hostName +";databaseName=" +dbName+";encrypt=true;trustServerCertificate=true";
//	        Connection conn = DriverManager.getConnection(connectionURL, userName,password);
//	        return conn;
//	    }
//	    public static void main(String[] args) {
//			DBContext connect = new DBContext();
//			try {
//				connect.getConnection();
//				System.out.println("Kết nối thành công ");
//			} catch (ClassNotFoundException e) {
//				System.out.println("Thất bại");
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
}
