package com.digital.common_lib.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestTemplateUtil {

	@Autowired
	private RestTemplate restTemplate;

	public String generateUrl(String serviceId, String apinameparam) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append(serviceId);
		sb.append(apinameparam);
		return sb.toString();
	}

	public HttpEntity<Object> entity(Object request) {
		HttpHeaders headers = new HttpHeaders();
		return new HttpEntity<>(request, headers);
	}

	public <T> T getWithQueryParams(String serviceId, String apiName, Map<String, String> queryParams, Class<T> responseType) {
		String url = generateUrl(serviceId, apiName);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);

		queryParams.forEach(uriBuilder::queryParam);

		ResponseEntity<T> response = restTemplate.exchange(uriBuilder.toUriString(),
				org.springframework.http.HttpMethod.GET, null, responseType);

		return response.getBody();
	}
}
