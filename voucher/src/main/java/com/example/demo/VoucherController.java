package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {

	 @GetMapping("/checkVoucher/{code}")
	public String calculateDelivery(@PathVariable(value = "code") String code)throws Exception {
		System.out.println("test request here");
		
		Voucher voucher = Voucher.getVoucherBy(code);
		
		if(VoucherUtil.isDateValid(voucher.getExpiry())) {
			if(new Date().before(VoucherUtil.convertToDate(voucher.getExpiry()))) {
				return String.valueOf(voucher.getDiscount());
			} else {
				return "0";
			}
		}
		else {
			return "0";
		}
		
	}
	
}
