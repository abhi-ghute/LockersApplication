package com.lockers.operations;

import java.nio.file.Path;

public interface FileOperations {

	public String[] getFileNames(String directoryPath);
	public String addFile(String directoryPath,String fileName);
	public String deleteFile(String directoryPath,String fileName);
	public boolean searchFile(String directoryPath,String fileName);
}
