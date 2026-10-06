package br.com.florum.service;

import br.com.florum.dto.product.ProductFilterDTO;
import br.com.florum.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Map;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, ProductFilterDTO filter);
    Product findById(Long id);
    Map<Long, Product> findAllByIdsOrThrow(Collection<Long> ids);
}
