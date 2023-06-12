package Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
public class ExcelSheet {
	    private Workbook workbook;
	    private Sheet sheet;

	    public void setValue(String value, String key) {
	        try {
	            // Load the Excel file
	            FileInputStream file = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Org.JiraApiProject_com\\src\\test\\resources\\TestData\\Book1.xlsx");
	            workbook = WorkbookFactory.create(file);

	            // Get the first sheet
	            sheet = workbook.getSheet("Sheet1");

	            // Set the header
	            Row header = sheet.getRow(0);
	            if (header == null) {
	                header = sheet.createRow(0);
	            }

	            Cell headerCell = header.createCell(0);
	            String headerVal = key;
	            headerCell.setCellValue(headerVal);

	            // Adjust column width (optional)
	            sheet.autoSizeColumn(0);

	            // Add a new row at the end
	            int lastRowIndex = sheet.getLastRowNum();
	            Row newRow = sheet.createRow(lastRowIndex + 1);

	            // Set values for the new row
	            Cell cell1 = newRow.createCell(0);
	            cell1.setCellValue(value);

	            // Save the changes (optional)
	            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\HP\\eclipse-workspace\\Org.JiraApiProject_com\\src\\test\\resources\\TestData\\Book1.xlsx");
	            workbook.write(fileOut);
	            fileOut.close();

	            // Close the workbook
	            workbook.close();
	            file.close();

	            //System.out.println("Value set successfully!");
	        } catch (IOException | EncryptedDocumentException e) {
	            e.printStackTrace();
	        }
	    }

	    public String getLastValue() {
	        try {
	            // Load the Excel file
	            FileInputStream file = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Org.JiraApiProject_com\\src\\test\\resources\\TestData\\Book1.xlsx");
	            workbook = WorkbookFactory.create(file);

	            // Get the first sheet
	            sheet = workbook.getSheet("Sheet1");

	            // Get the value of the last row
	            int lastRowIndex = sheet.getLastRowNum();
	            if (lastRowIndex > 0) {
	                Row lastRow = sheet.getRow(lastRowIndex);
	                Cell lastCell = lastRow.getCell(0); // Assuming the value is in the first column

	                String lastValue = lastCell.getStringCellValue();
	                //System.out.println("Last value: " + lastValue);

	                // Close the workbook
	                workbook.close();
	                file.close();
	                return lastValue;
	            }
	        } catch (IOException | EncryptedDocumentException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	}
