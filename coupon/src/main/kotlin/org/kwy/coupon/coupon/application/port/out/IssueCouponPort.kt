package org.kwy.coupon.coupon.application.port.out

import org.kwy.coupon.coupon.domain.CouponUser

interface IssueCouponPort {
    fun issue(couponId: Long, userId: Long): CouponUser
}