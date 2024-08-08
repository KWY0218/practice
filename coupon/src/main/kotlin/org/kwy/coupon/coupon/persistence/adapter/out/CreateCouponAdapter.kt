package org.kwy.coupon.coupon.persistence.adapter.out

import org.kwy.coupon.coupon.application.port.out.CreateCouponPort
import org.kwy.coupon.coupon.domain.Coupon
import org.kwy.coupon.coupon.persistence.entity.CouponEntity
import org.kwy.coupon.coupon.persistence.entity.DiscountTargetEntity
import org.kwy.coupon.coupon.persistence.repository.CouponRepository
import org.kwy.coupon.coupon.persistence.repository.DiscountTargetRepository
import org.springframework.stereotype.Component

@Component
class CreateCouponAdapter(
    private val couponRepository: CouponRepository,
    private val discountTargetRepository: DiscountTargetRepository
) : CreateCouponPort {
    override fun save(coupon: Coupon): Coupon {
        val couponEntity = CouponEntity(
            name = coupon.name,
            startDate = coupon.startDate,
            endDate = coupon.endDate,
            maxIssuePerUserCnt = coupon.maxIssuePerUserCnt,
            totalIssue = coupon.totalIssue,
            type = coupon.type,
            discountType = coupon.discountType,
            discountValue = coupon.discountValue,
            maxDiscountAmount = coupon.maxDiscountAmount,
        )

        couponRepository.save(couponEntity)

        coupon.targets?.forEach { targetId ->
            val discountTarget = DiscountTargetEntity(targetId = targetId)
            discountTargetRepository.save(discountTarget)
        }

        return couponEntity.toCoupon(coupon.targets)
    }
}
