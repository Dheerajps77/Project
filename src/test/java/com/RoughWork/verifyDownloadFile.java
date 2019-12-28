package com.RoughWork;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;

public class verifyDownloadFile {

	static ArrayList<String> numbersOfFiles = null;

	/***
	 * This verify the particular downloaded file in download sections
	 * 
	 * @param nameOfFile
	 * @param file_Name
	 * @param downloadDirectoryPath
	 * @param numberOfFiles
	 * @return boolean
	 */
	public static boolean verifyIfParticularFileDownloaded(String nameOfFile, String downloadDirectoryPath,
			File[] numberOfFiles) {
		ArrayList<String> foundedFiles = null;
		boolean flag = false;
		try {
			foundedFiles = numberOfFilesFoundInTheDownloadSections(nameOfFile, downloadDirectoryPath, numberOfFiles);
			Iterator<String> iterator = foundedFiles.iterator();
			while (iterator.hasNext()) {
				String str = iterator.next();
				if (nameOfFile.equalsIgnoreCase(str)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/***
	 * number of files which is download in download sections
	 * 
	 * @param nameOfFile
	 * @param file_Name
	 * @param downloadDirectoryPath
	 * @param numberOfFiles
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> numberOfFilesFoundInTheDownloadSections(String nameOfFile,
			String downloadDirectoryPath, File[] numberOfFiles) {
		numbersOfFiles = new ArrayList<String>();
		try {

			File file = new File(downloadDirectoryPath);
			numberOfFiles = file.listFiles();
			int totalNumberOfDownloadedFiles = numberOfFiles.length;
			for (int i = 1; i < totalNumberOfDownloadedFiles; i++) {
				nameOfFile = numberOfFiles[i].getName().toString();
				numbersOfFiles.add(nameOfFile);
			}

		} catch (Exception e) {
			throw e;
		}
		return numbersOfFiles;
	}

	public static void main(String[] args) {

		try {
			String downloadDirectoryPath = "C:\\Users\\Rahul\\Downloads";
			File[] numberOfFiles = null;
			String nameOfFile = "pdf4.pdf";
			boolean flag = verifyIfParticularFileDownloaded(nameOfFile, downloadDirectoryPath, numberOfFiles);
			Assert.assertTrue(flag, "File not found in the downloaded sections");
		} catch (Exception e) {
			throw e;
		}
	}

}
