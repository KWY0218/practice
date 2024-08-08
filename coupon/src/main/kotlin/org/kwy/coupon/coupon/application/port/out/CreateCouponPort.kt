package org.kwy.coupon.coupon.application.port.out

import org.kwy.coupon.coupon.domain.Coupon

interface CreateCouponPort {
    fun save(coupon: Coupon): Coupon
}
