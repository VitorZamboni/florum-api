package br.com.florum.repository.spec;

import br.com.florum.dto.ProductFilterDTO;
import br.com.florum.model.Product;
import br.com.florum.model.ProductCategory;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class ProductSpec {
    public static Specification<Product> filterBy(ProductFilterDTO filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Long.class.equals(query.getResultType())) {
                query.distinct(true);
            }

            if (filter.getText() != null && !filter.getText().isBlank()) {
                String term = "%" + filter.getText().toLowerCase() + "%";
                Predicate nameLike = builder.like(builder.lower(root.get("name")), term);
                Predicate descLike = builder.like(builder.lower(root.get("description")), term);
                predicates.add(builder.or(nameLike, descLike));
            }

            if (Boolean.TRUE.equals(filter.getPromotion())) {
                predicates.add(builder.gt(root.get("discount"), 0.0));
            }

            if (filter.getCategoryIds() != null && !filter.getCategoryIds().isEmpty()) {
                Join<Product, ProductCategory> productCategories = root.join("productCategories", JoinType.INNER);
                predicates.add(productCategories.get("category").get("id").in(filter.getCategoryIds()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
