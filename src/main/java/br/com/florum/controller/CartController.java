package br.com.florum.controller;

import br.com.florum.dto.cart.*;
import br.com.florum.dto.user.UserDTO;
import br.com.florum.mapper.CartItemMapper;
import br.com.florum.mapper.CartMapper;
import br.com.florum.model.CartItem;
import br.com.florum.model.User;
import br.com.florum.service.ICartItemService;
import br.com.florum.service.ICartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController {
    private final ICartService cartService;
    private final ICartItemService cartItemService;
    private final CartMapper cartMapper;
    private final CartItemMapper cartItemMapper;


    public CartController(ICartService cartService, ICartItemService cartItemService, CartMapper cartMapper, CartItemMapper cartItemMapper) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.cartMapper = cartMapper;
        this.cartItemMapper = cartItemMapper;
    }

//    @GetMapping("{userId}")
//    public ResponseEntity<CartDTO> findByUserId(@PathVariable Long userId){
//        Cart cart = this.cartService.findByUser(userId);
//
//        List<CartItemDTO> itensDto = cart.getCartItems().stream().map(cartItemMapper::toDto).toList();
//
//        CartDTO dto = cartMapper.toDTO(cart);
//        dto.setCartItems(itensDto);
//
//        return ResponseEntity.status(HttpStatus.OK).body(dto);
//    }


    @DeleteMapping("/cartItem/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartItem(@PathVariable Long id){
        this.cartItemService.deleteById(id);
    }

    @GetMapping("/cartItem/{id}")
    public ResponseEntity<CartItemDTO> findByCartItemId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.cartItemMapper.toDto(this.cartItemService.findById(id)));
    }

//    @PostMapping
//    public ResponseEntity<CartItemDTO> save(@RequestBody @Valid CartItemDTO cartItem){
//        CartItem cartItemSaved = cartItemService.save(cartItemMapper.toEntity(cartItem));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemMapper.toDto(cartItemSaved));
//    }

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

}


