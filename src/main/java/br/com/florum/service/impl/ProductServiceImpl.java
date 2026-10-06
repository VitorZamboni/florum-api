package br.com.florum.service.impl;

import br.com.florum.dto.product.ProductFilterDTO;
import br.com.florum.model.Product;
import br.com.florum.repository.ProductRepository;
import br.com.florum.repository.spec.ProductSpec;
import br.com.florum.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Override
    public Map<Long, Product> findAllByIdsOrThrow(Collection<Long> ids) {
        Map<Long, Product> productsById = productRepository.findAllById(ids).stream()
            .collect(Collectors.toMap(Product::getId, Function.identity()));

        List<Long> notFound = ids.stream()
            .filter(id -> !productsById.containsKey(id))
            .toList();
        if (!notFound.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Produtos não encontrados com os ids : " + notFound
            );
        }

        return productsById;
    }
}
