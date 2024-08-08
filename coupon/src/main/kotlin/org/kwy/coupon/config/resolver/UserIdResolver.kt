package org.kwy.coupon.config.resolver

import jakarta.servlet.http.HttpServletRequest
import org.kwy.coupon.common.exception.UnauthorizedException
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


@Component
class UserIdResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean =
        parameter.hasParameterAnnotation(UserId::class.java)

    @OptIn(ExperimentalEncodingApi::class)
    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val request = webRequest.nativeRequest as HttpServletRequest
        val token = request.getHeader("Authorization")
        if (token == null || token.isBlank() || !token.startsWith("Basic ")) {
            throw UnauthorizedException("유효하지 않은 토큰입니다");
        }
        val encodedUserId = token.substring("Basic ".length)
        val decodedUserId = String(Base64.UrlSafe.decode(encodedUserId)).toLong()
        return decodedUserId
    }

}