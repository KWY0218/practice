package org.kwy.coupon.product.persistence.entity

import jakarta.persistence.*

@Table(name = "category")
@Entity
class CategoryEntity(
    id: Long? = null,
    name: String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var name = name
        protected set
}