package br.com.florum.repository;

import br.com.florum.model.Address;
import br.com.florum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);
    Address findAddressByIdAndUserId(Long id, Long userId);

}

