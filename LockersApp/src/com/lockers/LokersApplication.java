package com.lockers;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockers.operations.FileOperations;
import com.lockers.operations.FileOperationsImpl;


public class LokersApplication {
	
	static String directoryPath = "c:\\simplilearn";
	static FileOperations fileOperations = new FileOperationsImpl();
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("============Welcome to the Lockers Application============\n");

		System.out.println("Application Name: Lockers File Application");
		System.out.println("Developed by: Abhishek Ghute");

		loopLabel: while (true) {
			System.out.println("1.Show files");
			System.out.println("2.Perform File Operations");
			System.out.println("3.Exit from the Applicatiion");
			
			System.out.println("Enter Option:");
			int choice =0;
			while(true) {
				try {
					choice= sc.nextInt();
					break;
				}catch (Exception e) {
					System.out.println("Enter valid input only like...1,2,3..");
					sc.nextLine();
				}
			}
		
			switch (choice) {
			case 1:
				fileOperations.getFileNames(directoryPath);
				break;

			case 2:
				selectFileOperaton(sc);
				break;

			case 3:
				break loopLabel;

			default:
				System.out.println("Enter correct choice..");
				break;
			}
		}

		System.out.println("Thanks for using Lockers Application");
		sc.close();
	}

	public static void selectFileOperaton(Scanner sc) {
		
		sc.nextLine();
		
		outerLoop:while(true) {
			
			System.out.println("Select Opertion to be peformed(case insensetive)");

			System.out.println("A.Add file");
			System.out.println("B.Delete File");
			System.out.println("C.Search File");
			System.out.println("D.Main Dashboard");
			System.out.println("Enter your choice");
			
			String temp = sc.nextLine().toLowerCase();
			while(temp.length()>1)
			{
				System.out.println("Invalid Input...Input length must be 1 character");
				System.out.println("Enter your choice");
				temp = sc.nextLine().toLowerCase();
				temp = temp.toLowerCase();
			}
			char choice = temp.charAt(0);

			String fileName = null;
			
			switch (choice) {
			case 'a':
				System.out.println("Enter File Name to add");
				fileName = sc.nextLine();
				fileOperations.addFile(directoryPath,fileName);
				break;

			case 'b':
				System.out.println("Enter File Name to delete");
				fileName = sc.nextLine();
				fileOperations.deleteFile(directoryPath, fileName);
				break;

			case 'c':
				System.out.println("Enter File Name to search");
				fileName = sc.nextLine();
				fileOperations.searchFile(directoryPath, fileName);
				break;
			
			case 'd':
				break outerLoop;

			default:
				System.out.println("Enter correct choice..");
				break;
			}
		}
	}
}