package org.kwy.coupon.coupon.presentation.common

import org.kwy.coupon.common.exception.ForbiddenException
import org.kwy.coupon.common.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException::class)
    fun forbiddenException(forbiddenException: ForbiddenException) =
        ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body(forbiddenException.message)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(notFoundException: NotFoundException) =
        ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(notFoundException.message)
}