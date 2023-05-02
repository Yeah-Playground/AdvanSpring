package io.yeahx4.advanspring.handler

import io.yeahx4.advanspring.entity.ProductEntity

interface ProductDataHandler {
    fun saveProductEntity(productName: String, productPrice: Int, productStock: Int): ProductEntity
    fun getProductEntity(productId: Long): ProductEntity
}
