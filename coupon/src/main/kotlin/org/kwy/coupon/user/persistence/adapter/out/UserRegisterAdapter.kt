package org.kwy.coupon.user.persistence.adapter.out

import org.kwy.coupon.user.application.port.out.UserRegisterPort
import org.kwy.coupon.user.domain.User
import org.kwy.coupon.user.persistence.entity.UserEntity
import org.kwy.coupon.user.persistence.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRegisterAdapter(
    private val userRepository: UserRepository
): UserRegisterPort {
    override fun register(name: String, password: String): User {
        val userEntity = UserEntity(name = name, password = password)
        return userRepository.save(userEntity).toUser()
    }
}