package org.kwy.coupon.coupon.presentation.admin

import org.kwy.coupon.coupon.application.port.`in`.CreateCouponUseCase
import org.kwy.coupon.coupon.presentation.admin.dto.req.CouponRequestDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/coupon")
class CouponAdminController(
    private val createCouponUseCase: CreateCouponUseCase
) {

    @PostMapping
    fun create(
        @RequestBody body: CouponRequestDto
    ): ResponseEntity<Unit> {
        val createCouponCommend = body.toCreateCouponCommend()
        val coupon = createCouponUseCase.create(createCouponCommend)
        return ResponseEntity
            .created(URI.create("${coupon.id}"))
            .build()
    }
}