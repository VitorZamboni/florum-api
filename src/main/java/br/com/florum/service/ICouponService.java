package br.com.florum.service;

import br.com.florum.model.Coupon;

import java.math.BigDecimal;

public interface ICouponService {
    Coupon findByCodeCoupon(String code);
    BigDecimal findByCodeDiscount(String code);
    Coupon findValidByCode(String code);
}
