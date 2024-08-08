package org.kwy.coupon.coupon.persistence.adapter.out

import org.kwy.coupon.coupon.application.port.out.IssueCouponPort
import org.kwy.coupon.coupon.domain.CouponUser
import org.springframework.stereotype.Component

@Component
class IssueCouponAdapter : IssueCouponPort {
    override fun issue(couponId: Long, userId: Long): CouponUser {
        TODO("Not yet implemented")
    }
}