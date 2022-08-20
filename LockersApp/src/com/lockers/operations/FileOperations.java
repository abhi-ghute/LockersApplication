package com.lockers.operations;

import java.nio.file.Path;

public interface FileOperations {

	public void getFileNames(String directoryPath);
	public void addFile(String directoryPath,String fileName);
	public void deleteFile(String directoryPath,String fileName);
	public void searchFile(String directoryPath,String fileName);
}
