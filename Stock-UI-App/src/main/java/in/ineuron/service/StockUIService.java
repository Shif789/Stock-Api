package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service(value = "service")
public class StockUIService {

	//private static final String REST_END_POINT = "http://localhost:8888/api/calc/calculate/{companyName}/{quantity}"; without gateway api
	private static final String REST_END_POINT = "http://localhost:4444/api/calc/calc/calculate/{companyName}/{quantity}";

	public String getTotalStockPrice(String companyName, Integer quantity) {
		WebClient client = WebClient.create();

		String reponse;
		try {
			reponse = client.get().uri(REST_END_POINT, companyName, quantity).accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToMono(String.class).block();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			reponse = "Stock Price not found with company name: " + companyName;
			//reponse=e.getMessage();
		}

		return reponse;
	}
}
