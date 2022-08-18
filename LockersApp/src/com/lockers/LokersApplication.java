package com.lockers;

import java.util.Scanner;

import com.lockers.operations.FileNames;

public class LokersApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============Welcome to the Lockers Application============\n");
		
		System.out.println("Application Name: Lockers File Application");
		System.out.println("Developed by: Abhishek Ghute");
		
		while (true) {
			System.out.println("Select Option:");
			System.out.println("1.Show files");
			System.out.println("2.Perform File Operations");
			System.out.println("3.Exit from the Applicatiion");
			
			int choice = sc.nextInt();
			
			if(choice==1) {
				FileNames f = new FileNames();
				f.getFileNames();
			}
			if(choice==3) {
				break;
			}
		}
		
		System.out.println("Thanks for using Lockers Application");
		sc.close();
	}
}
