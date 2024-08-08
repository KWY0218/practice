package org.kwy.coupon.coupon.application.port.`in`

import org.kwy.coupon.coupon.domain.Coupon
import org.kwy.coupon.coupon.domain.CouponType
import org.kwy.coupon.coupon.domain.DiscountType
import java.time.LocalDate

data class CreateCouponCommend(
    val couponName: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val maxIssuePerUser: Int,
    val totalIssue: Int,
    val discountType: DiscountType,
    val discountValue: Int,
    val maxDiscountAmount: Int? = null,
    val couponType: CouponType,
    val targets: List<Long>? = null
) {
    fun toCoupon(): Coupon = Coupon(
        name = this.couponName,
        startDate = this.startDate,
        endDate = this.endDate,
        maxIssuePerUserCnt = this.maxIssuePerUser,
        totalIssue = this.totalIssue,
        discountType = this.discountType,
        discountValue = this.discountValue,
        maxDiscountAmount = this.maxDiscountAmount,
        type = this.couponType,
        targets = this.targets
    )
}
