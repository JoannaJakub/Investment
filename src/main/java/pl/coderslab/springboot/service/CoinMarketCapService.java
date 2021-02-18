package pl.coderslab.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public abstract class CoinMarketCapService {

    @Value("${pl.coderslab.cmc.api.v1.base-url:https://sandbox-api.coinmarketcap.com}")
    private String CMC_BASE_URL;

    @Value("${pl.coderslab.cmc.api.v1.header:X-CMC_PRO_API_KEY}")
    private String CMC_HEADER;

    @Value("${pl.coderslab.cmc.api.v1.api-key}")
    private String CMC_API_KEY;

    private HttpEntity<String> httpEntity;

    public ResponseEntity<Object> getResponseFromEndpoint(String endpoint, HashMap<String, String> paramMap) {


        if (this.httpEntity == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(CMC_HEADER, CMC_API_KEY);

            this.httpEntity = new HttpEntity<String>("parameters", headers);
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        String formattedUrl = CMC_BASE_URL + endpoint;

        if (paramMap != null)
            formattedUrl += this.getFormattedParams(paramMap);

        try {
            response = restTemplate.exchange(
                    formattedUrl, HttpMethod.GET, httpEntity, String.class);

        } catch (HttpStatusCodeException exception) {
            return new ResponseEntity<Object>(exception.getResponseBodyAsString(), exception.getStatusCode());
        }

        return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getResponseFromEndpoint(String endpoint) {
        return getResponseFromEndpoint(endpoint, null);
    }

    public String getFormattedParams(HashMap<String, String> paramMap) {
        StringBuilder paramStringBuilder = new StringBuilder("");
        if (paramMap != null) {
            boolean isFirstParam = true;

            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (key != null && !key.isEmpty() && value != null && !value.isEmpty()) {
                    paramStringBuilder.append((isFirstParam ? "?" : "&") + key + "=" + value);
                    isFirstParam = false;
                }
            }
        }
        return paramStringBuilder.toString();
    }
}
