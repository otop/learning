package ua.com.lits.my.exercise3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import ua.com.lits.my.utils.Logger;

public class ExecuteFileManipulations {

	public static void main(String[] args) {
		try {
			File fis = new File("test.xlsx");
			String sheetName = "TestSheet";
			FileInputStream file;
			file = new FileInputStream(fis);
			ReadFile readFile = new ReadFile();
			Map<Integer, String> readFileMap = readFile.readXLSFile(file, sheetName);
			Logger.print("----------------------------------------------------------");
			WriteIntoFile writeAFile = new WriteIntoFile();
			writeAFile.writeAFile(readFileMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
