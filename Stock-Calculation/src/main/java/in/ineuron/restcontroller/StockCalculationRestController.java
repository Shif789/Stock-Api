package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.IStockPriceClient;

@RestController
@RequestMapping("/calc")
public class StockCalculationRestController {

	@Autowired
	private IStockPriceClient client;

	@GetMapping(value = "/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> calculate(@PathVariable String companyName, @PathVariable Integer quantity) {
		System.out.println(companyName + " " + quantity);

		Double totalStockPrice = null;
		ResponseEntity<?> responseEntity = null;
		try {
			responseEntity = client.getPrice(companyName);
			System.out.println(responseEntity);

			int statusCode = responseEntity.getStatusCode().value();
			if (statusCode == 200) {
				Double companyStockPrice = (Double) responseEntity.getBody();
				totalStockPrice = quantity * companyStockPrice;
				String responseBody="Total Cost: "+totalStockPrice;
				responseEntity=new ResponseEntity<String>(responseBody, HttpStatus.OK);
			}

		} catch (Exception e) {
			
			responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
}
