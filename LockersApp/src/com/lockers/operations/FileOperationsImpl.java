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
	public void getFileNames(String directoryPath) {
		
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
			char choice = sc.next().toLowerCase().charAt(0);
			sc.close();
			
			if(choice=='y') {
				file.mkdir();
				fNames = file.list(); 
			}
			else {
				System.out.println("Please specify another directory path");
				return;
			}
			
		}
		
		
		if (fNames.length==0) {
			System.out.println("No file present inside the folder..");
		}
		
		Arrays.sort(fNames);
		for(int i=0;i<fNames.length;i++)
			System.out.println(fNames[i]);
	}

	@Override
	public void addFile(String directoryPath,String fileName) {
		
		 Path path = Paths.get(directoryPath,fileName);
		 
		 try {
	         Path createdFilePath = Files.createFile(path);
	         System.out.println("Created a file at : "+createdFilePath);
	      } 
	      catch (IOException e) {
	         e.printStackTrace();
	      }
		
	}

	@Override
	public void deleteFile(String directoryPath,String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchFile(String directoryPath,String fileName) {
		// TODO Auto-generated method stub
		
	}
}
