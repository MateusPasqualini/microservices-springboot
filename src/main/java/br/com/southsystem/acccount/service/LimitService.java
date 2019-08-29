package br.com.southsystem.acccount.service;

import br.com.southsystem.acccount.model.integration.LimitCreateRequest;
import br.com.southsystem.acccount.service.model.integration.LimitCreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LimitService {

    private RestTemplate restTemplate;

    public LimitService() {
        this.restTemplate = new RestTemplate();
    }

    public void createLimit(String id) {
        LimitCreateRequest request = new LimitCreateRequest(id);
        restTemplate.postForEntity("http://localhost:4723/api/account-limit", request, LimitCreateResponse.class);
    }

}
