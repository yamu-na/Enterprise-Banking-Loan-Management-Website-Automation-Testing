package com.qentelli.GroupFinalAssessment.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    // Read excel data
    public static String getCellData(
            String filePath,
            String sheetName,
            int rowNumber,
            int cellNumber) {

        try {

            // Check file existence
            File excelFile =
                    new File(filePath);

            if (!excelFile.exists()) {

                throw new RuntimeException(
                "Excel file not found : "
                + filePath);
            }

            FileInputStream file =
                    new FileInputStream(
                            excelFile);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(file);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            if (sheet == null) {

                workbook.close();

                throw new RuntimeException(
                "Sheet not found : "
                + sheetName);
            }

            Row row =
                    sheet.getRow(rowNumber);

            if (row == null) {

                workbook.close();

                throw new RuntimeException(
                "Row not found : "
                + rowNumber);
            }

            Cell cell =
                    row.getCell(cellNumber);

            if (cell == null) {

                workbook.close();

                throw new RuntimeException(
                "Cell not found : "
                + cellNumber);
            }

            String data =
                    cell.toString().trim();

            workbook.close();

            file.close();

            return data;

        } catch (Exception e) {

            throw new RuntimeException(
            e.getMessage());
        }
    }
}