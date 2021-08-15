package pl.coderslab.springboot.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminUsersStorageStocksExcelExporter {
    private List<Ownedstocks> findAll;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;


    public AdminUsersStorageStocksExcelExporter(List<Ownedstocks> listStorage) {
        this.findAll = listStorage;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Role");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "USER ID", style);
        createCell(row, 1, "Name", style);
        createCell(row, 2, "Surname", style);
        createCell(row, 3, "Username", style);
        createCell(row, 4, "STORAGE ID", style);
        createCell(row, 5, "Name", style);
        createCell(row, 6, "Link", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
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

            createCell(row, columnCount++, ownedstocks.getUser().getId(), style);
            createCell(row, columnCount++, ownedstocks.getUser().getFirstName(), style);
            createCell(row, columnCount++, ownedstocks.getUser().getLastName(), style);
            createCell(row, columnCount++, ownedstocks.getUser().getUsername(), style);
            createCell(row, columnCount++, ownedstocks.getStorage().getId(), style);
            createCell(row, columnCount++, ownedstocks.getStorage().getName(), style);
            createCell(row, columnCount++, ownedstocks.getStorage().getLink(), style);
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
