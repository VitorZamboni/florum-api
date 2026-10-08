package br.com.florum.service.impl;

import br.com.florum.dto.address.AddressCepDTO;
import br.com.florum.dto.address.AddressShippingDTO;
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
import java.math.RoundingMode;
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

        dto.setCountry("Brasil");

        return dto;
    }

    @Override
    public Address save(Address address, User user) {
        AddressShippingDTO dto = restTemplate.getForObject("https://cep.awesomeapi.com.br/json/{cep}", AddressShippingDTO.class, address.getCep());

        if(dto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cep not found");
        }

        address.setUser(user);
        address.setActive(true);
        address.setLng(dto.getLng());
        address.setLat(dto.getLat());

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
        double lngStore = -52.676112;
        double latStore = -26.2109254;

        double lngOrder = Double.parseDouble(address.getLng());
        double latOrder = Double.parseDouble(address.getLat());

        double dLat = Math.toRadians((latOrder - latStore));
        double dLng = Math.toRadians((lngOrder - lngStore));

        latOrder = Math.toRadians(latOrder);
        latStore = Math.toRadians(latStore);

        double a = Math.pow(Math.sin(dLat/2), 2) + Math.cos(latStore) * Math.cos(latOrder) * Math.pow(Math.sin(dLng /2), 2) ;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = 6371 * c;

        double price;

        if(distance <= 15){
            price = 20;
        }else if(distance <= 35){
            price = 40;
        }else if(distance <= 80){
            price = 56;
        }else {
            price = 100 + (distance * 0.05);
        }

        return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
    }
}
