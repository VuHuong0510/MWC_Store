/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import models.MauSac;
import models.Size;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author KimChi
 */
public class ExportSize {
     public static final int COLUMN_MA = 0;
    public static final int COLUMN_KICHCO = 1;
    public static final int COLUMN_NGAYTHEM = 2;
    public static final int COLUMN_NGAYSUACUOI = 3;
    public static final int COLUMN_TRANGTHAI = 4;

    public static void writeExcel(List<Size> list, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        Sheet sheet = workbook.createSheet("Size ");
        int rowIndex = 0;
        writeHeader(sheet, rowIndex);
        rowIndex++;

        for (Size x : list) {
            Row row = sheet.createRow(rowIndex);
            writeBook(x, row);
            rowIndex++;
        }

        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }

    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {

        CellStyle cellStyle = createStyleHeader(sheet);

        Row row = sheet.createRow(rowIndex);

        Cell cell = row.createCell(COLUMN_MA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã ");

        cell = row.createCell(COLUMN_KICHCO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Kích cỡ");

        cell = row.createCell(COLUMN_NGAYTHEM);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày thêm");

        cell = row.createCell(COLUMN_NGAYSUACUOI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày sửa cuối");

        cell = row.createCell(COLUMN_TRANGTHAI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trạng thái");

    }

    private static void writeBook(Size d, Row row) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Cell cell = row.createCell(COLUMN_MA);
        cell.setCellValue(d.getMa());

        cell = row.createCell(COLUMN_KICHCO);
        cell.setCellValue(d.getKichCo());

        cell = row.createCell(COLUMN_NGAYTHEM);
        cell.setCellValue(format.format(d.getNgayThem()));

        cell = row.createCell(COLUMN_NGAYSUACUOI);
        cell.setCellValue(format.format(d.getNgaySuaCuoi()));

        cell = row.createCell(COLUMN_TRANGTHAI);
        cell.setCellValue("Ngày sửa cuối");
        if (d.getTrangThai() == 0) {
            cell.setCellValue("Đang kinh doanh");
        } else {
            cell.setCellValue("Ngừng kinh doanh");
        }

    }

    // Create CellStyle for header
    private static CellStyle createStyleHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
//        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 13); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try ( OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
