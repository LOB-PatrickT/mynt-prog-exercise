package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Voucher {
	private String code;
	private double discount;
	private String expiry;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	
	public static Voucher getVoucherBy(String code) {
		Map<String,Voucher> vouchers = new HashMap<>();	
		
		Voucher v1 = new Voucher();
		v1.setCode("123ABC");
		v1.setDiscount(100);
		v1.setExpiry("23-08-2021");
		
		Voucher v2 = new Voucher();
		v2.setCode("789XYZ");
		v2.setDiscount(500);
		v2.setExpiry("30-05-2023");
		
		vouchers.put(v1.getCode(), v1);
		vouchers.put(v2.getCode(), v2);
		
		Voucher invalidVoucher = new Voucher();
		invalidVoucher.setCode("");
		invalidVoucher.setDiscount(0);
		invalidVoucher.setExpiry("");
		
		return vouchers.get(code) == null ? invalidVoucher : vouchers.get(code);
	}
	
}
