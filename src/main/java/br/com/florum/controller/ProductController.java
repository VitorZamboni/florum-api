package br.com.florum.controller;

import br.com.florum.dto.ProductDTO;
import br.com.florum.mapper.ProductMapper;
import br.com.florum.model.Product;
import br.com.florum.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {
    private final IProductService productService;
    private final ProductMapper productMapper;

    public ProductController(IProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        var test = productService.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(test
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product Product = productService.findById(id);
        if (Product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(Product);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //http://localhost:8080/categories/page?page=1&size=5
    @GetMapping("page")
    public ResponseEntity<Page<ProductDTO>> findPage(@RequestParam int page,
                                                      @RequestParam int size,
                                                      @RequestParam(required = false) String order,
                                                      @RequestParam(required = false) Boolean asc) {
        PageRequest pageRequest = PageRequest.of(page, size);
        if (order != null && asc != null) {
            pageRequest = PageRequest.of(page, size,
                    asc ? Sort.Direction.ASC : Sort.Direction.DESC, order);
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                productService.findAll(pageRequest).map(productMapper::toDto));
    }
}