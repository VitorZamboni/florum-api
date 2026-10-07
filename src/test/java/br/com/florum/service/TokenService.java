package br.com.florum.service;

import br.com.florum.dto.user.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenService {
    @Autowired
    private TestRestTemplate testRestTemplate;

    public HttpHeaders validToken(){
        AuthRequestDTO authRequestDTO = new AuthRequestDTO();
        authRequestDTO.setEmail("test@gmail.com");
        authRequestDTO.setPassword("P4ssword");

        ResponseEntity<Map> token = this.testRestTemplate.postForEntity("/login", authRequestDTO, Map.class);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + (String) token.getBody().get("token"));

        return headers;
    }
}
