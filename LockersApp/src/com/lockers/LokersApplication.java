package com.lockers;

import java.io.IOException;
import java.util.Scanner;

import com.lockers.operations.FileOperations;
import com.lockers.operations.FileOperationsImpl;


public class LokersApplication {
	
	static String directoryPath = "E:\\Study Material\\study material";
	static FileOperations fileOperations = new FileOperationsImpl();
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("============Welcome to the Lockers Application============\n");

		System.out.println("Application Name: Lockers File Application");
		System.out.println("Developed by: Abhishek Ghute");

		loopLabel: while (true) {
			System.out.println("Select Option:");
			System.out.println("1.Show files");
			System.out.println("2.Perform File Operations");
			System.out.println("3.Exit from the Applicatiion");

			int choice = sc.nextInt();
		
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
		System.out.println("Select Opertion to be peformed(case insensetive)");

		System.out.println("A.Add file");
		System.out.println("B.Delete File");
		System.out.println("C.Search File");

		char choice = sc.next().toLowerCase().charAt(0);
		sc.nextLine();
		
		String fileName = null;
		
		switch (choice) {
		case 'a':
			System.out.println("Enter File Name to add");
			fileName = sc.nextLine();
			fileOperations.addFile(directoryPath,fileName);
			break;

		case 'b':
			fileName = sc.nextLine();
			fileOperations.deleteFile(directoryPath, fileName);
			break;

		case 'c':
			fileName = sc.nextLine();
			fileOperations.searchFile(directoryPath, fileName);
			break;

		default:
			System.out.println("Enter correct choice..");
			break;
		}
	}
}