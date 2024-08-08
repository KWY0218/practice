package org.kwy.coupon.product.persistence.entity

import jakarta.persistence.*

@Table(name = "brand")
@Entity
class BrandEntity(
    id: Long? = null,
    name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var name = name
        protected set
}