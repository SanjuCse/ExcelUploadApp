package com.sanju.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.sanju.model.TrackingDetails;

@Component
public class ExcelUtil {

	private static final String dateFormat = "dd.MM.yyyy";
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

	public List<TrackingDetails> getTrackingDetailsData(InputStream inputStream)
			throws EncryptedDocumentException, IOException {
//		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		List<TrackingDetails> trackingDetailsList = new ArrayList<>();

		for (Row row : sheet) {
			if (row.getRowNum() > 0) {
				TrackingDetails trackingDetails = new TrackingDetails();

				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);
				Cell cell3 = row.getCell(2);
				Cell cell4 = row.getCell(3);
				Cell cell5 = row.getCell(4);
				Cell cell6 = row.getCell(5);

				if (cell1 != null && cell1.getStringCellValue() != null) {
					trackingDetails.setLanNo(cell1.getStringCellValue());
				}
				if (cell2 != null && cell2.getStringCellValue() != null) {
					trackingDetails.setTrackId(cell2.getStringCellValue());
				}
				if (cell3 != null && cell3.getStringCellValue() != null) {
					trackingDetails.setDate(LocalDate.parse(cell3.getStringCellValue(), formatter));
				}
				if (cell4 != null && cell4.getStringCellValue() != null) {
					trackingDetails.setStatus(cell4.getStringCellValue());
				}
				if (cell5 != null && cell5.getStringCellValue() != null) {
					trackingDetails.setDeliveryStatus(cell5.getStringCellValue());
				}
				if (cell6 != null && cell6.getNumericCellValue() != 0.0) {
					trackingDetails.setMsisdn(cell6.getNumericCellValue());
				}

				trackingDetailsList.add(trackingDetails);
				trackingDetails = null;
			}
		}

		workbook.close();
		inputStream.close();
		return trackingDetailsList;
	}
}
