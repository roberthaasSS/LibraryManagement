/**
 * 
 */
package com.ss.library.controller;

import java.util.Scanner;

/**
 * @author Robert Haas
 *
 */
public class userInput {

	/**
	 * @param args
	 */
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		user();
		scan.close();
	}

	public static void user() { // Calls a different class method depending on the users input
		System.out.println("Welcome to the SS Library Management System. Which category of a user are you? Please input the number of the choice\n"
				+ "1) Librarian\n2) Administrator\n3) Borrower\n4) Close application");

		int num = BaseController.getInt(4);
		switch (num) {
		case 0:
			System.out.println("Incorrect input\n");
			user();
			break;
		case 1:
			System.out.println();
			LibraryInput.librarian();
			break;
		case 2:
			System.out.println();
			AdminInput.admin();
			break;
		case 3:
			System.out.println();
			BorrowerInput.borrower();
			break;
		case 4:
			break;
		}
		
		BaseController.close();
		scan.close();
	}
}
