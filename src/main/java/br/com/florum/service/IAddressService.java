package br.com.florum.service;

import br.com.florum.dto.AddressCepDTO;
import br.com.florum.model.Address;
import br.com.florum.model.Category;

import java.util.List;

public interface IAddressService {
    Address findById(Long id);
    List<Address> findByUser(Long userId);
    AddressCepDTO findByCep(String cep);
    Address save(Address address);
    void delete(Long id);
}
