package ua.com.lits.my.exercise3;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	public Map<Integer, String> readXLSFile(FileInputStream file, String sheetName) {
		Map<Integer, String> xlsxFile = new HashMap<>();
		try {
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				if(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					xlsxFile.put(row.getRowNum(), cell.getStringCellValue());
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Integer id: xlsxFile.keySet()){

            String key =id.toString();
            String value = xlsxFile.get(id).toString();  
            System.out.println(key + " " + value);  


} 
		return xlsxFile;
	}
}