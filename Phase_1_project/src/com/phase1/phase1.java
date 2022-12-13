package com.phase1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class phase1 {
	
	///////////////////////////////
	
	// Method for provide the list of files
		private static void filelist() {

			// Create an object of the File class
			File dirFiles = new File("D://simplilearn//");
			ArrayList<File> files = new ArrayList<File>();
			File filearr[] = dirFiles.listFiles();
			int indicator = 0;
			int filecount = 0;

			for (int i = 0; i < filearr.length; i++) {
				if (filearr[i].isFile()) {
					files.add(filearr[i]);
					indicator = 1;
					filecount = filecount + 1;
				}
			}
			Collections.sort(files); // to sort the list of files
			for (int i = 0; i < filecount; i++) {
				System.out.println(files.get(i).getName());
			}
			if (indicator == 0) {
				System.out.println("There is no file available in the given Directory.");
			} else {
				System.out.println("Total number of files : " + filecount + "\n");
			}
		}

		// Method for add a file
		private static void addfile() {
			System.out.println("To create a file, enter the file name.");
			Scanner sc1 = new Scanner(System.in); // Create an object of scanner class
			String filename = sc1.next();
			// try-catch for handle IOException
			try {
				File file = new File("D://simplilearn//" + filename);
				if (file.createNewFile()) {
					System.out.println('"' + filename + '"' + " File created successfully.");
				} else {
					System.out.println('"' + filename + '"' + " File already exist.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Method for delete a file
		private static void delete() {

			System.out.println("To delete a file, enter the file name.");
			Scanner sc2 = new Scanner(System.in);
			String filename2 = sc2.next();

			// Create an object of the File class
			File dlist = new File("D://simplilearn//");
			String[] flist = dlist.list();
			int notfy = 0;
			if (flist == null) {
				System.out.println(filename2 + "There is no file in the directory");
			} else {

				// Linear search in the array
				for (int i = 0; i < flist.length; i++) {
					String filename1 = flist[i];
					if (filename1.equals(filename2)) {
						File del_file1 = new File("D://simplilearn//" + filename2);
						if (del_file1.delete()) {
							System.out.println('"' + filename2 + '"' + " File deleted successfully.");
						}
						notfy = 1;
					}
				}
			}

			if (notfy == 0) {
				System.out.println('"' + filename2 + '"' + " File not found.");
			}
		}

		/////////////////////////////////////////////////////////////////
		private static void search() {

			System.out.println("To search a file, enter the file name.");
			Scanner sc2 = new Scanner(System.in);
			String filename2 = sc2.next();

			File dlist = new File("D://simplilearn//");
			String[] flist = dlist.list();
			int notfy = 0;
			if (flist == null) {
				System.out.println("There is no file present in the directory");
			} else {

				// Linear search in the array
				for (int i = 0; i < flist.length; i++) {
					String filename1 = flist[i];
					if (filename1.equals(filename2)) {

						System.out.println("File found: " + '"' + filename1 + '"');
						notfy = 1;
					}
				}
			}

			if (notfy == 0) {
				System.out.println("File Not Found");
			}
		}

		// Method for chose user input
		private static int getOption() {
			Scanner input = new Scanner(System.in);

			int returnOption = 0;
			// try-catch to handle InputMismatchException
			try {
				returnOption = input.nextInt();
			} catch (InputMismatchException ex) {
				System.out.print("invalid input");
			}
			return returnOption;
		}

		// Method for display main menu option
		private static void mainMenu() {

			System.out.println("You are on the Main Menu : ");
			System.out.println("Choose an option to do the operation : ");
			System.out.println("Enter the number 1 to display the current file list");
			System.out.println("Enter the number 2 to display the user interface");
			System.out.println("Enter the number 3 to exit the application");
		}

		// Method for display main sub-menu option
		private static void submainMenu() {

			System.out.println("Choose an option to do the operation : ");
			System.out.println("Enter the number 1 to Add a File");
			System.out.println("Enter the number 2 to Delete a File");
			System.out.println("Enter the number 3 to Search a File");
			System.out.println("Enter the number 4 Back to Main Menu");
		}

		// Method to provide navigation
		private static void adminMethod(int getoption) {

			
			switch (getoption) {
			case 1:
				filelist();
				break;
			case 2:
				do {
					submainMenu();
					int suboption = getOption();
					switch (suboption) {
					case 1:
						addfile();
						break;
					case 2:
						delete();
						break;
					case 3:
						search();
						break;
					case 4:
						mainMenu();
						int option = getOption();
						adminMethod(option);
						break;
					default:
						System.out.println("Input correct number and try again...\n");
					}
				} while (true);
			case 3:
				System.out.println("Thank you for using our application.");
				System.exit(0);
				break;
			default:
				System.out.println("Please try again...\n");
			}
			
		}

		public static void main(String[] args) {

			System.out.println("Welcome to my project \n");
			System.out.println("Project name : LockedMe.com");
			System.out.println("Developed By : Sourav Kumar Chakravartty");
			System.out.println("Company Name : Lockers Pvt. Ltd. \n");

			do {
				mainMenu();
				int option = getOption();
				adminMethod(option);
			} while (true);
		}
	
	
	////////////////

}
