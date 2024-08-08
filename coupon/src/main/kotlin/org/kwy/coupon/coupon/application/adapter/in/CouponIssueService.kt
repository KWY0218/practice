package org.kwy.coupon.coupon.application.adapter.`in`

import org.kwy.coupon.coupon.application.port.`in`.IssueCouponUseCase
import org.kwy.coupon.coupon.domain.CouponUser
import org.springframework.stereotype.Service

@Service
class CouponIssueService: IssueCouponUseCase {
    override fun issue(couponId: Long, userId: Long): CouponUser {
        TODO("Not yet implemented")
    }
}