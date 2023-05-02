package io.yeahx4.advanspring.controller

import io.yeahx4.advanspring.dto.ProductDto
import io.yeahx4.advanspring.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {
    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: String): ProductDto {
        return productService.getProduct(productId.toLong())
    }

    @PostMapping("/test")
    fun test() = "Hello World"

    @PostMapping("/")
    fun createProduct(@RequestBody productDto: ProductDto): ProductDto {
        val name = productDto.productName
        val price = productDto.productPrice
        val stock = productDto.productStock

        return productService.saveProduct(name, price, stock)
    }
}
