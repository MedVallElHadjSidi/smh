package com.example.demo.excel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.entity.Taches;
public class ExcelFileExporter {
	public static ByteArrayInputStream contactListToExcelFile(List<Taches> taches) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Customers");
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        CellStyle CellStyle = workbook.createCellStyle();
	        CellStyle CellStyle2 = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Date");
	        cell.setCellStyle(headerCellStyle);
	        CreationHelper createHelper = workbook.getCreationHelper();
	        CellStyle2.setDataFormat(
	          createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
	        cell = row.createCell(1);
	        cell.setCellValue("DB");
	        cell.setCellStyle(headerCellStyle);
	        XSSFDataFormat xssfDataFormat = (XSSFDataFormat) workbook.createDataFormat();
	       
	        
	        CellStyle.setDataFormat(xssfDataFormat.getFormat("hh:mm"));
	      
	
	        cell = row.createCell(2);
	        cell.setCellValue("DF");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Matricule");
	        cell.setCellStyle(headerCellStyle);
	        
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < taches.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(taches.get(i).getDateday());
	        	dataRow.getCell(0).setCellStyle(CellStyle2);
	        	dataRow.createCell(1).setCellValue(taches.get(i).getDatedebut());
	        	dataRow.getCell(1).setCellStyle(CellStyle);
	        	
	        	
	        	
	        	dataRow.createCell(2).setCellValue(taches.get(i).getDatefint());
	        	dataRow.getCell(2).setCellStyle(CellStyle);
	        	dataRow.createCell(3).setCellValue(taches.get(i).getEmployer().getId());
	        }
	
	        // Making size of column auto resize to fit with data
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
