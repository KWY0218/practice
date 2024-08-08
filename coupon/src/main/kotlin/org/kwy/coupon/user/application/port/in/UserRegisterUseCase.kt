package org.kwy.coupon.user.application.port.`in`

import org.kwy.coupon.user.domain.User

interface UserRegisterUseCase {
    fun login(name: String, password: String): User
}