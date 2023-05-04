package io.yeahx4.advanspring.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/exception")
class ExceptionController {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/")
    fun getException() {
        throw Exception()
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<Map<String, String>> {
        val responseHeaders = HttpHeaders()
        val httpStatus = HttpStatus.BAD_REQUEST

        logger.error(e.localizedMessage)
        logger.error("Exception in Controller!!")

        val map = mutableMapOf<String, String>()
        map.put("error type", httpStatus.reasonPhrase)
        map.put("code", "400")
        map.put("message", "Exception occured")

        return ResponseEntity(map, responseHeaders, httpStatus)
    }
}
