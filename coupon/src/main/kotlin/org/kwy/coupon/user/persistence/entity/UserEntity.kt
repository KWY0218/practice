package org.kwy.coupon.user.persistence.entity

import jakarta.persistence.*
import org.kwy.coupon.user.domain.User

@Table(name = "users")
@Entity
class UserEntity(
    id: Long? = null,
    name: String,
    password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var name = name
        protected set

    @Column(nullable = false)
    var password = password
        protected set

    fun toUser(): User = User(
        id = this.id,
        name = this.name,
        password = this.password
    )
}