package io.yeahx4.advanspring.dto

import io.yeahx4.advanspring.entity.ProductEntity

class ProductDto(
    val productName: String,
    val productPrice: Int,
    val productStock: Int,
) {
    fun toEntity(): ProductEntity = ProductEntity(-1, productName, productPrice, productStock)
}
