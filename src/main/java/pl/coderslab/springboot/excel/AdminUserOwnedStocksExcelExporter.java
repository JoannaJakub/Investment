package pl.coderslab.springboot.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.User;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AdminUserOwnedStocksExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Ownedstocks> findAll;

    public AdminUserOwnedStocksExcelExporter(List<Ownedstocks> ownedstocks) {
        this.findAll = ownedstocks;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("OwnedStocks");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "STOCK ID", style);
        createCell(row, 1, "Name", style);
        createCell(row, 2, "Current Price", style);
        createCell(row, 3, "Change", style);
        createCell(row, 4, "Currency", style);
        createCell(row, 5, "Bid", style);
        createCell(row, 6, "Price", style);
        createCell(row, 7, "How many", style);
        createCell(row, 8, "Date", style);
        createCell(row, 9, "Notes", style);
        createCell(row, 10, "USER ID", style);
        createCell(row, 11, "E-mail", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue(String.valueOf((LocalDate) value));
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof BigDecimal) {
            cell.setCellValue(String.valueOf((BigDecimal) value));
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Ownedstocks ownedstocks : findAll) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, ownedstocks.getStocks().getId(), style);
            createCell(row, columnCount++, ownedstocks.getStocks().getName(), style);
            createCell(row, columnCount++, ownedstocks.getStocks().getPrice(), style);
            createCell(row, columnCount++, ownedstocks.getStocks().getChange(), style);
            createCell(row, columnCount++, ownedstocks.getStocks().getCurrency(), style);
            createCell(row, columnCount++, ownedstocks.getStocks().getBid(), style);
            createCell(row, columnCount++, ownedstocks.getHowMuch(), style);
            createCell(row, columnCount++, ownedstocks.getNumOfCoins(), style);
            createCell(row, columnCount++, ownedstocks.getWhenBought(), style);
            createCell(row, columnCount++, ownedstocks.getNotes(), style);
            createCell(row, columnCount++, ownedstocks.getUser().getId(), style);
            createCell(row, columnCount++, ownedstocks.getUser().getUsername(), style);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
