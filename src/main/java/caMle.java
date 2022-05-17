import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class caMle {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        readFromExcel("src/main/java/samplewrite.xls");
        writeIntoExcel("src/main/java/samplewrite.xls");
    }

    public static void readFromExcel(String file) throws IOException
    {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("data");

        Iterator<Row> rowIterator = myExcelSheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                System.out.print(cell.getStringCellValue() + " ");
            }
            System.out.println();
        }
        System.out.println("Read is successfull");
        myExcelBook.close();
    } //read function closed here

    public static void writeIntoExcel(String file) throws FileNotFoundException, IOException
    {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("data");

        poop ps = new poop();
        String[] shit = ps.getArray();
        ArrayList<String> firstRow = ps.getFirst();
        ArrayList<String> secondRow = ps.getSecond();


        for(int i=0;i< firstRow.size();i++)
        {
            Row row = sheet.createRow(i);
            Cell first = row.createCell(0);
            first.setCellValue(firstRow.get(i));
            Cell second = row.createCell(1);
            second.setCellValue( secondRow.get(i));
        }
        book.write(new FileOutputStream(file));
        System.out.println("Write is successfull");
        book.close();
    }
}

