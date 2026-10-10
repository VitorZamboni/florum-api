package br.com.florum.service.impl;

import br.com.florum.error.exceptions.BadRequestException;
import br.com.florum.error.exceptions.NotFoundException;
import br.com.florum.model.Coupon;
import br.com.florum.repository.CouponRepository;
import br.com.florum.service.ICouponService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class CouponServiceImpl implements ICouponService {
    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Coupon findByCodeCoupon(String code) {
                Coupon coupon = this.couponRepository.findCouponByCode(code);

            if(coupon == null){
                throw new NotFoundException("Coupon not found");
            }
            if(coupon.getExpiresOn().isBefore(Instant.now())){
                throw new BadRequestException("Coupon has expired");
            }

        return coupon;
    }
}
