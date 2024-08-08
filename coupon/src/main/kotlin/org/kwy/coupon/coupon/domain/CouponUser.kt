package org.kwy.coupon.coupon.domain

data class CouponUser(
    val id: Long? = null,
    val userId: Long,
    val couponId: Long
)
