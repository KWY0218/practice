package org.kwy.coupon.product.persistence.entity

import jakarta.persistence.*

@Table(name = "product")
@Entity
class ProductEntity(
    id: Long? = null,
    brandId: Long,
    categoryId: Long,
    name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var brandId = brandId
        protected set

    @Column(nullable = false)
    var categoryId = categoryId
        protected set

    @Column(nullable = false)
    var name = name
        protected set
}