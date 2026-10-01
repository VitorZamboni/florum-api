package br.com.florum.service.impl;

import br.com.florum.model.Coupon;
import br.com.florum.repository.CouponRepository;
import br.com.florum.service.ICouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class CouponServiceImpl implements ICouponService {
    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Coupon findByCodeCoupon(String code) {
        return findValidByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public int findByCodeDiscount(String code) {
        return findValidByCode(code).getDiscountAmount();
    }

    @Override
    public Coupon findValidByCode(String code) throws ResponseStatusException{
            Coupon coupon = this.couponRepository.findCouponByCode(code);

            if(coupon == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coupon not found");
            }
            if(coupon.getExpirationDate().before(new Date())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Coupon expired");
            }

        return coupon;
    }
}
