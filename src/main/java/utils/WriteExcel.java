package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static void excelWriter(String data, int tab, int column, int rowNo) {
        String filePath = "src\\main\\resources\\data.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(tab);

            Row row = sheet.getRow(rowNo);
            Cell cell = row.createCell(column);
            cell.setCellValue(data);
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}