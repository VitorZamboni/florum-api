package br.com.florum;

import br.com.florum.model.Address;
import br.com.florum.model.User;
import br.com.florum.repository.AddressRepository;
import br.com.florum.repository.UserRepository;
import br.com.florum.service.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureTestRestTemplate
@Sql(scripts = {"/seeds/import_user.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class AddressControllerTest {
    private static final String API_ADDRESS = "/addresses";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @BeforeEach
    public void cleanup() {
        addressRepository.deleteAll();
    }

    @Test
    public void postAddress_whenAddressIsValid_receiveCREATED(){
        Address address = createValidAddress();

        HttpEntity<Address> request = new HttpEntity<>(address, tokenService.validToken());

        ResponseEntity<String> response = this.testRestTemplate.postForEntity(API_ADDRESS, request, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postAddress_whenAddressHasNullCity_receiveBadRequest(){
        Address address = createValidAddress();
        address.setCity(null);

        HttpEntity<Address> request = new HttpEntity<>(address, tokenService.validToken());

        ResponseEntity<Object> response = this.testRestTemplate.postForEntity(API_ADDRESS, request, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postAddress_whenAddressHasInvalidCep_receiveBadRequest(){
        Address address = createValidAddress();
        address.setCep("123456");

        HttpEntity<Address> request = new HttpEntity<>(address, tokenService.validToken());

        ResponseEntity<Object> response = this.testRestTemplate.postForEntity(API_ADDRESS, request, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    private Address createValidAddress(){
        User user = userRepository.getUserById(1L);

        return Address.builder()
                .user(user)
                .cep("88888888")
                .street("Avenida")
                .number("12")
                .district("centro")
                .city("pato branco")
                .state("parana")
                .build();
    }
}