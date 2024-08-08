package org.kwy.coupon.coupon.persistence.adapter.out

import org.kwy.coupon.coupon.application.port.out.IssueCouponPort
import org.kwy.coupon.coupon.domain.CouponUser
import org.kwy.coupon.coupon.persistence.entity.CouponUserEntity
import org.kwy.coupon.coupon.persistence.repository.CouponUserRepository
import org.springframework.stereotype.Component

@Component
class IssueCouponAdapter(
    private val couponUserRepository: CouponUserRepository
) : IssueCouponPort {
    override fun issue(couponId: Long, userId: Long): CouponUser {
        val couponUserEntity = CouponUserEntity(
            couponId = couponId,
            userId = userId
        )
        return couponUserRepository.save(couponUserEntity).toCouponUser()
    }
}