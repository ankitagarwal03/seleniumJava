package ReadDataFromExcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class ReadDataFromExcelDemo {

//    @Test(dataProvider = "testingForData")
    public void readData(String id, String order_id,String attribute_id,String attribute_value_id,String attribute_name,String attribute_value_name,String sku_id) throws IOException, InvalidFormatException {
        System.out.println("test, inside");
        System.out.println(id);

    }

//    @Test
    public void checkTimeSleep() throws InterruptedException {
        System.out.println("111");
        Random random = new Random();

        int max = 10000;
        int min = 1000;

        int st  = random.nextInt((max - min + 1) + min);
        System.out.println(st+" "+ LocalDateTime.now());
        Thread.sleep(st);
        System.out.println("aabb");
        System.out.println("Time "+ LocalDateTime.now());

    }

    @DataProvider(name = "testingForData")
    public Object[][] getData() throws IOException, InvalidFormatException {

        String[][] result = null;

        Workbook workbook = WorkbookFactory.create(new File("./src/main/resources/data.xlsx"));
        Sheet sheet = workbook.getSheet("Sheet1");
        System.out.println("sheet = "+sheet.getSheetName());

        int total = sheet.getPhysicalNumberOfRows();

        System.out.println("Total Row "+total);
        int lastCell = sheet.getRow(0).getLastCellNum();
        DataFormatter dataFormatter = new DataFormatter();
        result = new String[total-1][lastCell];
        System.out.println("total Column "+lastCell);

        for(int i=1; i<total; i++) {
            for (int j = 0; j < lastCell; j++) {
                if(i==0){
//                    headerList.add(dataFormatter.formatCellValue(sheet.getRow(0).getCell(j)));
//                    System.out.println("headerList "+headerList);
                }else {
//                    int totalColumn = sheet.getRow(i).getPhysicalNumberOfCells();
//                    System.out.println("total Column " + totalColumn);
                    System.out.println(i+" j "+j);
                    System.out.println("data = "+dataFormatter.formatCellValue(sheet.getRow(i).getCell(j)));

                    String val = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                    result[i-1][j] = val;
                }

            }

        }
        System.out.println("Result List "+ Arrays.toString(result));

        return result;
    }


}
