package br.com.florum.repository;

import br.com.florum.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findCouponByCode(String code);
}
