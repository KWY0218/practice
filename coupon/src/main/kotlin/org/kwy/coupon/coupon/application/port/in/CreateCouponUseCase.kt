package org.kwy.coupon.coupon.application.port.`in`

import org.kwy.coupon.coupon.domain.Coupon

interface CreateCouponUseCase {
    fun create(createCouponCommend: CreateCouponCommend): Coupon
}