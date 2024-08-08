package org.kwy.coupon.coupon.persistence.repository

import org.kwy.coupon.coupon.persistence.entity.CouponUserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CouponUserRepository : JpaRepository<CouponUserEntity, Long> {
    fun countByCouponId(couponId: Long): Int

    fun countByCouponIdAndUserId(couponId: Long, userId: Long): Int
}