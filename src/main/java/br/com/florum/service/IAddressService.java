package br.com.florum.service;

import br.com.florum.dto.address.AddressCepDTO;
import br.com.florum.model.Address;

import java.math.BigDecimal;
import java.util.List;

public interface IAddressService {
    Address findById(Long id);
    List<Address> findByUser(Long userId);
    AddressCepDTO findByCep(String cep);
    Address save(Address address);
    void delete(Long id);
    BigDecimal calculateShipping(Address address);
}
