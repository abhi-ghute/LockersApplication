package com.lockers;

import java.io.IOException;
import java.util.Scanner;

import com.lockers.operations.FileOperations;
import com.lockers.operations.FileOperationsImpl;


public class LokersApplication {
	
	static String directoryPath = "c:\\simplilearn";
	static FileOperations fileOperations = new FileOperationsImpl();
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("============Welcome to the Lockers Application============");
		System.out.println("**							**");
		System.out.println("**	Application Name: Lockers File Application	**");
		System.out.println("**	Developed by: Abhishek Ghute			**");
		System.out.println("**							**");
		System.out.println("***********************************************************\n");

		loopLabel: while (true) {
			System.out.println("Select your choice...");
			System.out.println("1.Show files");
			System.out.println("2.Perform File Operations");
			System.out.println("3.Exit from the Applicatiion");
			System.out.println();
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
			System.out.println();
			switch (choice) {
			case 1:
				String[] fNames =fileOperations.getFileNames(directoryPath);
				if (fNames.length == 0) {
					System.out.println("No file present inside the folder..");
				}else {
					System.out.println("List of files present inside the folder..");
					for (int i = 0; i < fNames.length; i++)
						System.out.println(fNames[i]);
				}
				System.out.println();
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
			System.out.println();
			System.out.println("Enter your choice");
			
			String temp = sc.nextLine().toLowerCase();
			System.out.println();
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
				String addResult = fileOperations.addFile(directoryPath,fileName);
				System.out.println(addResult);
				break;

			case 'b':
				System.out.println("Enter File Name to delete");
				fileName = sc.nextLine();
				String deleteResult = fileOperations.deleteFile(directoryPath, fileName);
				System.out.println(deleteResult);
				break;

			case 'c':
				System.out.println("Enter File Name to search");
				fileName = sc.nextLine();
				boolean flag = fileOperations.searchFile(directoryPath, fileName);
				if(flag==true) {
					System.out.println("File is present in the directory "+directoryPath);
				}else {
					System.out.println("File is not present in the directory "+directoryPath);
				}
				break;
			
			case 'd':
				break outerLoop;

			default:
				System.out.println("Enter correct choice..");
				break;
			}
			System.out.println();
		}
	}
}