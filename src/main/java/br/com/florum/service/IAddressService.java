package br.com.florum.service;

import br.com.florum.dto.address.AddressCepDTO;
import br.com.florum.model.Address;
import br.com.florum.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface IAddressService {
    List<Address> findByUser(Long userId);
    AddressCepDTO findByCep(String cep);
    Address save(Address address, User user);
    void deactivates(Long id);
    BigDecimal calculateShipping(Address address);
}
