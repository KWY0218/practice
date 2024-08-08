package org.kwy.coupon.coupon.persistence.repository

import org.kwy.coupon.coupon.persistence.entity.CouponEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CouponRepository : JpaRepository<CouponEntity, Long> {
}