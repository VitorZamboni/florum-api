package br.com.florum.service.impl;

import br.com.florum.dto.product.ProductFilterDTO;
import br.com.florum.model.Product;
import br.com.florum.repository.ProductRepository;
import br.com.florum.repository.spec.ProductSpec;
import br.com.florum.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable, ProductFilterDTO filter) {
        Specification<Product> spec = ProductSpec.filterBy(filter);
        return productRepository.findAll(spec, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }
}
