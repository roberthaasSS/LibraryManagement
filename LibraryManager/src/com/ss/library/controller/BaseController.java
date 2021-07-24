/**
 * 
 */
package com.ss.library.controller;

import java.util.List;
import java.util.Scanner;

import com.ss.library.entity.LibraryBranch;
import com.ss.library.service.Librarian;

/**
 * @author Robert Haas
 *
 */
public class BaseController {
	
	static Scanner scan = new Scanner(System.in);
	
	public static LibraryBranch printLibBranchList(){
		System.out.println("-------------------------------------------------\n");
		Librarian<LibraryBranch> lib = new Librarian<LibraryBranch>();
		List<LibraryBranch> list = null;
		try {
			list = lib.readLibraryBranch();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		list.forEach(l -> {
			System.out.println(l.getBranchID() + ") " + l.getBranchName());
		});
		
		int num = list.size() + 1;
		System.out.println(num + ") Quit to previous\n");

		System.out.println("Please enter the number of the Branch from the list above");

		int choice = BaseController.getInt(num);

		if (choice == num) {
			return null;
		}
		
		else {
			for (LibraryBranch l : list) {
				if (l.getBranchID() == choice) {
					return l;
				}
			}
		}
		
		return null;
	}
	
	public static int getInt(int limit) {
		int num = 0;
		try {
			num = scan.nextInt();
			if (num < 1 || num > limit) {
				System.out.println("Please enter a valid choice\n");
				num = getInt(limit);
			}
		} catch (Exception e) {
			System.out.println("Please enter a number\n");
			scan.next();
			num = getInt(limit);
		}
		return num;
	}
	
	public static void close() {
		scan.close();
	}
}