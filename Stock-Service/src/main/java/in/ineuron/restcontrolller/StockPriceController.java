package in.ineuron.restcontrolller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceController {

	@Autowired
	private IStockPriceService service;
	
	@Autowired
	private Environment environment;

	@GetMapping(value = "/stockPrice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String companyName) {

		String portInfo=environment.getProperty("local.server.port");
		System.out.println(portInfo);
		
		Double price = service.findByCompanyName(companyName);
		System.out.println(companyName + " " + price);

		return new ResponseEntity<Double>(price, HttpStatus.OK);
	}
}
