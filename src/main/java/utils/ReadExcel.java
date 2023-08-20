package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static String[][] getData(String path, int tab) {
        File excelFile = new File(path);
        FileInputStream fis = null;
        XSSFWorkbook excelWBook = null;
        try {
            fis = new FileInputStream(excelFile);
            excelWBook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert excelWBook != null;
        XSSFSheet sheet = excelWBook.getSheetAt(tab);
        int totalRow = sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(3).getLastCellNum();


        String[][] data = new String[totalRow - 1][totalColumns];
        for (int i = 0; i < totalRow - 1; i++) {
            for (int j = 0; j < totalColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 2).getCell(j));
            }
        }

        try {
            excelWBook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;

    }
}