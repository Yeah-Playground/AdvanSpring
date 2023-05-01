package io.yeahx4.advanspring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// 반복되는 /hello가 싫다면
// @RequestMapping("/hello") 로 해결가능
@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello() = "Hello World"

    @GetMapping("/hello/name/{name}")
    fun helloName(@PathVariable name: String) = "Hello $name"

    @GetMapping("/hello/param")
    fun helloParam(
        @RequestParam name: String,
        @RequestParam email: String,
        @RequestParam corp: String
    ) = "Hello $name in $corp. Your email is $email"

    // 미리 알지 못하는 여러개의 param을 Map으로 관리하는 방법
    @GetMapping("/hello/unknown")
    fun helloParams(@RequestParam param: Map<String, String>): String {
        val sb = StringBuilder()

        param.entries.forEach {
            sb.append("${it.key} : ${it.value}\n")
        }

        return sb.toString()
    }

    // DTO
    data class MemberDto(
        val name: String,
        val email: String,
        val corp: String
    ) {
        override fun toString(): String = "$name - $email : ${corp}소속"
    }

    @GetMapping("/hello/dto")
    fun helloDto(dto: MemberDto) = dto.toString()
}
