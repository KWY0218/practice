package org.kwy.coupon.coupon.persistence.entity

import jakarta.persistence.*

@Table(name = "discount_target")
@Entity
class DiscountTargetEntity(
    id: Long? = null,
    targetId: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var targetId = targetId
        protected set
}