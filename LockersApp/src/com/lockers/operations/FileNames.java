package com.lockers.operations;

import java.io.File;
import java.util.Arrays;

public class FileNames {

	File directoryPath = new File("E:\\Study Material\\study material1");
	
	public void getFileNames() {
		
		String[] fNames = directoryPath.list(); 
		Arrays.sort(fNames);
		for(int i=0;i<fNames.length;i++)
			System.out.println(fNames[i]);
	}
}
