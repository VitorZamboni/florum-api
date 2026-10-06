package br.com.florum.service.impl;

import br.com.florum.dto.address.AddressCepDTO;
import br.com.florum.model.Address;
import br.com.florum.model.User;
import br.com.florum.repository.AddressRepository;
import br.com.florum.service.IAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    private final AddressRepository addressRepository;
    private final RestTemplate restTemplate;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.restTemplate = new RestTemplate();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> findByUser(Long userId) {
        return this.addressRepository.findAddressByUserIdAndActiveIsTrue(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressCepDTO findByCep(String cep) {
        AddressCepDTO dto = restTemplate.getForObject("https://cep.awesomeapi.com.br/json/{cep}", AddressCepDTO.class, cep);

        if(dto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP not found");
        }

        return dto;
    }

    @Override
    public Address save(Address address, User user) {
        address.setUser(user);

        if(address.getCountry() == null){
            address.setCountry("Brasil");
        }

        return this.addressRepository.save(address);
    }

    @Override
    public void deactivates(Long id){
       Address addressDeactivated = addressRepository.findAddressById((id));

       if(addressDeactivated == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
       }

       addressDeactivated.setActive(false);
    }

    @Override
    public BigDecimal calculateShipping(Address address) {
        return new BigDecimal("20.00");
    }
}
