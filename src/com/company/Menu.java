package com.company;

import java.util.Scanner;

public class Menu {
    public static void welcome(String projectName, String developer){
        System.out.println(projectName);
        System.out.println("Developer: " + developer);
        System.out.println("\n**************************************************\n" +
                    "Functionality\n" +"# retrieve all files from \"root\" folder\n" +
                    "# add,delete,search on \"root\" folder\n" +
                    "\n**************************************************\n");
    }
    public static void printMainMenu(){
        System.out.println("\n~~~~~~~~~~ MAIN MENU ~~~~~~~~~~\n");
        System.out.println("1. Current directory file list in ascending order");
        System.out.println("2. To add, delete. search from root folder");
        System.out.println("3. Exit");
    }

    public static void printSubMenu(){
        System.out.println("\n~~~~~~~~~~ SUB MENU ~~~~~~~~~~\n");
        System.out.println("1. Add a file to Root directory ");
        System.out.println("2. Delete a file from Root directory ");
        System.out.println("3. Search a file from Root directory");
        System.out.println("4. Main Menu");

    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        boolean working = true;
        do {
            try {
                printMainMenu();
                System.out.print("Enter option: ");
                int choice = input.nextInt();
                switch (choice){
                    case 1: FIle.fileList();
                        break;
                    case 2: Menu.subMenu();
                        break;
                    case 3: System.out.println("Closing Application");
                        input.close();
                        working = false;
                        System.exit(0);
                        break;
                    default: System.out.println("Invalid Option. Please try again!5");
                        break;
                }
            }catch (Exception e){
                System.out.println("Main function exception" + e.getClass());
            }
        }while (working);
    }

    public static void subMenu(){
        Scanner input = new Scanner(System.in);
        boolean working = true;
        do {
            try {
                printSubMenu();
                System.out.print("Enter option: ");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.print("Enter name of file to be added: ");
                        String fileName = input.next();
                        FIle.addFile(fileName);
                        break;
                    case 2:
                        System.out.print("Enter name of file to be deleted : ");
                        String fileNameDelete = input.next();
                        FIle.deleteFile(fileNameDelete);
                        break;
                    case 3: System.out.print("Enter name of file to be searched: ");
                        String fileNameSearch = input.next();
                        FIle.searchFile(fileNameSearch);
                        break;
                    case 4: mainMenu();
                        break;
                    default: System.out.println("Invalid Option. Please try again!");
                        break;
                }
            }catch (Exception e){
                System.out.println("Main function exception" + e.getClass());
            }
        }while (working);
    }
}
