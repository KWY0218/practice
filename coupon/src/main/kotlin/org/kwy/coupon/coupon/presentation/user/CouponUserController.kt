package org.kwy.coupon.coupon.presentation.user

import org.kwy.coupon.coupon.application.port.`in`.IssueCouponUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/coupon")
class CouponUserController(
    private val issueCouponUseCase: IssueCouponUseCase
) {

    @PostMapping("/{couponId}")
    fun issueCoupon(
        @PathVariable couponId: Long,
        userId: Long
    ): ResponseEntity<Unit> {
        val issuedCoupon = issueCouponUseCase.issue(couponId, userId)
        return ResponseEntity
            .created(URI.create("${issuedCoupon.id}"))
            .build()
    }
}