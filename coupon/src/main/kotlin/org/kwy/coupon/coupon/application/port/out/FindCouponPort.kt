package org.kwy.coupon.coupon.application.port.out

import org.kwy.coupon.coupon.domain.Coupon

interface FindCouponPort {
    fun getCouponById(couponId: Long): Coupon

    fun getTotalIssuedCouponCount(couponId: Long): Int

    fun getIssuedCouponCountPerUser(couponId: Long, userId: Long): Int
}