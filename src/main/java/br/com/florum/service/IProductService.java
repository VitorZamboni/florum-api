package br.com.florum.service;

import br.com.florum.dto.ProductFilterDTO;
import br.com.florum.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, ProductFilterDTO filter);
    Product findById(Long id);
}
