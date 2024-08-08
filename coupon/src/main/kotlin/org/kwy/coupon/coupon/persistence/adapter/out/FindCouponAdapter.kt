package org.kwy.coupon.coupon.persistence.adapter.out

import org.kwy.coupon.coupon.application.port.out.FindCouponPort
import org.kwy.coupon.coupon.domain.Coupon
import org.springframework.stereotype.Component

@Component
class FindCouponAdapter: FindCouponPort {
    override fun getCouponById(couponId: Long): Coupon {
        TODO("Not yet implemented")
    }

    override fun getTotalIssuedCouponCount(couponId: Long): Int {
        TODO("Not yet implemented")
    }

    override fun getIssuedCouponCountPerUser(couponId: Long, userId: Long): Int {
        TODO("Not yet implemented")
    }
}