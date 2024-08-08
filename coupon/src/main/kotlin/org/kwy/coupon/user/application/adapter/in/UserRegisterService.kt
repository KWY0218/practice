package org.kwy.coupon.user.application.adapter.`in`

import org.kwy.coupon.user.application.port.`in`.UserRegisterUseCase
import org.kwy.coupon.user.application.port.out.UserRegisterPort
import org.kwy.coupon.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserRegisterService(
    private val userRegisterPort: UserRegisterPort
) : UserRegisterUseCase {
    override fun login(name: String, password: String): User =
        userRegisterPort.register(name, password)
}