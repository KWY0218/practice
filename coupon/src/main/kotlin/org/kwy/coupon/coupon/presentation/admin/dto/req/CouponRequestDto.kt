package org.kwy.coupon.coupon.presentation.admin.dto.req

import org.kwy.coupon.coupon.application.port.`in`.CreateCouponCommend
import org.kwy.coupon.coupon.domain.CouponType
import org.kwy.coupon.coupon.domain.DiscountType
import java.time.LocalDate

data class CouponRequestDto(
    val couponName: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val maxIssuePerUserCnt: Int,
    val totalIssue: Int,
    val discountType: DiscountType,
    val discountValue: Int,
    val maxDiscountAmount: Int? = null,
    val couponType: CouponType,
    val targets: List<Long>? = null
) {
    fun toCreateCouponCommend() = CreateCouponCommend(
        couponName = this.couponName,
        startDate = this.startDate,
        endDate = this.endDate,
        maxIssuePerUserCnt = this.maxIssuePerUserCnt,
        totalIssue = this.totalIssue,
        discountType = this.discountType,
        discountValue = this.discountValue,
        maxDiscountAmount = this.maxDiscountAmount,
        couponType = this.couponType,
        targets = this.targets
    )
}
