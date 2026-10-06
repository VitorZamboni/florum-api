package br.com.florum.controller;

import br.com.florum.dto.address.AddressCepDTO;
import br.com.florum.dto.address.AddressDTO;
import br.com.florum.mapper.AddressMapper;
import br.com.florum.model.Address;
import br.com.florum.model.User;
import br.com.florum.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {
    private final IAddressService addressService;
    private final AddressMapper addressMapper;

    public AddressController(IAddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @GetMapping("/user")
    @Transactional(readOnly = true)
    public ResponseEntity<List<AddressDTO>> findByUser(@AuthenticationPrincipal User user){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByUser(user.getId()).stream().map(addressMapper::toDto).toList());
    }

    @GetMapping("cep/{cep}")
    @Transactional(readOnly = true)
    public ResponseEntity<AddressCepDTO> findByCep(@PathVariable String cep){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByCep(cep));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @Valid AddressDTO address, @AuthenticationPrincipal User user){
        Address addressSaved = addressService.save(addressMapper.toEntity(address), user);

        return ResponseEntity.status(HttpStatus.CREATED).body(addressMapper.toDto(addressSaved));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        addressService.deactivates(id);
    }
}






























