package br.com.florum;

import br.com.florum.dto.order.CreateOrderDTO;
import br.com.florum.dto.product.ProductQuantityDTO;
import br.com.florum.enuns.PaymentTypeEnum;
import br.com.florum.repository.OrderRepository;
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

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureTestRestTemplate
@Sql(scripts = { "/seeds/cleanup.sql","/seeds/import_order.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class OrderControllerTest {
    private static final String API_ORDER = "/orders";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TokenService tokenService;

    @BeforeEach
    public void cleanup() {
        orderRepository.deleteAll();
    }

    @Test
    public void postOrder_whenOrderIsValid_receiveCREATED() {
        CreateOrderDTO order = createValidOrder();

        HttpEntity<CreateOrderDTO> request = new HttpEntity<>(order, tokenService.validToken());

        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_ORDER, request, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postOrder_whenOrderHasNoItems_receiveBAD_REQUEST() {
        CreateOrderDTO order = createValidOrder();

        order.setItems(null);

        HttpEntity<CreateOrderDTO> request = new HttpEntity<>(order, tokenService.validToken());

        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_ORDER, request, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postOrder_whenOrderPaymentIsNull_receiveBAD_REQUEST() {
        CreateOrderDTO order = createValidOrder();

        order.setPaymentType(null);

        HttpEntity<CreateOrderDTO> request = new HttpEntity<>(order, tokenService.validToken());

        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_ORDER, request, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postOrder_whenOrderAddressIdIsInvalid_receiveNOT_FOUND() {
        CreateOrderDTO order = createValidOrder();

        order.setAddressId(4L);

        HttpEntity<CreateOrderDTO> request = new HttpEntity<>(order, tokenService.validToken());

        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_ORDER, request, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    private CreateOrderDTO createValidOrder() {
        return CreateOrderDTO.builder()
                .addressId(1L)
                .paymentType(PaymentTypeEnum.PIX)
                .items(List.of(
                        ProductQuantityDTO.builder()
                                .productId(1L)
                                .quantity(1)
                                .build(),
                        ProductQuantityDTO.builder()
                                .productId(2L)
                                .quantity(2)
                                .build()
                ))
                .build();
    }
}