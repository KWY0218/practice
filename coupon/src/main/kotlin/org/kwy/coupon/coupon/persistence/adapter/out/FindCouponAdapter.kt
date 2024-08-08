package org.kwy.coupon.coupon.persistence.adapter.out

import org.kwy.coupon.common.exception.NotFoundException
import org.kwy.coupon.coupon.application.port.out.FindCouponPort
import org.kwy.coupon.coupon.domain.Coupon
import org.kwy.coupon.coupon.persistence.repository.CouponRepository
import org.kwy.coupon.coupon.persistence.repository.CouponUserRepository
import org.kwy.coupon.coupon.persistence.repository.DiscountTargetRepository
import org.springframework.stereotype.Component

@Component
class FindCouponAdapter(
    private val couponRepository: CouponRepository,
    private val discountTargetRepository: DiscountTargetRepository,
    private val couponUserRepository: CouponUserRepository
) : FindCouponPort {
    override fun getCouponById(couponId: Long): Coupon {
        val couponEntity = couponRepository.findById(couponId).orElseThrow {
            throw NotFoundException("존재하지 않는 쿠폰")
        }
        val targets = discountTargetRepository.findAllByCouponId(couponId).map { discountTarget ->
            discountTarget.targetId
        }
        return couponEntity.toCoupon(targets)
    }

    override fun getTotalIssuedCouponCount(couponId: Long): Int =
        couponUserRepository.countByCouponId(couponId)

    override fun getIssuedCouponCountPerUser(couponId: Long, userId: Long): Int =
        couponUserRepository.countByCouponIdAndUserId(couponId, userId)
}