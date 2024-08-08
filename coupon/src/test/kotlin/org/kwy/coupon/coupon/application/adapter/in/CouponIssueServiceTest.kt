package org.kwy.coupon.coupon.application.adapter.`in`

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.kwy.coupon.common.exception.ForbiddenException
import org.kwy.coupon.coupon.application.port.out.FindCouponPort
import org.kwy.coupon.coupon.application.port.out.IssueCouponPort
import org.kwy.coupon.coupon.domain.Coupon
import org.kwy.coupon.coupon.domain.CouponType
import org.kwy.coupon.coupon.domain.CouponUser
import org.kwy.coupon.coupon.domain.DiscountType
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate

@ExtendWith(MockitoExtension::class)
class CouponIssueServiceTest {
    @Mock
    lateinit var findCouponPort: FindCouponPort

    @Mock
    lateinit var issueCouponPort: IssueCouponPort

    @InjectMocks
    lateinit var couponIssueService: CouponIssueService

    @Test
    fun `사용자는 쿠폰을 발급할 수 있다`() {
        // given
        val coupon = Coupon(
            id = 1L,
            name = "Summer Sale Coupon",
            startDate = LocalDate.of(2024, 8, 1),
            endDate = LocalDate.of(2024, 8, 31),
            maxIssuePerUserCnt = 1,
            totalIssue = 1000,
            discountType = DiscountType.PERCENTAGE,
            discountValue = 10,
            maxDiscountAmount = 50,
            type = CouponType.PRODUCT,
            targets = listOf(101L, 102L, 103L)
        )
        val userId = 1L
        `when`(findCouponPort.getCouponById(1L)).then { coupon }
        `when`(findCouponPort.getTotalIssuedCouponCount(1L)).then { 10 }
        `when`(findCouponPort.getIssuedCouponCountPerUser(1L, userId)).then { 0 }
        val expected = CouponUser(1L, 1L, userId)
        `when`(issueCouponPort.issue(1L, userId)).then { expected }

        // when
        val result = couponIssueService.issue(1L, 1L)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `1인당 발급 가능한 쿠폰 수가 1개이고, 사용자가 해당 쿠폰을 2번 발급한다면 ForbiddenException을 반환한다`() {
        // given
        val coupon = Coupon(
            id = 1L,
            name = "Summer Sale Coupon",
            startDate = LocalDate.of(2024, 8, 1),
            endDate = LocalDate.of(2024, 8, 31),
            maxIssuePerUserCnt = 1,
            totalIssue = 1000,
            discountType = DiscountType.PERCENTAGE,
            discountValue = 10,
            maxDiscountAmount = 50,
            type = CouponType.PRODUCT,
            targets = listOf(101L, 102L, 103L)
        )
        val userId = 1L
        `when`(findCouponPort.getCouponById(1L)).then { coupon }
        `when`(findCouponPort.getTotalIssuedCouponCount(1L)).then { 10 }
        `when`(findCouponPort.getIssuedCouponCountPerUser(1L, userId)).then { 2 }


        // when, then
        assertThrows<ForbiddenException> {
            couponIssueService.issue(1L, 1L)
        }
    }

    @Test
    fun `발급 가능한 쿠폰 수가 10개이고, 사용자가 해당 쿠폰을 11번째로 발급한다면 ForbiddenException을 반환한다`() {
        // given
        val coupon = Coupon(
            id = 1L,
            name = "Summer Sale Coupon",
            startDate = LocalDate.of(2024, 8, 1),
            endDate = LocalDate.of(2024, 8, 31),
            maxIssuePerUserCnt = 1,
            totalIssue = 10,
            discountType = DiscountType.PERCENTAGE,
            discountValue = 10,
            maxDiscountAmount = 50,
            type = CouponType.PRODUCT,
            targets = listOf(101L, 102L, 103L)
        )
        val userId = 1L
        `when`(findCouponPort.getCouponById(1L)).then { coupon }
        `when`(findCouponPort.getTotalIssuedCouponCount(1L)).then { 10 }
        `when`(findCouponPort.getIssuedCouponCountPerUser(1L, userId)).then { 0 }


        // when, then
        assertThrows<ForbiddenException> {
            couponIssueService.issue(1L, 1L)
        }
    }
}