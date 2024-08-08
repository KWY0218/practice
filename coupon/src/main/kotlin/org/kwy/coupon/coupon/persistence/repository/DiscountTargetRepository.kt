package org.kwy.coupon.coupon.persistence.repository

import org.kwy.coupon.coupon.persistence.entity.DiscountTargetEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DiscountTargetRepository : JpaRepository<DiscountTargetEntity, Long> {
}