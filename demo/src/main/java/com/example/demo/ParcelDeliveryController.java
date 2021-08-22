package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController
public class ParcelDeliveryController {
	
	
	@RequestMapping(value = "/calculateDelivery", method = RequestMethod.POST)
	public String calculateDelivery(@RequestBody String payload, HttpSession httpSession)throws Exception {
		System.out.println("test request here");
		if (payload.startsWith("payload=")) {
			payload = payload.replace("payload=", "");
		}

		Parcel data = new Gson().fromJson(payload, Parcel.class);
		double volume = DeliveryCostCalculator.getVolume(data.getHeight(), data.getWidth(), data.getLength());
		double deliveryCost = DeliveryCostCalculator.getCost(data.getWeight(), volume);
		
		if(StringUtils.isEmpty(data.getVoucher())) {
			return String.format("Delivery Cost for Parcel: " + deliveryCost);
		}
		else {
			String url = "http://localhost:9091/" + "checkVoucher/" + data.getVoucher();
	        String discount = new RestTemplate().getForObject(url, String.class);
	        System.out.println("RESPONSE " + discount);
			
			return String.format("Delivery Cost for Parcel: " + (deliveryCost - Double.parseDouble(discount)));
		}
		
	}

}
