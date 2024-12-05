package com.book;
import java.util.Scanner;

public class BookOperation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("*************************");
			System.out.println("1.Add Book: ");
			System.out.println("2.Delete Book: ");
			System.out.println("3.Update Book: ");
			System.out.println("4.Display All Book: ");
			System.out.println("5.Information About Book Table: ");
			System.out.println("6.Exit");
			System.out.println("*************************");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				MainApp.AddBook();
			}
				break;
			case 2: {
				MainApp.DeleteBook();

			}
				break;
			case 3: {
				MainApp.UpdateBook();
			}
				break;
			case 4: {
				MainApp.DisplayAllBook();
			}
				break;
			case 5:{
				MainApp.metaDataofStructre();
			}
			break;
			case 6: {
				System.out.println("Thank you!!! ");
				break;
			}
			}

		} while (choice != 6);

	}

}
