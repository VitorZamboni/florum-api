package br.com.florum.controller;

import br.com.florum.dto.product.ProductDTO;
import br.com.florum.dto.product.ProductFilterDTO;
import br.com.florum.dto.product.SimpleProductDTO;
import br.com.florum.enuns.ProductSortEnum;
import br.com.florum.mapper.ProductMapper;
import br.com.florum.model.Product;
import br.com.florum.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private final IProductService productService;
    private final ProductMapper productMapper;

    public ProductController(IProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product Product = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.toDto(Product));
    }

    @GetMapping("page")
    public ResponseEntity<Page<SimpleProductDTO>> findPage(
       @RequestParam int page,
       @RequestParam int size,
       ProductFilterDTO filter
    ) {
        ProductSortEnum sortOption = filter.getSort() != null ? filter.getSort() : ProductSortEnum.RECENTS;
        PageRequest pageRequest = PageRequest.of(page, size, sortOption.getSort());

        return ResponseEntity.status(HttpStatus.OK).body(
                productService.findAll(pageRequest, filter).map(productMapper::toSimpleDto));
    }
}