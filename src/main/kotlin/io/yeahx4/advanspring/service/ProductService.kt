package io.yeahx4.advanspring.service

import io.yeahx4.advanspring.dto.ProductDto

interface ProductService {
    fun saveProduct(productName: String, productPrice: Int, productStock: Int): ProductDto
    fun getProduct(productId: Long): ProductDto
}
