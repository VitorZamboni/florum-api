package br.com.florum.controller;

import br.com.florum.dto.CartDTO;
import br.com.florum.dto.CartItemDTO;
import br.com.florum.mapper.CartItemMapper;
import br.com.florum.mapper.CartMapper;
import br.com.florum.model.Cart;
import br.com.florum.model.CartItem;
import br.com.florum.service.ICartItemService;
import br.com.florum.service.ICartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("{userId}")
    public ResponseEntity<CartDTO> findByUserId(@PathVariable Long userId){
        Cart cart = this.cartService.findByUser(userId);

        List<CartItemDTO> itensDto = cart.getCartItems().stream().map(cartItemMapper::toDto).toList();

        CartDTO dto = cartMapper.toDTO(cart);
        dto.setCartItems(itensDto);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }


    @DeleteMapping("/cartItem/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartItem(@PathVariable Long id){
        this.cartItemService.deleteById(id);
    }

    @GetMapping("/cartItem/{id}")
    public ResponseEntity<CartItemDTO> findByCartItemId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.cartItemMapper.toDto(this.cartItemService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CartItemDTO> save(@RequestBody @Valid CartItemDTO cartItem){
        CartItem cartItemSaved = cartItemService.save(cartItemMapper.toEntity(cartItem));

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemMapper.toDto(cartItemSaved));
    }

    @GetMapping("count/{cartId}")
    public ResponseEntity<Integer> count(@PathVariable Long cartId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartItemService.countsByCartId(cartId));
    }
}


