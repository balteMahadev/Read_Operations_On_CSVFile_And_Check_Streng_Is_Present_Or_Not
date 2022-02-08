package com.ReadCsvFile;/* Mahadev
   08-02-2022
   Read Csv File Using CSVReader and Searching string is present or not
  */

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderDemo
{
    public String CSVReaderUsingOpenCsv(String file,String SearchValue)
    {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePaths = userDirectory + pathSeparator + "files" + pathSeparator+file;
        String filePath =filePaths+ "." + "csv";
        String line = SearchValue;
        String found = "Yes";
        String notFound = "No";
        boolean flag = false;
        CSVReader csvReader = null;
        String[] nextLine;
        try {
            csvReader = new CSVReader(new FileReader(filePath));
            while ((nextLine = csvReader.readNext())!=null)
            {
                for (String lines : nextLine)
                {
                    if(lines.contains(SearchValue))
                    {
                        flag = true;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag == true)
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
        CSVReaderDemo readCsvFile = new CSVReaderDemo();
        String file = "sample";
        String searchValue = "8:00 am";
        String result = readCsvFile.CSVReaderUsingOpenCsv(file, searchValue);
        System.out.println(result);

    }
}
