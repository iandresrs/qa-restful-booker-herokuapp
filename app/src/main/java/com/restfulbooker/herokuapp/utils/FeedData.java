package com.restfulbooker.herokuapp.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.restfulbooker.herokuapp.models.Booking;
import com.restfulbooker.herokuapp.models.BookingDates;
import com.restfulbooker.herokuapp.models.HaspDataBooking;

public class FeedData {

    public void extractData(String filePath, String sheetName) {
        Sheet sheet = ReadExcel.getDataFromExcel(filePath, sheetName);

        switch (sheetName) {
            case "DataBooking":
                extractDataBooking(sheet);
                break;

            default:
                break;
        }
    }

    private void extractDataBooking(Sheet sheet) {
        HaspDataBooking haspDataBooking = new HaspDataBooking();
        Row row = null;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);

            String scenario = getCellValue(row, 0);

            BookingDates bookingDates = new BookingDates(
                    getCellValue(row, 5),
                    getCellValue(row, 6));

            Booking booking = new Booking(
                    scenario,
                    getCellValue(row, 1),
                    getCellValue(row, 2),
                    Integer.parseInt(getCellValue(row, 3)),
                    Boolean.parseBoolean(getCellValue(row, 4)),
                    bookingDates,
                    getCellValue(row, 7));

            haspDataBooking.getDataBookingExcel().put(scenario, booking);

        }
    }

    private String getCellValue(Row row, int index) {
        return ReadExcel.getValueFromExcelCell(row, index);
    }

}
