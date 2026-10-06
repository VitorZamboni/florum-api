package br.com.florum.repository;

import br.com.florum.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAddressByUserIdAndActiveIsTrue(Long userId);
    Address findAddressByIdAndUserId(Long id, Long userId);
    Address findAddressById(Long id);
}

