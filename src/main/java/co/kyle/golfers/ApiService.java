package co.kyle.golfers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.kyle.golfers.model.Players;

@Component
public class ApiService {

	RestTemplate restTemplate = new RestTemplate();

	private RestTemplate restTemplateWithUserAgent;

	// This is an instance initialization block. It runs when a new instance of the
	// class is created--right before the constructor.
	{
		// This configures the restTemplateWithUserAgent to include a User-Agent header
		// with every HTTP request.
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
			return execution.execute(request, body);
		};
		restTemplateWithUserAgent = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	@Value("${golf.key}")
	private String golfkey;

	@Value("${golf.key2}")
	private String golfkey2;

	public List<Players> getPlayersByYear(Integer year) {

		HttpHeaders headers = new HttpHeaders();

		headers.add("Ocp-Apim-Subscription-Key", golfkey);

		String url = "https://api.fantasydata.net/golf/v2/JSON/PlayerSeasonStats/" + year.toString();

		ResponseEntity<List<Players>> apiResponse = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headers), new ParameterizedTypeReference<List<Players>>() {
				});

		return apiResponse.getBody();

	}

}
