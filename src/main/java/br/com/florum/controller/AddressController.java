package br.com.florum.controller;

import br.com.florum.dto.address.AddressCepDTO;
import br.com.florum.dto.address.AddressDTO;
import br.com.florum.mapper.AddressMapper;
import br.com.florum.model.Address;
import br.com.florum.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/user/{userId}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<AddressDTO>> findByUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByUser(userId).stream().map(addressMapper::toDto).toList());
    }

    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public  ResponseEntity<Address> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @GetMapping("cep/{cep}")
    @Transactional(readOnly = true)
    public ResponseEntity<AddressCepDTO> findByCep(@PathVariable String cep){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByCep(cep));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @Valid AddressDTO address){
        Address addressSaved = addressService.save(addressMapper.toEntity(address));

        return ResponseEntity.status(HttpStatus.OK).body(addressMapper.toDto(addressSaved));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        addressService.delete(id);
    }
}






























