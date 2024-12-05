package com.book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp {

	static Connection con = ConnectionClass.ConnectionFun();

	static Scanner sc = new Scanner(System.in);

	public static void AddBook() {
		String query = "insert into Book values(?,?,?,?)";
		System.out.println("Enter Book ID:  ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name: ");
		String name = sc.nextLine();

		System.out.println("Enter Book Price: ");
		double price = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter Book Author Name: ");
		String aname = sc.nextLine();
		try {
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, price);
			pstmt.setString(4, aname);

			int rowAffected = pstmt.executeUpdate();
			if (rowAffected > 0) {
				System.out.println("Book Add successfully!!!  "+"RowAffected: "+rowAffected);
			} else {
				System.out.println("No Book Found!!! ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void DeleteBook() {

		System.out.println("Enter Book ID:  ");
		int id = sc.nextInt();
		String deletequery = "delete from Book  where id=?";
		try {
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(deletequery);
			pstmt.setInt(1, id);
			int rowAffected = pstmt.executeUpdate();
			System.out.println(rowAffected);
			if (rowAffected > 0) {
				System.out.println("Book Delete successfully!!!  "+"Row Affected: "+rowAffected);
			} else {
				System.out.println("No Book Found!!! ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void UpdateBook() {
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Book Name: ");
		String name = sc.nextLine();

		System.out.println("Enter Book Price: ");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.println("Enter Book Author Name: ");
		String aname = sc.nextLine();

		String updatequery = "update Book set Name=?,Price=?, AName=? where id=?";
		try {
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(updatequery);
			pstmt.setString(1, name);
			pstmt.setDouble(2, price);
			pstmt.setString(3, aname);
			pstmt.setInt(4, id);

			int rowAffected = pstmt.executeUpdate();
			
			if (rowAffected > 0) {
				System.out.println("Book updated successfully!!! "+"Row Affected: "+rowAffected);
			} else {
				System.out.println("No Book Found!!! ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void DisplayAllBook() {
		try {
			PreparedStatement pstmt = null;
			String displayquery = "select * from Book;";
			pstmt = con.prepareStatement(displayquery);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String aname = rs.getString("aname");
				System.out.println(id + " " + name + " " + price + " " + aname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void metaDataofStructre() {

		String squery = "select id,  name, price, aname from Book;";
		try {
			PreparedStatement pstmt = null;

			pstmt = con.prepareStatement(squery);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			 for (int i = 1; i <= columnCount; i++) {
	                System.out.println("Column " + i + ":");
	                System.out.println("  Name: " + metaData.getColumnName(i));
	                System.out.println("  Label: " + metaData.getColumnLabel(i));
	                System.out.println("  Type: " + metaData.getColumnTypeName(i));
	                System.out.println("  Display Size: " + metaData.getColumnDisplaySize(i));
	                System.out.println("  Precision: " + metaData.getPrecision(i));
	                System.out.println("  Scale: " + metaData.getScale(i));
	                System.out.println("  Nullable: " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
	                System.out.println("  Auto Increment: " + metaData.isAutoIncrement(i));
	            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
