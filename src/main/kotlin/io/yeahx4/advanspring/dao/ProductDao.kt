package io.yeahx4.advanspring.dao

import io.yeahx4.advanspring.entity.ProductEntity

interface ProductDao {
    fun saveProduct(productEntity: ProductEntity): ProductEntity
    fun getProduct(productId: Long): ProductEntity
}
