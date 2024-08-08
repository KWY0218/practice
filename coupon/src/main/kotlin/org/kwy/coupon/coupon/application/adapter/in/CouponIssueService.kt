package org.kwy.coupon.coupon.application.adapter.`in`

import jakarta.transaction.Transactional
import org.kwy.coupon.common.exception.ForbiddenException
import org.kwy.coupon.coupon.application.port.`in`.IssueCouponUseCase
import org.kwy.coupon.coupon.application.port.out.FindCouponPort
import org.kwy.coupon.coupon.application.port.out.IssueCouponPort
import org.kwy.coupon.coupon.domain.CouponUser
import org.springframework.stereotype.Service

@Service
class CouponIssueService(
    private val findCouponPort: FindCouponPort,
    private val issueCouponPort: IssueCouponPort
) : IssueCouponUseCase {

    @Transactional
    override fun issue(couponId: Long, userId: Long): CouponUser {
        val coupon = findCouponPort.getCouponById(couponId)
        val totalIssuedCouponCnt = findCouponPort.getTotalIssuedCouponCount(couponId)
        val issuedCouponCountPerUser = findCouponPort.getIssuedCouponCountPerUser(couponId, userId)

        if(coupon.totalIssue <= totalIssuedCouponCnt) {
            throw ForbiddenException("쿠폰 소진")
        }

        if(coupon.maxIssuePerUserCnt <= issuedCouponCountPerUser) {
            throw ForbiddenException("1인당 발급할 수 있는 쿠폰 개수 초과")
        }

        return issueCouponPort.issue(couponId, userId)
    }
}