package org.kwy.coupon.coupon.persistence.entity

import jakarta.persistence.*
import org.kwy.coupon.coupon.domain.CouponUser


@Table(name = "coupon_user")
@Entity
class CouponUserEntity(
    id: Long? = null,
    userId: Long,
    couponId: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var userId = userId
        protected set

    @Column(nullable = false)
    var couponId = couponId
        protected set

    fun toCouponUser() = CouponUser(
        id = this.id,
        couponId = this.couponId,
        userId = this.userId
    )
}