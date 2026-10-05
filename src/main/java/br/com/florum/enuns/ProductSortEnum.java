package br.com.florum.enuns;

import org.springframework.data.domain.Sort;

public enum ProductSortEnum {
    RECENTS(Sort.by("createdOn").descending()),
    PRICE_ASC(Sort.by("price").ascending()),
    PRICE_DESC(Sort.by("price").descending());

    private final Sort sort;

    ProductSortEnum(Sort sort) {
        this.sort = sort.and(Sort.by("id").descending());
    }

    public Sort getSort() {
        return sort;
    }
}
