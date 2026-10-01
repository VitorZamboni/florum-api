package br.com.florum.controller;

import br.com.florum.service.ICouponService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coupons")
public class CouponController {
    private final ICouponService couponService;

    public CouponController(ICouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("{code}")
    public double findByCode(@PathVariable String code){
        return couponService.findByCodeDiscount(code);
    }
}
