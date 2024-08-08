package org.kwy.coupon.user.persistence.repository

import org.kwy.coupon.user.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
}