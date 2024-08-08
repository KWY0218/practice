package org.kwy.coupon.coupon.domain

import java.time.LocalDate

data class Coupon(
    val id: Long? = null,
    val name: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val maxIssuePerUserCnt: Int,
    val totalIssue: Int,
    val discountType: DiscountType,
    val discountValue: Int,
    val maxDiscountAmount: Int? = null,
    val type: CouponType,
    val targets: List<Long>?
)
