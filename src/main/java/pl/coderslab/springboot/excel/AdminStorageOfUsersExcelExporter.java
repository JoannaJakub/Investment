package pl.coderslab.springboot.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.Storage;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminStorageOfUsersExcelExporter {
    private List<Ownedcryptocurrencies> findUserByStorageId;
    private List<Ownedstocks> usersStorageStocks;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;


    public AdminStorageOfUsersExcelExporter(List<Ownedcryptocurrencies> listStorage,List<Ownedstocks> usersStorageStocks) {
        this.findUserByStorageId = listStorage;
        this.usersStorageStocks = usersStorageStocks;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Storage");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Name", style);
        createCell(row, 2, "Link", style);
        createCell(row, 3, "USER ID", style);
        createCell(row, 4, "Username", style);

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

        for (Ownedcryptocurrencies ownedcryptocurrencies : findUserByStorageId) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, ownedcryptocurrencies.getStorage().getId(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getStorage().getName(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getStorage().getLink(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getUser().getId(), style);
            createCell(row, columnCount++, ownedcryptocurrencies.getUser().getUsername(), style);
        }
        for (Ownedstocks ownedstocks: usersStorageStocks) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, ownedstocks.getStorage().getId(), style);
            createCell(row, columnCount++, ownedstocks.getStorage().getName(), style);
            createCell(row, columnCount++, ownedstocks.getStorage().getLink(), style);
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
