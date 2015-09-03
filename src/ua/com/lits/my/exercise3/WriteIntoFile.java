package ua.com.lits.my.exercise3;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ua.com.lits.my.utils.Logger;

public class WriteIntoFile {

	public void writeAFile(Map<Integer, String> xlsxFileMap) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Questions");
		Set<Integer> keyset = xlsxFileMap.keySet();
		int rownum = 0;
		for (Integer key : keyset) {
			if (isPowerOf2(key)){
			Row row = sheet.createRow(rownum++);
			String value = xlsxFileMap.get(key);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue((String) value);
			} else {
				Logger.print("Value " + key + " is not power of 2!");
			}
		}
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("TestFile.xlsx"));
			workbook.write(out);
			out.close();
			Logger.print("TestFile.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isPowerOf2(int x) {
		return (x > 0 && (x & (x - 1)) == 0);
	}
}
