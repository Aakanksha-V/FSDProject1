package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class FIle {

    public static String root = "D:\\Root\\";
    public static Scanner input = new Scanner(System.in);
    // Make sure Root folder is present in D directory in order to run program properly.
    public static void addFile(String filename){
        Path path = Paths.get(root+filename);
        try {

            Files.createDirectories(path.getParent());
            Files.createFile(path);
            System.out.println(filename+" Created Successfully");

        }catch(IOException ioException) {
            System.out.println("Failed to create File...");
        }
    }

    public static void deleteFile(String fileName){
        File file = new File(root+fileName);
        if(file.delete()) {
            System.out.println("File Deleted");
        }
        else
            System.out.println("File not found!");
    }

    public static void searchFile(String fileName){
        File file = new File(root+fileName);
        if (file.exists())
            System.out.println("File is present in "+root+fileName);
        else
            System.out.println("File is not present in directory");
    }

    public static void fileList(){
        System.out.println("List of files in Root directory:");
        File filePath = new File(root);
        String listOfFiles[] = filePath.list();
        Arrays.sort(listOfFiles);
        if (listOfFiles.length < 1)
            System.out.println("Root Directory does not contain any file");
        else
            for(int i =1 ; i <= listOfFiles.length; i++)
                System.out.println(i+ ". " +listOfFiles[i-1]);
    }
}
