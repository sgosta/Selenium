package selenium.datadriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DataDriven {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("/var/home/sgosta/DEV/file_a_caso_per_corso.xlsx"));
        XSSFSheet sheet = getSheetByName(workbook, "boh");

        Iterator<Row> rowsIterator = sheet.iterator();
        List<HashMap<String, String>> mappedFile = new ArrayList<>();
    }

    private static XSSFSheet getSheetByName(XSSFWorkbook workbook, String sheetName) {
        XSSFSheet sheet;

        for (int i = 0; i < workbook.getNumberOfSheets(); i++)
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                sheet = workbook.getSheetAt(i);
                return sheet;
            }

        return null;
    }
}