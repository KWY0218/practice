package org.kwy.coupon.coupon.persistence.entity

import jakarta.persistence.*
import org.kwy.coupon.coupon.domain.Coupon
import org.kwy.coupon.coupon.domain.CouponType
import org.kwy.coupon.coupon.domain.DiscountType
import java.time.LocalDate

@Table(name = "coupon")
@Entity
class CouponEntity(
    id: Long? = null,
    name: String,
    startDate: LocalDate,
    endDate: LocalDate,
    maxIssuePerUserCnt: Int,
    totalIssue: Int,
    discountType: DiscountType,
    discountValue: Int,
    maxDiscountAmount: Int? = null,
    type: CouponType
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        protected set

    @Column(nullable = false)
    var name = name
        protected set

    @Column(nullable = false)
    var startDate = startDate
        protected set

    @Column(nullable = false)
    var endDate = endDate
        protected set

    @Column(nullable = false)
    var maxIssuePerUserCnt = maxIssuePerUserCnt
        protected set

    @Column(nullable = false)
    var totalIssue = totalIssue
        protected set

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var discountType = discountType
        protected set

    @Column(nullable = false)
    var discountValue = discountValue
        protected set

    var maxDiscountAmount = maxDiscountAmount
        protected set

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var type = type
        protected set

    fun toCoupon(targets: List<Long>?): Coupon = Coupon(
        name = this.name,
        startDate = this.startDate,
        endDate = this.endDate,
        maxIssuePerUserCnt = this.maxIssuePerUserCnt,
        totalIssue = this.totalIssue,
        discountType = this.discountType,
        discountValue = this.discountValue,
        maxDiscountAmount = this.maxDiscountAmount,
        type = this.type,
        targets = targets
    )
}