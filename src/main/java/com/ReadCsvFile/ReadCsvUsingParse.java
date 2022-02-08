package com.ReadCsvFile;/* Mahadev
   08-02-2022
   Reading Csv File and Searching string is present or not
  */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCsvUsingParse
{
    public String ReadCsvFile(String file,String SearchValue)
    {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePaths = userDirectory + pathSeparator + "files" + pathSeparator+file;
        String filePath =filePaths+ "." + "csv";
        String line = SearchValue;
        String found = "Yes";
        String notFound = "No";
        boolean flag = false;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNext())
            {
                if(scanner.nextLine().contains(line))
                {
                    flag=true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        finally {
            scanner.close();
        }
        if(flag==true)
        {
            return found;
        }
        else
        {
            return notFound;
        }
    }
    public static void main(String[] args)
    {
        ReadCsvUsingParse readCsv2 = new ReadCsvUsingParse();
        String file = "sample";
        String searchValue = "Sign-in notification from Yahoo";
        String result =  readCsv2.ReadCsvFile(file,searchValue);
        System.out.println(result);
    }
}
