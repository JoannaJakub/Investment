package pl.coderslab.springboot.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AdminUsersInvestCryptoExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Ownedcryptocurrencies> ownedcryptocurrencies;


    public AdminUsersInvestCryptoExcelExporter(List<Ownedcryptocurrencies> ownedcrypto) {
        this.ownedcryptocurrencies = ownedcrypto;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("OwnedCryptocurrencies");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Price", style);
        createCell(row, 2, "How many", style);
        createCell(row, 3, "Date", style);
        createCell(row, 4, "Notes", style);
        createCell(row, 5, "CRYPTO ID", style);
        createCell(row, 6, "Name", style);
        createCell(row, 7, "Price", style);
        createCell(row, 8, "USER ID", style);
        createCell(row, 9, "E-mail", style);

    }

    public void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
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

        for (Ownedcryptocurrencies ownedcryptocurrencies : ownedcryptocurrencies) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, ownedcryptocurrencies.getId(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getHowMuch(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getNumOfCoins(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getWhenBought(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getNotes(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getCryptocurrencies().getId(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getCryptocurrencies().getName(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getCryptocurrencies().getPriceMax(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getUser().getId(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getUser().getUsername(), style);

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
