package org.kwy.coupon.coupon.presentation.common

import org.kwy.coupon.common.exception.ForbiddenException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException::class)
    fun tooManyRequestException(forbiddenException: ForbiddenException) =
        ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body(forbiddenException)
}