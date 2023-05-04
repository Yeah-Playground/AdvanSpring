package io.yeahx4.advanspring.service.impl

import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@SuppressWarnings("unused")
class RestTemplateImpl {
    fun getUri(): String {
        val uri = UriComponentsBuilder
            .fromUriString("http://localhost:8000")
            .path("/api/test/get")
            .encode()
            .build()
            .toUri()
        val restTemplate = RestTemplate()
        val responseEntity = restTemplate.getForEntity(uri, String::class.java)
        val body = responseEntity.body

        return if (body.isNullOrBlank()) {
            ""
        } else {
            body
        }
    }

    fun getPathVar(name: String, mail: String): String {
        val uri = UriComponentsBuilder
            .fromUriString("http://localhost:8000")
            .path("/api/getname/{mail}/{name}")
            .encode()
            .build()
            .expand(mail, name)
            .toUri()

        val restTemplate = RestTemplate()
        val responseEntity = restTemplate.getForEntity(uri, String::class.java)
        val body = responseEntity.body

        return if (body.isNullOrBlank()) {
            ""
        } else {
            body
        }
    }

    fun postDto(): ResponseEntity<Any> {
        val uri = UriComponentsBuilder
            .fromUriString("http://localhost:8000")
            .path("/api/post")
            .encode()
            .build()
            .toUri()

        val dto = Any()

        return RestTemplate().postForEntity(uri, dto, Any::class.java)
    }

    fun postWithHeader(): ResponseEntity<Any> {
        val uri = UriComponentsBuilder
            .fromUriString("http://localhost:8000")
            .path("/api/header")
            .encode()
            .build()
            .toUri()

        val dto = Any()

        val reqEntity = RequestEntity
            .post(uri)
            .header("yeah", "oh-yeah")
            .body(dto)

        return RestTemplate().exchange(reqEntity, Any::class.java)
    }
}
