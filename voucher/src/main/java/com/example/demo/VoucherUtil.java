package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class VoucherUtil {

	public static Date convertToDate(String receivedDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(receivedDate);
        return date;
    }
	
	public static boolean isDateValid(String dateVal) {
		return !StringUtils.isEmpty(dateVal);
	}
}
