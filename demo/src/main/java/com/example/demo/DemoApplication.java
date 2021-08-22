
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/parcelDetails")
	public String initPage() {
		return "<html>" + "<head>" + "<script type=\"text/javascript\">"
				+ "function onSubmit() {document.getElementById(\"payload\").value = document.getElementById(\"message\").value; document.getElementById(\"myForm\").submit();}"
				+ "</script>" + "</head>" + "<body>" + "<h2>JSON Request Payload</h2>" + "<textarea id=\"message\" rows=\"30\" cols=\"50\"></textarea>"
				+ "<form id=\"myForm\" action=\"/calculateDelivery\" method=\"post\" enctype='text/plain'>"
				+ "<input id=\"payload\" type=\"hidden\" name=\"payload\" value=\"\"></textarea>" + "<br>"
				+ "<input type=\"button\" onclick=\"onSubmit()\" value=\"Submit form\">" + "</form>" + "</body>" + "</html>";
	}

}
