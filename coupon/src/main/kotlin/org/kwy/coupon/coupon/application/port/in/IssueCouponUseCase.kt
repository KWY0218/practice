package org.kwy.coupon.coupon.application.port.`in`

import org.kwy.coupon.coupon.domain.CouponUser

interface IssueCouponUseCase {
    fun issue(couponId: Long, userId: Long): CouponUser
}