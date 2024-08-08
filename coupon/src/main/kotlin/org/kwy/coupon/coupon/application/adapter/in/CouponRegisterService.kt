package org.kwy.coupon.coupon.application.adapter.`in`

import org.kwy.coupon.coupon.application.port.`in`.CreateCouponCommend
import org.kwy.coupon.coupon.application.port.`in`.CreateCouponUseCase
import org.kwy.coupon.coupon.application.port.out.CreateCouponPort
import org.kwy.coupon.coupon.domain.Coupon
import org.springframework.stereotype.Service

@Service
class CouponRegisterService(
    private val createCouponPort: CreateCouponPort
) : CreateCouponUseCase {

    override fun create(createCouponCommend: CreateCouponCommend): Coupon {
        val coupon = createCouponCommend.toCoupon()
        return createCouponPort.save(coupon)
    }
}