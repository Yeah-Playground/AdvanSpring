package io.yeahx4.advanspring.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController {
    @PostMapping("/member")
    fun postMember(@RequestBody data: Map<String, Any>): String {
        val sb = StringBuilder()

        data.entries.forEach {
            sb.append("${it.key} : ${it.value}\n")
        }

        return sb.toString()
    }

    data class MemberDto(
        val id: Long,
        val username: String,
        val email: String,
    ) {
        override fun toString(): String = "${username}(${id}) $email"
    }

    @PostMapping("/dto")
    fun postMemberDto(@RequestBody memberDto: MemberDto) = memberDto.toString()
}
