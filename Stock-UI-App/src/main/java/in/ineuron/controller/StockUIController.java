package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.service.StockUIService;

@Controller
@RequestMapping("/ui")
public class StockUIController {

	@Autowired
	private StockUIService service;
	
	@GetMapping(value = "/")
	public String loadPage() {
		System.out.println("StockUIController.loadPage()");
		return "index";
	}
	
	@GetMapping(value = "/getTotalCost")
	public String getTotalCost(@RequestParam String companyName, @RequestParam Integer quantity, Map<String, Object> model) {
		System.out.println("StockUIController.getTotalCost()");
		
		String totalStockPrice = service.getTotalStockPrice(companyName, quantity);
		model.put("msg", totalStockPrice);
		
		return "result";
	}
}
