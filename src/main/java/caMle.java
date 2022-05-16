import java.io.*;
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
        String[] temp = ps.getArray();


        for(int i=1;i< temp.length;i+=2)
        {
            Row row = sheet.createRow(i/2);

            Cell first = row.createCell(0);
            first.setCellValue(temp[i]);
            Cell second = row.createCell(1);
            second.setCellValue( temp[i+1]);
        }
        book.write(new FileOutputStream(file));
        System.out.println("Write is successfull");
        book.close();
    }
}

