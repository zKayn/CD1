package main;

import com.mysql.jdbc.Connection;

import context.DBContext;
import dao.DAO;

public class test {

	public static void main(String[] args) {
		
            DAO dao = new DAO();
            dao.login("123", "123");
}
}