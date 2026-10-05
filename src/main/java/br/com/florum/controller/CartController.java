package br.com.florum.controller;

import br.com.florum.dto.cart.*;
import br.com.florum.mapper.CartMapper;
import br.com.florum.model.User;
import br.com.florum.service.ICartItemService;
import br.com.florum.service.ICartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("carts")
public class CartController {
    private final ICartService cartService;
    private final ICartItemService cartItemService;
    private final CartMapper cartMapper;

    public CartController(ICartService cartService, ICartItemService cartItemService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.cartMapper = cartMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid CreateCartDTO cart, @AuthenticationPrincipal User user) {
        cartService.save(cart, user);
    }

    @GetMapping("count")
    public ResponseEntity<CartCountDTO> count(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(
            new CartCountDTO(this.cartItemService.countsByUserId(user.getId()))
        );
    }

    @GetMapping
    public ResponseEntity<CartDTO> getCart(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(
                cartMapper.toDTO(this.cartService.findByUser(user.getId()))
        );
    }

    @DeleteMapping("/cartItem/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCartItem(@PathVariable Long id, @AuthenticationPrincipal User user){
        this.cartItemService.deleteById(id, user.getId());
    }

    @PutMapping("/cartItem/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void findByCartItemId(@PathVariable Long id, @RequestBody @Valid UpdateCartItemDTO cartItem, @AuthenticationPrincipal User user){
        this.cartItemService.updateCartItem(id, cartItem, user.getId());
    }

}


