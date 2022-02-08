package com.ReadCsvFile;/* Mahadev
   08-02-2022
   Reading Csv File and Searching String is present or not
  */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvUsingBufferReader
{
    public String ReadCsvFileUsingBuffer(String fileName, String searchValue) throws IOException {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePaths = userDirectory + pathSeparator + "files" + pathSeparator + fileName;
        String filePath = filePaths + "." + "csv";
        String line = searchValue;
        String found = "Yes";
        String notFound = "No";
        boolean flag = false;
        {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(filePath));
                while (br.ready()) {
                    if (br.readLine().contains(line)) {
                        flag = true;
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            } catch (IOException e) {
                System.out.println("Null pointer");
            } finally {
                br.close();
            }

        }
        if (flag == true) {
            return found;
        } else {
            return notFound;
        }
    }

    public static void main(String[] args) throws IOException {
        ReadCsvUsingBufferReader readCsvFile = new ReadCsvUsingBufferReader();
        String file = "sample";
        String searchValue = "jjj";
        String result = readCsvFile.ReadCsvFileUsingBuffer(file, searchValue);
        System.out.println(result);
    }

}
