package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdater {
    private String fileLocation;

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public ExcelUpdater(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void updateExcelFile(String username, String recipientName, String recipientEmail, String recipientPhoneNumber) throws IOException {
        // Open the Excel file
        FileInputStream inputStream = new FileInputStream(new File(fileLocation));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Find the next empty row
        int nextRowNum = sheet.getLastRowNum() + 1;
        Row row = sheet.createRow(nextRowNum);

        // Update the cell values
//        Cell cell0 = row.createCell(0);
//        cell0.setCellValue(username);
//        Cell cell1 = row.createCell(1);
//        cell1.setCellValue(recipientName);
//        Cell cell2 = row.createCell(2);
//        cell2.setCellValue(recipientEmail);
//        Cell cell3 = row.createCell(3);
//        cell3.setCellValue(recipientPhoneNumber);

        Cell cell0 = row.createCell(0);
        cell0.setCellValue(recipientName);
        Cell cell1 = row.createCell(1);
        cell1.setCellValue(username);
        Cell cell2 = row.createCell(2);
        cell2.setCellValue(recipientPhoneNumber);
        Cell cell3 = row.createCell(3);
        cell3.setCellValue(recipientEmail);

        //Company Name, your own name, recipient phone, recipient email

        // Write the changes to the Excel file
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
}