package org.kwy.coupon.user.presentation

import org.kwy.coupon.user.application.port.`in`.UserRegisterUseCase
import org.kwy.coupon.user.presentation.dto.LoginReqDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@RestController
class LoginController(
    private val userRegisterUseCase: UserRegisterUseCase
) {

    @OptIn(ExperimentalEncodingApi::class)
    @PostMapping("/register")
    fun register(@RequestBody body: LoginReqDto): ResponseEntity<String> {
        val user = userRegisterUseCase.login(body.name, body.password)
        val token = Base64.UrlSafe.encode(user.id.toString().toByteArray())
        return ResponseEntity.ok(token)
    }
}