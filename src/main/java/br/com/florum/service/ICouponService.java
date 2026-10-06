package br.com.florum.service;

import br.com.florum.model.Coupon;

public interface ICouponService {
    Coupon findByCodeCoupon(String code);
}
