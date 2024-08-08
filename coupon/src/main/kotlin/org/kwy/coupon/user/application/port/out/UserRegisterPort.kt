package org.kwy.coupon.user.application.port.out

import org.kwy.coupon.user.domain.User

interface UserRegisterPort {
    fun register(name: String, password: String): User
}