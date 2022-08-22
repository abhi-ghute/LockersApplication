package com.lockers.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperationsImpl implements FileOperations {

	@Override
	public String[] getFileNames(String directoryPath) {

		String[] fNames = null;
		File file = new File(directoryPath);

		try {
			fNames = file.list();
			if (fNames == null) {
				throw new NullPointerException();
			}
		} catch (Exception npe) {
			System.out.println("Specified Folder is not present in your system... want to create(y/n)");

			Scanner sc = new Scanner(System.in);
			String temp = sc.nextLine().toLowerCase();
			while(temp.length()>1)
			{
				System.out.println("Invalid Input...Input length must be 1 character");
				System.out.println("Specified Folder is not present in your system... want to create(y/n)");
				temp = sc.nextLine().toLowerCase();
			}
			char choice = temp.charAt(0);

			if (choice == 'y') {
				file.mkdir();
				fNames = file.list();
				System.out.println("Directory creatred with "+directoryPath);
			} else{
				System.out.println("Please specify another directory path or try with valid input value");
				return fNames;
			}

		}

		if (fNames.length == 0) {
			System.out.println("No file present inside the folder..");
		}

		Arrays.sort(fNames);
		for (int i = 0; i < fNames.length; i++)
			System.out.println(fNames[i]);
		
		return fNames;
	}

	@Override
	public String addFile(String directoryPath, String fileName) {
		
		char choice=' ';
		Path path = Paths.get(directoryPath, fileName);
		
		try {
			if(Files.exists(path) == true) {
				System.out.println("File is already presnt you want to replace existing..(y/n)");
				
				Scanner sc = new Scanner(System.in);
				String temp = sc.nextLine().toLowerCase();
				while(temp.length()>1)
				{
					System.out.println("Invalid Input...Input length must be 1 character");
					System.out.println("File is already presnt you want to replace existing..(y/n)");
					temp = sc.nextLine().toLowerCase();
				}
				choice = temp.charAt(0);
				if (choice == 'y') {
					Files.delete(path);
				} else{
					return "Existing file is not replaced...please try with another file";
				}

			}
			Files.createFile(path);
		} catch (IOException e) {
			e.printStackTrace();
			return "Error occurred during file creation";
		}
		return path.toString();

	}

	@Override
	public String deleteFile(String directoryPath, String fileName) {

		Path path = Paths.get(directoryPath, fileName);

		try {
			Files.delete(path);
			return "File Deleted from the Directory" + path;
		} catch (IOException e) {
			return "Specified file is not present in the Directory "+path;
		}
	
	}

	@Override
	public boolean searchFile(String directoryPath, String fileName) {
		
		boolean flag = false;
		Path path = Paths.get(directoryPath, fileName);
		try {
			flag = Files.exists(path);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
