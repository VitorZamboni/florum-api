package br.com.florum.controller;

import br.com.florum.dto.CouponDto;
import br.com.florum.mapper.CouponMapper;
import br.com.florum.service.ICouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coupons")
public class CouponController {
    private final ICouponService couponService;
    private final CouponMapper couponMapper;

    public CouponController(ICouponService couponService, CouponMapper couponMapper) {
        this.couponService = couponService;
        this.couponMapper = couponMapper;
    }

    @GetMapping("/discount/{code}")
    public double findByCodeDiscount(@PathVariable String code){
        return couponService.findByCodeDiscount(code);
    }

    @GetMapping("{code}")
    public ResponseEntity<CouponDto> findByCode(@PathVariable String code) {
        return ResponseEntity.status(HttpStatus.OK).body(couponMapper.toDto(this.couponService.findByCodeCoupon(code)));
    }
}
