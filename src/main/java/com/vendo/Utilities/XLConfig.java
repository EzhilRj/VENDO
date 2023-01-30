package com.vendo.Utilities;

import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class XLConfig {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    public static XSSFCellStyle style;

    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        //Create an object of File class to open xls file
        File file =  new File(excelFilePath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        workbook=new XSSFWorkbook(inputStream);

        //creating a Sheet object
        sheet=workbook.getSheet(sheetName);

    }

    public String getCellData(int rowNumber,int cellNumber){
        //getting the cell value from rowNumber and cell Number
        cell =sheet.getRow(rowNumber).getCell(cellNumber);

        //returning the cell value as string
        return cell.getStringCellValue();
    }

    public int getRowCountInSheet(){
        int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        return rowcount;
    }

    public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
        //creating a new cell in row and setting value to it
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }

}
